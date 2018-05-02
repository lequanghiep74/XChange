package org.knowm.xchange.exmo.service;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.UserTrade;
import org.knowm.xchange.utils.DateUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExmoTradeServiceRaw extends BaseExmoService {
    protected ExmoTradeServiceRaw(Exchange exchange) {
        super(exchange);
    }

    public List<LimitOrder> openOrders() {
        Map<String, List<Map<String, String>>> map = exmo.userOpenOrders(signatureCreator, apiKey, exchange.getNonceFactory());

        List<LimitOrder> openOrders = new ArrayList<>();

        for (String market : map.keySet()) {

            CurrencyPair currencyPair = adaptMarket(market);

            for (Map<String, String> order : map.get(market)) {
                Order.OrderType type = ExmoAdapters.adaptOrderType(order);
                BigDecimal amount = new BigDecimal(order.get("amount"));
                String id = order.get("order_id");
                BigDecimal price = new BigDecimal(order.get("price"));
                Date created = DateUtils.fromUnixTime(Long.valueOf(order.get("created")));

                openOrders.add(new LimitOrder(
                        type,
                        amount,
                        currencyPair,
                        id,
                        created,
                        price
                ));
            }
        }
        return openOrders;
    }

    public List<UserTrade> orderTrades(String orderId) {
        Map<String, Object> map = exmo.orderTrades(signatureCreator, apiKey, exchange.getNonceFactory(), orderId);

        List<UserTrade> userTrades = new ArrayList<>();

        for (Map<String, Object> tradeDatum : (List<Map<String, Object>>) map.get("trades")) {
            CurrencyPair market = adaptMarket(tradeDatum.get("pair").toString());
            Map<String, String> bodge = new HashMap<>();
            for (String key : tradeDatum.keySet()) {
                bodge.put(key, tradeDatum.get(key).toString());
            }
            userTrades.add(ExmoAdapters.adaptTrade(bodge, market));
        }

        return userTrades;
    }

    public List<UserTrade> trades(int limit, long offset, CurrencyPair currencyPair) {
        Map<String, List<Map<String, String>>> map = exmo.userTrades(signatureCreator, apiKey, exchange.getNonceFactory(),
                currencyPair == null ? null : format(currencyPair),
                offset,
                limit
        );

        List<UserTrade> trades = new ArrayList<>();
        for (String market : map.keySet()) {
            for (Map<String, String> tradeDatum : map.get(market)) {
                trades.add(ExmoAdapters.adaptTrade(tradeDatum, adaptMarket(market)));
            }
        }

        Collections.sort(trades, (o1, o2) -> o2.getTimestamp().compareTo(o1.getTimestamp()));
        return trades;
    }

}


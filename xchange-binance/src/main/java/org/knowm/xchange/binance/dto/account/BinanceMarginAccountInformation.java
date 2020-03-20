package org.knowm.xchange.binance.dto.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class BinanceMarginAccountInformation {
  private boolean borrowEnabled;
  private boolean tradeEnabled;
  private boolean transferEnabled;
  private BigDecimal marginLevel;
  private BigDecimal totalAssetOfBtc;
  private BigDecimal totalLiabilityOfBtc;
  private BigDecimal totalNetAssetOfBtc;
  private List<BinanceMarginAssets> userAssets;

  public BinanceMarginAccountInformation(
      @JsonProperty("borrowEnabled") boolean borrowEnabled,
      @JsonProperty("tradeEnabled") boolean tradeEnabled,
      @JsonProperty("transferEnabled") boolean transferEnabled,
      @JsonProperty("marginLevel") String marginLevel,
      @JsonProperty("totalAssetOfBtc") String totalAssetOfBtc,
      @JsonProperty("totalLiabilityOfBtc") String totalLiabilityOfBtc,
      @JsonProperty("totalNetAssetOfBtc") String totalNetAssetOfBtc,
      @JsonProperty("userAssets") List<BinanceMarginAssets> userAssets) {
    this.borrowEnabled = borrowEnabled;
    this.tradeEnabled = tradeEnabled;
    this.transferEnabled = transferEnabled;
    this.marginLevel = new BigDecimal(marginLevel);
    this.totalAssetOfBtc = new BigDecimal(totalAssetOfBtc);
    this.totalLiabilityOfBtc = new BigDecimal(totalLiabilityOfBtc);
    this.totalNetAssetOfBtc = new BigDecimal(totalNetAssetOfBtc);
    this.userAssets = userAssets;
  }

  public boolean isBorrowEnabled() {
    return borrowEnabled;
  }

  public void setBorrowEnabled(boolean borrowEnabled) {
    this.borrowEnabled = borrowEnabled;
  }

  public boolean isTradeEnabled() {
    return tradeEnabled;
  }

  public void setTradeEnabled(boolean tradeEnabled) {
    this.tradeEnabled = tradeEnabled;
  }

  public boolean isTransferEnabled() {
    return transferEnabled;
  }

  public void setTransferEnabled(boolean transferEnabled) {
    this.transferEnabled = transferEnabled;
  }

  public BigDecimal getMarginLevel() {
    return marginLevel;
  }

  public void setMarginLevel(BigDecimal marginLevel) {
    this.marginLevel = marginLevel;
  }

  public BigDecimal getTotalAssetOfBtc() {
    return totalAssetOfBtc;
  }

  public void setTotalAssetOfBtc(BigDecimal totalAssetOfBtc) {
    this.totalAssetOfBtc = totalAssetOfBtc;
  }

  public BigDecimal getTotalLiabilityOfBtc() {
    return totalLiabilityOfBtc;
  }

  public void setTotalLiabilityOfBtc(BigDecimal totalLiabilityOfBtc) {
    this.totalLiabilityOfBtc = totalLiabilityOfBtc;
  }

  public BigDecimal getTotalNetAssetOfBtc() {
    return totalNetAssetOfBtc;
  }

  public void setTotalNetAssetOfBtc(BigDecimal totalNetAssetOfBtc) {
    this.totalNetAssetOfBtc = totalNetAssetOfBtc;
  }

  public List<BinanceMarginAssets> getUserAssets() {
    return userAssets;
  }

  public void setUserAssets(List<BinanceMarginAssets> userAssets) {
    this.userAssets = userAssets;
  }
}

package org.knowm.xchange.binance.dto.account;

import java.util.List;

public class BasePageResponse<T> {
  private List<T> rows;
  private int total;

  public BasePageResponse() {}

  public List<T> getRows() {
    return rows;
  }

  public void setRows(List<T> rows) {
    this.rows = rows;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }
}

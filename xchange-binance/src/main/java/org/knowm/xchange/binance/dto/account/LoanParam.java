package org.knowm.xchange.binance.dto.account;

public class LoanParam {
  private String asset;
  private Integer size;

  public LoanParam() {}

  public String getAsset() {
    return asset;
  }

  public void setAsset(String asset) {
    this.asset = asset;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }
}

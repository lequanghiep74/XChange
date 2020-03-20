package org.knowm.xchange.binance.dto.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class BinanceMarginAssets {
  private String asset;
  private BigDecimal borrowed;
  private BigDecimal free;
  private BigDecimal interest;
  private BigDecimal locked;
  private BigDecimal netAsset;

  public BinanceMarginAssets() {}

  public BinanceMarginAssets(
      @JsonProperty("asset") String asset,
      @JsonProperty("borrowed") String borrowed,
      @JsonProperty("free") String free,
      @JsonProperty("interest") String interest,
      @JsonProperty("locked") String locked,
      @JsonProperty("netAsset") String netAsset) {
    this.asset = asset;
    this.borrowed = new BigDecimal(borrowed);
    this.free = new BigDecimal(free);
    this.interest = new BigDecimal(interest);
    this.locked = new BigDecimal(locked);
    this.netAsset = new BigDecimal(netAsset);
  }

  public String getAsset() {
    return asset;
  }

  public void setAsset(String asset) {
    this.asset = asset;
  }

  public BigDecimal getBorrowed() {
    return borrowed;
  }

  public void setBorrowed(BigDecimal borrowed) {
    this.borrowed = borrowed;
  }

  public BigDecimal getFree() {
    return free;
  }

  public void setFree(BigDecimal free) {
    this.free = free;
  }

  public BigDecimal getInterest() {
    return interest;
  }

  public void setInterest(BigDecimal interest) {
    this.interest = interest;
  }

  public BigDecimal getLocked() {
    return locked;
  }

  public void setLocked(BigDecimal locked) {
    this.locked = locked;
  }

  public BigDecimal getNetAsset() {
    return netAsset;
  }

  public void setNetAsset(BigDecimal netAsset) {
    this.netAsset = netAsset;
  }
}

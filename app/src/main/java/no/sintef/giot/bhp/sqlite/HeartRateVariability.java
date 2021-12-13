package no.sintef.giot.bhp.sqlite;

import com.opencsv.bean.CsvBindByName;

public class HeartRateVariability {

  @CsvBindByName(column = "timestamp")
  private String timestamp;

  @CsvBindByName(column = "rmssd")
  private String rmssd;

  @CsvBindByName(column = "coverage")
  private String coverage;

  @CsvBindByName(column = "low_frequency")
  private String lowFrequency;

  @CsvBindByName(column = "high_frequency")
  private String highFrequency;

  //  getters, setters, toString

  public String getTimestamp() {
    return this.timestamp;
  }

  public void setTimestamp(String aTimestamp) {
    this.timestamp = aTimestamp;
  }

  public String getRmssd() {
    return this.rmssd;
  }

  public void setRmssd(String aRmssd) {
    this.rmssd = aRmssd;
  }

  public String getCoverage() {
    return this.coverage;
  }

  public void setCoverage(String aCoverage) {
    this.coverage = aCoverage;
  }

  public String getLowFrequency() {
    return this.lowFrequency;
  }

  public void setLowFrequency(String aLowFrequency) {
    this.lowFrequency = aLowFrequency;
  }

  public String getHighFrequency() {
    return this.highFrequency;
  }

  public void setHighFrequency(String aHighFrequency) {
    this.highFrequency = aHighFrequency;
  }
}

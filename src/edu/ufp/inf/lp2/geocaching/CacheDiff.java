package edu.ufp.inf.lp2.geocaching;

enum CacheDiff {

  Easy("The difficulty is easy!"),

  Medium("The difficulty is medium!"),

  Hard("The difficulty is hard!");

  private final String cacheDiff;

  CacheDiff(String cacheDiff) {
    this.cacheDiff = cacheDiff;
  }

  public String getCacheDiff() {
    return cacheDiff;
  }
}
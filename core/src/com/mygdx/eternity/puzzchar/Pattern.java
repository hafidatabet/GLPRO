package com.mygdx.eternity.puzzchar;

public enum Pattern {
  TRIANGLE("triangle"),
  ZIGZAG("zigzag"),
  CROWN("couronne"),
  LINES("lignes");
  
  private String code;
  
  private Pattern(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }
  
  public static Pattern getByCode(String code) {
    for(Pattern pattern : values()) {
      if(pattern.getCode().equalsIgnoreCase(code)) {
        return pattern;
      }
    }
    return null;
  }
  
}

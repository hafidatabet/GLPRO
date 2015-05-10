package com.mygdx.eternity.puzzchar;

public enum FaceType {
  EDGE("B"),
  FACE("F");
  
  private String code;
  
  private FaceType(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }

  public static FaceType getByCode(String code) {
    for(FaceType type : values()) {
      if(type.getCode().equalsIgnoreCase(code)) {
        return type;
      }
    }
    throw new EnumConstantNotPresentException(FaceType.class, code);
  }
  
}

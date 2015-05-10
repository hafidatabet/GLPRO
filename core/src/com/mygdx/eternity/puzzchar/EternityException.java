package com.mygdx.eternity.puzzchar;

public class EternityException extends Exception {

  private static final long serialVersionUID = 1L;

  public EternityException(String message) {
    super(message);
  }

  public EternityException(Throwable cause) {
    super(cause);
  }

  public EternityException(String message, Throwable cause) {
    super(message, cause);
  }
}

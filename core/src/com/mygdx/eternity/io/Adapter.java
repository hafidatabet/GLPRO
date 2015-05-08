package com.mygdx.eternity.io;

public interface Adapter<T> {

  public T getAsObject(String s) throws CsvException;
  public String getAsString(T object) throws CsvException;
}

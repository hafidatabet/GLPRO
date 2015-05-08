package com.mygdx.eternity.puzzchar;

public abstract class Item {

  private int id;
  
  public Item(int id) {
    this.id = id;
  }
  
  public int getId() {
    return id;
  }
}

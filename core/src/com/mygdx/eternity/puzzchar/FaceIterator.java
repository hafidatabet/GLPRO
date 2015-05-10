package com.mygdx.eternity.puzzchar;

import java.util.Iterator;

public class FaceIterator implements Iterator<Face> {

  private Piece piece;
  private int ordinal;
  
  public FaceIterator(Piece piece) {
    this.piece = piece;
  }
  
  @Override
  public boolean hasNext() {
    return (ordinal < Orientation.values().length);
  }

  @Override
  public Face next() {
    Orientation orientation = Orientation.values()[ordinal++];
    return piece.getFace(orientation);
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }
}

package com.mygdx.eternity.gui;

import java.awt.Graphics;

import com.mygdx.eternity.puzzchar.Face;

public class PatternlessFace extends JFace {

  private static final long serialVersionUID = 1L;

  public PatternlessFace(Face face) {
    super(face);
  }

  @Override
  public void paintPattern(Graphics g) {
    //nothing!
  }
}

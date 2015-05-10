package com.mygdx.eternity.gui;

import com.mygdx.eternity.puzzchar.Face;
import com.mygdx.eternity.puzzchar.Pattern;

public class JFaceFactory {

  public static JFace create(Face face) {
    Pattern pat = face.getPattern();
    if(pat != null) {
      switch (pat) {
      case TRIANGLE:
        return new TriangleFace(face);
  
      case ZIGZAG:
        return new ZigzagFace(face);
  
      case CROWN:
        return new CrownFace(face);
  
      case LINES:
        return new LinesFace(face);
        
      default:
        return null; //will end up on a NPE in the short run
      }
    }
    else {
      return new PatternlessFace(face);
    }
  }
}

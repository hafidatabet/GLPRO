/**
 * 
 */
package com.mygdx.eternity.screens;



import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;

import com.mygdx.eternity.puzzchar.Piece;
import com.mygdx.eternity.gui.JPiece;
import com.mygdx.eternity.io.PiecesDao;

public class Testme {

	Testme () throws Exception {
		
    JFrame frame = new JFrame();
    JPiece jpiece = null;
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(100, 100, 450, 450);
        
    /*Face f0 = new Face(1, Color.green, Pattern.CROWN, Color.darkGray);
    Face f1 = new Face(1, Color.yellow, Pattern.LINES, Color.blue);
    Face f2 = new Face(2, Color.red, Pattern.TRIANGLE, Color.white);
    Face f3 = new Face(3, Color.blue, Pattern.ZIGZAG, Color.green);
    Piece piece = new Piece(1, f0, f1, f2, f3, Orientation.SOUTH).rotateClockwise().rotateClockwise();*/
    
    PiecesDao piece = new PiecesDao();
    List<Piece> pieces = null;
	try {
		pieces = piece.findPieces();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    
     
	
	jpiece = new JPiece(pieces.get(0));
    
    jpiece.setPreferredSize(new Dimension(200, 200));
    frame.setContentPane(jpiece);
    
    frame.pack();
    frame.setVisible(true);
  }
}


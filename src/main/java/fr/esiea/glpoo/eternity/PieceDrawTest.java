package fr.esiea.glpoo.eternity;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.esiea.glpoo.eternity.domain.Piece;
import fr.esiea.glpoo.eternity.gui.JPiece;
import fr.esiea.glpoo.eternity.io.PiecesDao;

public class PieceDrawTest {

  public static void main(String... args) throws Exception {
    JFrame frame = new JFrame();
    JPiece jpiece = null;
    JPanel jpanel = new JPanel();
    JButton button = new JButton();
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(100, 100, 450, 450);
    PiecesDao piece = new PiecesDao();
    List<Piece> pieces = piece.findPieces();
    
	jpiece = new JPiece(pieces.get(0));
	System.out.println(jpiece.toString());
	jpiece.setPreferredSize(new Dimension(100, 100));
	
	jpanel.add(jpiece);
	
	button.add(jpanel);
	button.setPreferredSize(new Dimension(100, 100));
    
    frame.setContentPane(button);
    
    frame.pack();
    frame.setVisible(true);
  }
}

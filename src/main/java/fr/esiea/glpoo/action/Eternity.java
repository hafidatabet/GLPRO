package fr.esiea.glpoo.action;

import fr.esiea.glpoo.eternity.domain.Piece;
import fr.esiea.glpoo.eternity.gui.JPiece;
import fr.esiea.glpoo.eternity.io.PiecesDao;
import fr.glpoo.resources.Help;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Eternity extends JFrame implements KeyListener,ActionListener,MouseListener{
	
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;


	private final int size = 4;
	
	
	private JPanel panel;
	private JFrame frame;
	private JButton restart;
	private JButton help; 	
	private JButton Rotate;
	private JLabel time = new JLabel("00:00");
	private JButton[][] PiecePlat;
	private JButton[][] PieceDec;


	
	public Eternity() {
		
		//Start The Game
		renderGame();
		
		//Made The different grouds for our Game
	    creat_plat(size,size);
	    creat_dec(size,size);
        
        //displayg stuff
        frame.setSize(677, 463);
		frame.setVisible(true);	
		frame.setResizable(false);
		
		//instanciate Timer		
		timer1 = new Timer(1000, tache_timer);		
		//Fires the Timer
		timer1.start();     
		
	}
	
	
	private void renderGame(){	
		
		// create the window
		
		frame = new JFrame("Eternity II Game");  
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	    
	    panel = (JPanel)frame.getContentPane();  
	    panel.setLayout(null);
	    
	    //timer
		Font font = new Font("Arial",Font.BOLD,33);
		time.setFont(font);		
		time.setBounds(505,30,500,30);	
		
		// Restart button
	    restart = new JButton("Restart");	 
        restart.addActionListener(this);
        restart.setBounds(440, 85, 215,30);
        
        // Help button 
        help = new JButton("Help");
        help.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				Help.main();
			}
		});        
        help.setBounds(440,120, 215,30);
        
        // Rotate button
        Rotate = new JButton("Rotate");       
        Rotate.addActionListener(this);
        Rotate.setBounds(440, 155, 215,30);
        
        // Add stuff to the main panel
        panel.add(time);
        panel.add(restart);
        panel.add(help);
        panel.add(Rotate);                
      
	}
	
	/** Shuffles a 2D array with the same number of columns for each row. */
	public static void shuffle(JPiece[][] matrix, int columns, Random rnd) {
	    int size = matrix.length * columns;
	    for (int i = size; i > 1; i--)
	        swap(matrix, columns, i - 1, rnd.nextInt(i));
	}
	
	/** 
	 * Swaps two entries in a 2D array, where i and j are 1-dimensional indexes, looking at the 
	 * array from left to right and top to bottom.
	 */
	public static void swap(JPiece[][] matrix, int columns, int i, int j) {
	    JPiece tmp = matrix[i / columns][i % columns];
	    matrix[i / columns][i % columns] = matrix[j / columns][j % columns];
	    matrix[j / columns][j % columns] = tmp;
	}
	
		
	private void creat_plat(int x, int y){
		
		PiecePlat = new JButton[size][size];
  
	    PiecesDao piece = new PiecesDao();
	    List<Piece> pieces = null;
		try {
			pieces = piece.findPieces();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JPiece jpieces[][] = new JPiece[6][6];
		
		for(int i=0; i<6 ; i++){
			for(int j=0; j<6 ; j++){
				//JPiece jpiece = new JPiece(pieces.get(i));
				//jpieces[i][j] = jpiece;				
			}
		}
		
		shuffle(jpieces, size, new Random());
		
		
		// buttons and Game ground stuff for the right side of the Panel
		for(int i=0; i<x ; i++){
			for(int j=0; j<y ; j++){	
				//bouton
				PiecePlat[i][j] = new JButton();			    
				PiecePlat[i][j].addActionListener(this); 
				PiecePlat[i][j].addMouseListener(this); 
				PiecePlat[i][j].setBounds(5+5*i+100*i, 5+5*j+100*j, 100,100);
				PiecePlat[i][j].setContentAreaFilled(false); 
				panel.add(PiecePlat[i][j]);
				
				//image				
				//jpieces[i][j].setBounds(5+5*i+100*i, 5+5*j+100*j, 100,100);	
				//panel.add(jpieces[i][j]);
			}
		}		
	}
	
	
	private void creat_dec(int x, int y){
		
		PieceDec = new JButton[size][size];
		
		PiecesDao piece = new PiecesDao();
	    List<Piece> pieces = null;
		try {
			pieces = piece.findPieces();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JPiece jpieces[][] = new JPiece[6][6];
		
		for(int i=0; i<6 ; i++){
			for(int j=0; j<6 ; j++){
				JPiece jpiece = new JPiece(pieces.get(i));
				jpieces[i][j] = jpiece;				
			}
		}
		
		shuffle(jpieces, size, new Random());
		
		// create buttons of the 2nd Matrix
		
	    for(int i=0; i<x ; i++){
			for(int j=0; j<y ; j++){		
				//bouton
				PieceDec[i][j] = new JButton();			
				PieceDec[i][j].addActionListener(this); 
			    PieceDec[i][j].addMouseListener(this); 			    
			    PieceDec[i][j].setBounds(440+5*i+50*i, 205+5*j+50*j, 50,50); 
			    PieceDec[i][j].setContentAreaFilled(false);	
			    panel.add(PieceDec[i][j]);
			    //image		   
			    jpieces[i][j].setBounds(440+5*i+50*i, 205+5*j+50*j, 50,50);	
			    panel.add(jpieces[i][j]);
			}
		}	 
     }
	
	
	 //Timer
		Timer timer1;
	    int var_time = 0;
	    ActionListener tache_timer = new ActionListener()  {
			  public void actionPerformed(ActionEvent e1)  {
				  
				  var_time++;				  
				  int minute = var_time/60;
		          int seconde = var_time - (minute*60);
		          String sm = Integer.toString(minute);
		          if (minute < 10){ sm = "0" + Integer.toString(minute);}
		          String ss = Integer.toString(seconde);
		          if (seconde < 10){ ss = "0" + Integer.toString(seconde);}
				  
				  time.setText(sm+":"+ss);		 
			 }
	     };		 
	     	
	
	//Evenement	
	private Piece last=null;
	

	public void keyPressed(KeyEvent arg0) {
		int key = arg0.getKeyCode();	
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub	
	}

		public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub		
	}


		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}



}

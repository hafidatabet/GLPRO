package fr.esiea.glpoo.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;

public class Menu extends JFrame{

	private JPanel menu = new JPanel();
	private JButton start = new JButton("Start the game");
	
	public Menu(){
		this.setSize(677, 463);
		this.setVisible(true);	
		this.setResizable(false);
	}

}

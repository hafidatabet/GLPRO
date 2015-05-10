package com.mygdx.eternity.gui;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import com.mygdx.eternity.puzzchar.Piece;
import com.mygdx.eternity.puzzchar.Puzzle;

public class PuzzleTable extends JTable {

  private static final long serialVersionUID = 1L;

  public PuzzleTable(Puzzle puzzle) {
    this( new PuzzleTableModel(puzzle));
  }
  
  public PuzzleTable(PuzzleTableModel tableModel) {
    super(tableModel);
    setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    setDefaultRenderer(Piece.class, new PieceCellRenderer());
  }
  
  @Override
  public PuzzleTableModel getModel() {
    return (PuzzleTableModel)super.getModel();
  }

  @Override
  public Piece getValueAt(int row, int column) {
    return (Piece)super.getValueAt(row, column);
  }
}

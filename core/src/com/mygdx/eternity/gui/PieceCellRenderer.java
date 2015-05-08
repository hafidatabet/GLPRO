package com.mygdx.eternity.gui;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import com.mygdx.eternity.puzzchar.Piece;

/**
 * Renderer for all pieces, simply forcing the use of JPiece at all times
 */
public class PieceCellRenderer extends DefaultTableCellRenderer {

  private static final long serialVersionUID = 1L;

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    //Screw that! return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    return new JPiece((Piece)value);
  }
}
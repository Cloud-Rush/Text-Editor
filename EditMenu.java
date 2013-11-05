
//All these extra imports are to make the pre-defined
//buttons for cut/copy/paste/undo/redo function
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import javax.swing.undo.*;

public class EditMenu {  
	
	//private AbstractDocument doc;
	private UndoManager undo = new UndoManager();
	private UndoAction undoAction;
	private RedoAction redoAction;
	
  // adds the edit menu to the menu bar        
  public JMenuBar addEditMenu(JMenuBar menubar) {

    // add the edit menu
    JMenuItem menuItem = null;
    JMenu edit = new JMenu("Edit");
    edit.setMnemonic(KeyEvent.VK_E);

    menuItem = new JMenuItem(new DefaultEditorKit.CutAction());
    menuItem.setText("Cut");
    menuItem.setMnemonic(KeyEvent.VK_X);
    edit.add(menuItem);

    menuItem = new JMenuItem(new DefaultEditorKit.CopyAction());
    menuItem.setText("Copy");
    menuItem.setMnemonic(KeyEvent.VK_C);
    edit.add(menuItem);

    menuItem = new JMenuItem(new DefaultEditorKit.PasteAction());
    menuItem.setText("Paste");
    menuItem.setMnemonic(KeyEvent.VK_P);
    edit.add(menuItem);
    
    edit.addSeparator();
    
    undoAction = new UndoAction();
    edit.add(undoAction);

    redoAction = new RedoAction();
    edit.add(redoAction);
    
	//doc.addUndoableEditListener(new MyUndoableEditListener());
	
	// add file to the menubar
    menubar.add(edit);
    
    return menubar;
  }
    
    class UndoAction extends AbstractAction {
        public UndoAction() {
            super("Undo");
            setEnabled(false);
        }
 
        public void actionPerformed(ActionEvent e) {
            try {
                undo.undo();
            } catch (CannotUndoException ex) {
                System.out.println("Unable to undo: " + ex);
                ex.printStackTrace();
            }
            updateUndoState();
            redoAction.updateRedoState();
        }
 
        protected void updateUndoState() {
            if (undo.canUndo()) {
                setEnabled(true);
                putValue(Action.NAME, undo.getUndoPresentationName());
            } else {
                setEnabled(false);
                putValue(Action.NAME, "Undo");
            }
        }
    }
    
  class RedoAction extends AbstractAction {
        public RedoAction() {
            super("Redo");
            setEnabled(false);
        }
 
        public void actionPerformed(ActionEvent e) {
            try {
                undo.redo();
            } catch (CannotRedoException ex) {
                System.out.println("Unable to redo: " + ex);
                ex.printStackTrace();
            }
            updateRedoState();
            undoAction.updateUndoState();
        }
 
        protected void updateRedoState() {
            if (undo.canRedo()) {
                setEnabled(true);
                putValue(Action.NAME, undo.getRedoPresentationName());
            } else {
                setEnabled(false);
                putValue(Action.NAME, "Redo");
            }
        }
    }

  protected class MyUndoableEditListener implements UndoableEditListener {
	  public void undoableEditHappened(UndoableEditEvent e) {
		//Remember the edit and update the menus
		undo.addEdit(e.getEdit());
		undoAction.updateUndoState();
		redoAction.updateRedoState();
	  }
  }
}

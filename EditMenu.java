
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

public class EditMenu
{  
	
	private UndoManager undo = new UndoManager();
	private UndoAction undoAction;
	private RedoAction redoAction;
	
  // adds the edit menu to the menu bar        
  public JMenuBar addEditMenu(JMenuBar menubar)
  {

    // add the edit menu
    JMenuItem menuItem = null;
    JMenu edit = new JMenu("Edit");
    edit.setMnemonic(KeyEvent.VK_E);

    //adds built-in cut function
    menuItem = new JMenuItem(new DefaultEditorKit.CutAction());
    menuItem.setText("Cut");
    menuItem.setMnemonic(KeyEvent.VK_X);
    edit.add(menuItem);

    //adds built-in copy function
    menuItem = new JMenuItem(new DefaultEditorKit.CopyAction());
    menuItem.setText("Copy");
    menuItem.setMnemonic(KeyEvent.VK_C);
    edit.add(menuItem);

    //adds built-in paste function
    menuItem = new JMenuItem(new DefaultEditorKit.PasteAction());
    menuItem.setText("Paste");
    menuItem.setMnemonic(KeyEvent.VK_P);
    edit.add(menuItem);
    
    //adds separator between cut/copy/paste and undo/redo
    edit.addSeparator();
    
    //adds built-in undoAction function
    undoAction = new UndoAction();
    edit.add(undoAction);

    //adds built-in redoAction function
    redoAction = new RedoAction();
    edit.add(redoAction);
    
    //creates instance of the JTextArea in order to allow undo/redo functionality
    JTextArea page = TextBox.getInstance();
    page.getDocument().addUndoableEditListener(new MyUndoableEditListener());
	
	// add file to the menubar
    menubar.add(edit);
    
    return menubar;
  }
    
    class UndoAction extends AbstractAction
    {
        public UndoAction() 
        {
            super("Undo");
            setEnabled(false);
        }
 
        //tracks if action can be "undone"
        public void actionPerformed(ActionEvent e) 
        {
            try 
            {
                undo.undo();
            }
            catch (CannotUndoException ex)
            {
                System.out.println("Unable to undo: " + ex);
                ex.printStackTrace();
            }
            updateUndoState();
            redoAction.updateRedoState();
        }
 
        //updates that "undoable" action is doable
        protected void updateUndoState() 
        {
            if (undo.canUndo()) 
            {
                setEnabled(true);
                putValue(Action.NAME, undo.getUndoPresentationName());
            }
            else 
            {
                setEnabled(false);
                putValue(Action.NAME, "Undo");
            }
        }
    }
    
  class RedoAction extends AbstractAction 
  {
	  //creates RedoAction
        public RedoAction() 
        {
            super("Redo");
            setEnabled(false);
        }
 
        //tracks if action can be "redone"
        public void actionPerformed(ActionEvent e) 
        {
            try 
            {
                undo.redo();
            } 
            catch (CannotRedoException ex) 
            {
                System.out.println("Unable to redo: " + ex);
                ex.printStackTrace();
            }
            updateRedoState();
            undoAction.updateUndoState();
        }
 
        //updates that "redoable" action is doable
        protected void updateRedoState() 
        {
            if (undo.canRedo()) 
            {
                setEnabled(true);
                putValue(Action.NAME, undo.getRedoPresentationName());
            }
            else
            {
                setEnabled(false);
                putValue(Action.NAME, "Redo");
            }
        }
    }

  //creates undoableEditListener to track undo and redo actions
  protected class MyUndoableEditListener implements UndoableEditListener 
  {
	  public void undoableEditHappened(UndoableEditEvent e) 
	  {
		//Remember the edit and update the menus
		undo.addEdit(e.getEdit());
		undoAction.updateUndoState();
		redoAction.updateRedoState();
	  }
  }
}


//All these extra imports are to make the cut/copy/paste buttons function
//Also (hopefully) covers undo/redo
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import javax.swing.undo.*;

public class EditMenu {  
        
  // adds the file menu to the menu bar        
  public static JMenuBar addEditMenu(JMenuBar menubar) {

    // add the file menu
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
    
    // add file to the menubar
    menubar.add(edit);
    
    return menubar;

   
  }
}

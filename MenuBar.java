import java.awt.event.*;                                                                                               
import javax.swing.*;



public class MenuBar {
	
	
	// adds drop down menus to the menu bar
	 public JMenuBar addMenuBar() {
	   // create the menu bar
     JMenuBar menuBar = new JMenuBar( );
     
     FileMenu file = new FileMenu();
     menuBar = file.addFileMenu(menuBar);
     
     // add other drop down menus here.
     
     EditMenu edit = new EditMenu();
     menuBar = edit.addEditMenu(menuBar);
     
    return menuBar;
    
	 }
}

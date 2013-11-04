import java.awt.event.*;                                                                                               
import javax.swing.*;



public class MenuBar {
	
	
	// adds drop down menus to the menu bar
	 public static JMenuBar addMenuBar() {
	   // create the menu bar
     JMenuBar menubar = new JMenuBar( );
     
     
     menubar = FileMenu.addFileMenu(menubar);
     
     // add other drop down menus here.
     
     //menubar = EditMenu.addEditMenu(menubar);
     
    return menubar;
    
	 }
}

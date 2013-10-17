import java.awt.event.*;                                                                                               
import javax.swing.*;

public class FileMenu {

	
	
  // adds the file menu to the menu bar	
  public static JMenuBar addFileMenu(JMenuBar menubar) {
    

   

    // add the file menu
    JMenu file = new JMenu("File");
    file.setMnemonic(KeyEvent.VK_F);

    // add a menu item
    JMenuItem exit = new JMenuItem("Exit", null);
    exit.setMnemonic(KeyEvent.VK_E);
    exit.setToolTipText("Exit the program");
    
    // add the action as a new anonymous object
    exit.addActionListener(new ActionListener( ) {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }   
    }); 
    file.add(exit);

    // add file to the menubar
    menubar.add(file);
    
    return menubar;

   
  }
}
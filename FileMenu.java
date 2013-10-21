import java.awt.event.*;                                                                                               
import javax.swing.*;
import java.io.*;

public class FileMenu {

	
	
  // adds the file menu to the menu bar	
  public static JMenuBar addFileMenu(JMenuBar menubar) {
    

    String text ="hello";

    // add the file menu
    JMenu file = new JMenu("File");
    file.setMnemonic(KeyEvent.VK_F);

    // add a menu item
    JMenuItem exit = new JMenuItem("Exit", null);
    exit.setMnemonic(KeyEvent.VK_E);
    exit.setToolTipText("Exit the program");
    
    JMenuItem save = new JMenuItem("Save", null);
    exit.setMnemonic(KeyEvent.VK_S);
    exit.setToolTipText("Save the file with a default name");
    
    JMenuItem saveAs = new JMenuItem("Save as...", null);
    exit.setMnemonic(KeyEvent.VK_S);
    exit.setToolTipText("Save the file with a custom name");
    
    JMenuItem load = new JMenuItem("Load", null);
    exit.setMnemonic(KeyEvent.VK_L);
    exit.setToolTipText("Loads a file");
    
    JMenuItem search = new JMenuItem("Search",null);
    exit.setMnemonic(KeyEvent.VK_X);
    exit.setToolTipText("Searches for given text");
    
    
    // add the action as a new anonymous object
    exit.addActionListener(new ActionListener( ) {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }   
    }); 
    
   
    
    save.addActionListener(new ActionListener( ) {
    	
    	
    	int count = 1;
    	
        public void actionPerformed(ActionEvent e) {
         
        try{
        PrintWriter out = new PrintWriter("filename"+count+".txt");	
        out.println("hello");	
        out.close();
        
        } catch(IOException a){
        	
        }
        }
        
           
      }); 
    
    
    saveAs.addActionListener(new ActionListener( )) {
        public void actionPerformed(ActionEvent e) {
          System.exit(0);
        }   
      }); 
    
    load.addActionListener(new ActionListener( ) {
        public void actionPerformed(ActionEvent e) {
          System.exit(0);
        }   
      }); 
    search.addActionListener(new ACtionListener() {
    	public void actionPerformed(ACtion Event e) {
    		JLabel label = new JLabel("Enter text to search");
    		JTextField searchBox = new JTextField();
    		frame.add(label);
    		frame.add(searchBox);
    	}
    }
    
    
    file.add(load);
    file.add(save);
    file.add(saveAs);
    file.add(exit);
    file.add(search);

    
    
    // add file to the menubar
    menubar.add(file);
    
    return menubar;

   
  }
}

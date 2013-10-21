                                                                                              
import javax.swing.*;

import java.awt.*;


public class TextMain {

	
	public static void main(String[] args) {
		
		
		int width = 300;
		int height = 200;
		
		JFrame frame = new JFrame("Text Editor!");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    JMenuBar menubar = new JMenuBar( );
		// creates menu bar with all drop down menus
	    menubar = MenuBar.addMenuBar();
	    
	    // add text box
	    JLabel search = new JLabel("Enter text to search")
	    JTextField searchBox = new JTextField()
	    JButton button = new JButton("Press to Search")
	    JTextField page = new JTextField(50);
	    
	    
	    
	    // add the menubar to the window
	    frame.setJMenuBar(menubar);

	    // set other things
	    frame.setTitle("Text Editor!");
	    frame.setSize(width, height);
	    
	    
	    
	     Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((int)dim.getWidth()/2-(width/2),(int)dim.getHeight()/2-(height/2));
	    
	    
	    
	    // launch the windwo
	    frame.setVisible(true);
	    
		
		
	}
	
	
	
	
}

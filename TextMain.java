                                                                                              
import javax.swing.*;



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
	    
	    
	    
	    
	    // add the menubar to the window
	    frame.setJMenuBar(menubar);

	    // set other things
	    frame.setTitle("Text Editor!");
	    frame.setSize(width, height);
	    
	    // launch the windwo
	    frame.setVisible(true);
	    
		
		
	}
	
	
	
	
}

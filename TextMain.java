import javax.swing.*;

import java.awt.*;


public class TextMain {


        public static void main(String[] args) {


                int width = 500;
                int height = 400;

                JFrame frame = new JFrame("Text Editor!");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JMenuBar jMenu = new JMenuBar( );
                MenuBar menuBar = new MenuBar( );
                // creates menu bar with all drop down menus
                jMenu = menuBar.addMenuBar();
                
                
                // add text box
                JTextArea page = TextBox.getInstance();
                page.setEditable(true);
                page.setLineWrap(true);

                // add the menubar to the window
                frame.setJMenuBar(jMenu);

                // set other things
                frame.setTitle("Text Editor!");
                frame.setSize(width, height);
                frame.getContentPane().add(page);
                
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                frame.setLocation((int)dim.getWidth()/2-(width/2),(int)dim.getHeight()/2-(height/2));

                // launch the window
                frame.setVisible(true);



        }




}

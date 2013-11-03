
import javax.swing.*;


class TextBox {
  //the instace is a private variable inside the class
    private static final JTextArea instance = new JTextArea( );
 
      // return the instance
        public static JTextArea getInstance( ) {
            return instance;
              }
 
                // private constructor (so it can't be called outside!)
                  private TextBox( ) { }
 
                            }

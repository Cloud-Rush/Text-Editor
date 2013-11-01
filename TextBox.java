
import javax.swing.*;


class TextBox {
  //the instace is a private variable inside the class
    private static final JTextField instance = new JTextField( );
 
      // return the instance
        public static JTextField getInstance( ) {
            return instance;
              }
 
                // private constructor (so it can't be called outside!)
                  private TextBox( ) { }
 
                            }

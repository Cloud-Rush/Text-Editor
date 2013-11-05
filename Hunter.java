import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.text.*;
import javax.swing.event.*;
import javax.swing.GroupLayout.*;

class Hunter 
{
    final static Color  HILIT_COLOR = Color.LIGHT_GRAY;
    //final Color entryBg;
    final Highlighter hilit;
    final Highlighter.HighlightPainter painter;
    public Hunter()
    {
    	hilit = new DefaultHighlighter();
    	painter = new DefaultHighlighter.DefaultHighlightPainter(HILIT_COLOR);
    }
    public void search(JTextArea textArea, String prey)
    {
      hilit.removeAllHighlights();
      String searchable = prey;
      if(searchable.length() <= 0)
      {
        SJOptionPane.showMessageDialog(null,"Nothing to search.");
      }
      String doc = textArea.getText();
      int index = doc.indexOf(searchable,0);
      if(index >= 0)
      {
    	try
    	{
    		int end = index + searchable.length();
        		hilit.addHighlight(index, end, painter);
        		textArea.setCaretPosition(end);
        		JOptionPane.showMessageDialog(null,"'" + searchable + "' found.");
    	}
    	catch (BadLocationException e)
    	{
    		
    	}
      }
      else
      {
        JOptionPane.showMessageDialog(null,"No results found");
      }
    }
}

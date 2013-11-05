import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.text.*;
import javax.swing.event.*;
import javax.swing.GroupLayout.*;

class Hunter 
{
	final static Color HILIT_COLOR = Color.LIGHT_GRAY;
    //final Color entryBg;
    final Highlighter hilit;
    final Highlighter.HighlightPainter painter;
    private JTextArea t = TextBox.getInstance();
    public Hunter()
    {
    	hilit = new DefaultHighlighter();
    	painter = new DefaultHighlighter.DefaultHighlightPainter(HILIT_COLOR);
    	t.setHighlighter(hilit);
    }
    public void search(String name)
    {
      //hilit.removeAllHighlights();
      String searchable = name;
      System.out.println(searchable);
      if(searchable.length() <= 0)
      {
    	  JOptionPane.showMessageDialog(null,"Nothing to search.");
      }
      String doc = t.getText();
      int index = doc.indexOf(searchable,0);
      if(index >= 0)
      {
    	try
    	{
    		int end = index + searchable.length();
        		hilit.addHighlight(index, end, painter);
        		t.setCaretPosition(end);
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

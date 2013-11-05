import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.text.*;
import javax.swing.event.*;
import javax.swing.GroupLayout.*;

class ButtonListener implements ActionListener
{
    
    final static Color  HILIT_COLOR = Color.LIGHT_GRAY;
    final Color entryBg;
    final Highlighter hilit;
    final Highlighter.HighlightPainter painter;
    public void actionPerformed(ActionEvent e)
    {
      hilit.removeAllHighlights();
      String searchable = searchBar.getText();
      if(searchable.length() <= 0)
      {
        System.out.println("Nothing to search.");
      }
      String doc = textArea.getText();
      int index = content.indexOf(searchable,0);
      if(index >= 0)
      {
        int end = index + s.length();
        hilit.addHighlight(index, end, painter);
        textArea.setCaretPosition(end);
        System.out.println("'" + searchable + "' found.");
      }
      else
      {
        System.out.println("No results found");
      }
    }
}

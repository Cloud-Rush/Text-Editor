import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

class ButtonListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
      hilit.removeAllHighlights();
      String searchable = searchBar.getText();
      if(searchable.length() <= 0)
      {
        message("Nothing to search.");
      }
      String doc = textArea.getText();
      int index = content.indexOf(searchable,0);
      if(index >= 0)
      {
        int end = index + s.length();
        hilit.addHighlight(index, end, painter);
        textArea.setCaretPosition(end);
        message("'" + searchable + "' found.");
      }
      else
      {
        message("No results found");
      }
    }
}

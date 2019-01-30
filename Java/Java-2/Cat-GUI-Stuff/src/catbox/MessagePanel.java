package catbox;
// MessagePanel.java: Display a message on a JPanel
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MessagePanel extends JPanel
{
  private String message = "Welcome to Java"; // Message to display

  // (x, y) coordinates where the message is displayed
  private int xCoordinate = 20;
  private int yCoordinate = 20;

  // Indicating whether the message is displayed in the center
  private boolean centered;

  // Default constructor
  public MessagePanel()
  {
  }

  // Contructor with a message parameter
  public MessagePanel(String message)
  {
    this.message = message;
  }

  public String getMessage()
  {
    return message;
  }

  public void setMessage(String message)
  {
    this.message = message;
  }

  public int getXCoordinate()
  {
    return xCoordinate;
  }

  public void setXCoordinate(int x)
  {
    this.xCoordinate = x;
  }

  public int getYCoordinate()
  {
    return yCoordinate;
  }

  public void setYCoordinate(int y)
  {
    this.yCoordinate = y;
  }

  public boolean isCentered()
  {
    return centered;
  }

  public void setCentered(boolean centered)
  {
    this.centered = centered;
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    if (centered)
    {
      // Get font metrics for the current font
      FontMetrics fm = g.getFontMetrics();

      // Find the center location to display
      int w = fm.stringWidth(message);  // Get the string width
      int h = fm.getAscent(); // Get the string height
      xCoordinate = (getWidth()-w)/2;
      yCoordinate = (getHeight()+h)/2;
    }

    g.drawString(message, xCoordinate, yCoordinate);
  }

  public Dimension getPreferredSize()
  {
    return new Dimension(200, 100);
  }

  public Dimension getMinimumSize()
  {
    return new Dimension(200, 100);
  }
}
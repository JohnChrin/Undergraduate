package catbox;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class GUIEventDemo extends JFrame {
  private JLabel jlblMessage = new JLabel("Hello", JLabel.CENTER);

  // Create check boxes to set the font for the message
  private JCheckBox jchkBold = new JCheckBox("Bold");
  private JCheckBox jchkItalic = new JCheckBox("Italic");
  
  // Create three radio buttons to set message colors
  private JRadioButton jrbonecat = new JRadioButton("1 Cat");
  private JRadioButton jrbtwocat = new JRadioButton("2 Cat");
  private JRadioButton jrbredcat = new JRadioButton("Red Cat");
  private JRadioButton jrbbluecat = new JRadioButton("Blue Cat");
  
  // Create Slider Bar
  private JSlider sMiddle = new JSlider(0,100,10);
  private JLabel jlMiddle = new JLabel("Middle Part %");
  private JLabel jlOnehun = new JLabel("100%");
  private JPanel sliderpanel;
  
  // Create a text field for setting a new message
  private JTextField jtfMessage = new JTextField(10);

  public static void main(String[] args) {
    GUIEventDemo frame = new GUIEventDemo();
    frame.pack();
    frame.setTitle("GUICat");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public GUIEventDemo() { 	
    jlblMessage.setBorder(new LineBorder(Color.BLACK, 2));
    add(jlblMessage, BorderLayout.CENTER);
    

       
    // Create a new panel to hold check boxes
    JPanel jpCheckBoxes = new JPanel();
    jpCheckBoxes.setLayout(new GridLayout(2, 1));
    jpCheckBoxes.add(jchkBold);
    jpCheckBoxes.add(jchkItalic);    
    add(jpCheckBoxes, BorderLayout.EAST);
  	
    // Create a new panel to hold check boxes
    JPanel jpRadioButtons = new JPanel();
    jpRadioButtons.setLayout(new GridLayout(3, 1));
    jpRadioButtons.add(jrbonecat);
    jpRadioButtons.add(jrbtwocat);
    jpRadioButtons.add(jrbredcat);
    jpRadioButtons.add(jrbbluecat);
    add(jpRadioButtons, BorderLayout.WEST);

    // Create a radio-button group to group three buttons
    ButtonGroup group = new ButtonGroup();
    group.add(jrbonecat);
    group.add(jrbtwocat);
    group.add(jrbredcat);
    group.add(jrbbluecat);

    // Set initial message color to blue
    jrbredcat.setSelected(true);
    jlblMessage.setForeground(Color.blue);
    
          //CREATE SLIDER
      sliderpanel = new JPanel();
      sliderpanel.add(jlMiddle);
      sliderpanel.add(sMiddle);
      sMiddle = new JSlider();
      sliderpanel.add(jlOnehun);
  	
    // Create a new panel to hold label and text field
    JPanel jpTextField = new JPanel();
    jpTextField.setLayout(new BorderLayout(5, 0));
    jpTextField.add(
      new JLabel("Enter a new message"), BorderLayout.WEST);
    jpTextField.add(jtfMessage, BorderLayout.CENTER);
    jtfMessage.setHorizontalAlignment(JTextField.RIGHT);
    add(jpTextField, BorderLayout.NORTH);
    add(sliderpanel, BorderLayout.SOUTH);
  
    // Set mnemonic keys for check boxes and radio buttons
    jchkBold.setMnemonic('B');
    jchkItalic.setMnemonic('I');
    jrbonecat.setMnemonic('E');
    jrbtwocat.setMnemonic('G');
    jrbredcat.setMnemonic('U');
    jrbbluecat.setMnemonic('Q');
    
    // Register listeners with check boxes
    jchkBold.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setNewFont();
      }
    });
    jchkItalic.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setNewFont();
      }
    });
    
    // Register listeners for radio buttons
    jrbonecat.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
      	jlblMessage.setForeground(Color.red);
      }
    });
    jrbtwocat.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
      	jlblMessage.setForeground(Color.green);
      }
    });
    jrbredcat.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        jlblMessage.setForeground(Color.blue);
      }
    });
    jrbbluecat.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        jlblMessage.setForeground(Color.yellow);
      }
    });
    
    // Register listener for text field
    jtfMessage.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        jlblMessage.setText(jtfMessage.getText());
        jtfMessage.requestFocusInWindow();
      }
    });
  }
  
  private void setNewFont() {
    // Determine a font style
    int fontStyle = Font.PLAIN;
    fontStyle += (jchkBold.isSelected() ? Font.BOLD : Font.PLAIN);
    fontStyle += (jchkItalic.isSelected() ? Font.ITALIC : Font.PLAIN);

    // Set font for the message
    Font font = jlblMessage.getFont();
    jlblMessage.setFont(
      new Font(font.getName(), fontStyle, font.getSize()));
  }
}

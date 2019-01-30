package catbox;
/* Program - Client Catbox
Name: John A Chrin
*/

import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Catbox extends JFrame
{

  private JMenuBar menuBar;
  private JMenu menu, submenu;
  private JMenuItem newcat, quitgame;
  private JRadioButtonMenuItem rbMenuItem;
  private JCheckBoxMenuItem cbMenuItem;
  
  
  //Radio Buttons
  private JRadioButton jrbOnecat = new JRadioButton("1 Cat");
  private JRadioButton jrbTwocat = new JRadioButton("2 Cat");
  private JRadioButton jrbRedcat = new JRadioButton("Red Cat");
  private JRadioButton jrbBluecat = new JRadioButton("Blue Cat");
 
  //Text Area *Broke 
  private JTextArea jtaSpecialreq = new JTextArea();
  private JScrollPane scrollPane = new JScrollPane(jtaSpecialreq);
  private JLabel jlSpecialreq = new JLabel("Special Requests");
  private JTextField jtfSpecialreq = new JTextField(15);
  
  //Combo Box
  private JComboBox jcbReligion = new JComboBox();
  private JLabel jlComboTitle = new JLabel("Religion");
  private String[] religions = {"Islamic", "Hindu", "Christian", "Jewish", "Wickan"};
  
  //List
  private JList jlFood = new JList();
  private String[] foods = {"Cat Food", "Lasanga", "Doritos", "Wood", "People"};
  
  //Slider
  private JSlider sMiddle = new JSlider(0,100,10);
  private JLabel jlMiddle = new JLabel("Middle Part %");
  
  private JPanel mainpanel;                        //Panel contains every other panel
  private JPanel catpanel;                         //Panel contains cat panel
  private JPanel radiopanel;
  private JPanel textpanel;
  private JPanel combopanel;
  private JPanel listpanel;
  private JPanel sliderpanel;

   
      //CONSTRUCTOR
   public Catbox()
   {  
        
         //JFRAME VALUES (OUTSIDE BORDER WINDOW)
      setTitle("CATBOX");
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      Point middle = new Point(screenSize.width / 2, screenSize.height / 2);
      Point newLocation = new Point(middle.x - ((getWidth() / 2) + 200), 
                                    middle.y - ((getHeight() / 2) + 200));
      setLocation(newLocation);
      setSize(400,400);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      menuBar = new JMenuBar();
      setJMenuBar(menuBar);
      menu = new JMenu("File");
      menuBar.add(menu);
      newcat = new JMenuItem("New Cat");
      quitgame = new JMenuItem("Quit");
      menu.add(newcat);
      newcat.addActionListener(new ActionListener() 
      {
            public void actionPerformed(ActionEvent ae)
            {
               // NEW CAT
               Catbox.this.dispose();
               new Catbox();
            }
            });
      menu.add(quitgame);
      quitgame.addActionListener(new ActionListener() 
      {
            public void actionPerformed(ActionEvent ae) 
            {
                // EXIT
                System.exit(0);
            }
      });
      
      //CREATE RADIO BUTTONS
      radiopanel = new JPanel();
      radiopanel.setLayout(new GridLayout(4,1));
      radiopanel.add(jrbOnecat);
      radiopanel.add(jrbTwocat);
      radiopanel.add(jrbRedcat);
      radiopanel.add(jrbBluecat);
      
         //Create a radio-button group to group them
         ButtonGroup group = new ButtonGroup();
         group.add(jrbOnecat);
         group.add(jrbTwocat);
         group.add(jrbRedcat);
         group.add(jrbBluecat);
         
      /*/CREATE TEXT AREA
      textpanel = new JPanel();
      textpanel.add(jlSpecialreq);
      textpanel.add(jtaSpecialreq);
     
      
      jtaSpecialreq.setFont(new Font("Serif", Font.PLAIN, 8));
      
      jtaSpecialreq.setLineWrap(true);
      jtaSpecialreq.setWrapStyleWord(true);
      jtaSpecialreq.setEditable(false);
      
      jlSpecialreq.setHorizontalAlignment(JLabel.RIGHT);
      scrollPane.setPreferredSize(new Dimension(200, 100));
      */
      
      
      //CREATE TEXTFIELD
      textpanel = new JPanel();
      textpanel.add(jlSpecialreq);
      textpanel.add(jtfSpecialreq);
      
      //CREATE COMBOBOX
      combopanel = new JPanel();
      combopanel.setPreferredSize(new Dimension(200, 100));
      combopanel.add(jlComboTitle);
      combopanel.add(jcbReligion);
      jcbReligion = new JComboBox(religions);
      jcbReligion.setPreferredSize(new Dimension(200, 100));
      
      //CREATE JLIST
      listpanel = new JPanel();
      listpanel.add(jlFood); 
      listpanel.setPreferredSize(new Dimension(200, 100));
      jlFood = new JList(foods);
      jlFood.setForeground(Color.RED);
      jlFood.setBackground(Color.WHITE);
      jlFood.setSelectionForeground(Color.PINK);
      jlFood.setSelectionBackground(Color.BLACK);
      jlFood.setVisibleRowCount(4);
      
      //CREATE JSCROLLBAR
      JScrollBar hbar = new JScrollBar(JScrollBar.HORIZONTAL, 30, 20, 0, 300);
      JScrollBar vbar = new JScrollBar(JScrollBar.VERTICAL, 30, 40, 0, 300);
      
      hbar.setUnitIncrement(2);
      hbar.setBlockIncrement(1);

      hbar.addAdjustmentListener(new MyAdjustmentListener());
      vbar.addAdjustmentListener(new MyAdjustmentListener());
      
      //CREATE SLIDER
      sliderpanel = new JPanel();
      sliderpanel.add(jlMiddle);
      sliderpanel.add(sMiddle);
      sMiddle = new JSlider();
     
      //A METHOD THAT IS AN IMPORTED PANEL
      buildpanels();
      
      add(mainpanel);
      menuBar.setVisible(true);
      setVisible(true);
   }
   
// BUILD ALL YOUR JPANELS AND SETUP
   public void buildpanels()
   {
   mainpanel = new JPanel();
   mainpanel.setLayout(new FlowLayout(1,2,3));

   //catpanel = new JPanel(new GridLayout(5,5));       
   
   //mainpanel.add(catpanel);
   mainpanel.add(radiopanel);
   mainpanel.add(textpanel);
   mainpanel.add(combopanel);
   mainpanel.add(listpanel);
   mainpanel.add(sliderpanel);
   }
   
   
     class MyAdjustmentListener implements AdjustmentListener {
    public void adjustmentValueChanged(AdjustmentEvent e) {
      repaint();
    }
  }

   
      //DRIVER / TESTER   
   public static void main(String[] args)
   {
      new Catbox();
   }
}
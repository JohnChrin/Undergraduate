package catbox;
import java.awt.*;

import java.awt.event.*;

import javax.swing.*;



public class ComboBoxCat extends JFrame {

   JScrollPane pane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

  // Declare an array of Strings for cat titles
  private String[] catTitles = {"1 Cat", "2 Cat", "Red Cat", "Blue Cat"};
 


  // Declare an ImageIcon array for the cats
    private ImageIcon[] catImage = {

    new ImageIcon("1cat.jpeg"),

    new ImageIcon("2cat.jpeg"),

    new ImageIcon("redcat.jpeg"),

    new ImageIcon("bluecat.jpeg")

  };



  // Declare an array of strings for flag descriptions
  private String[] catDescription = new String[4];



  // Declare and create a description panel
  private DescriptionPanel descriptionPanel = new DescriptionPanel();



  // Create a combo box for selecting countries
  private JComboBox jcbo = new JComboBox(catTitles);
  


  public static void main(String[] args) {

	  
	  ComboBoxCat frame = new ComboBoxCat();
	  frame.setPreferredSize(new Dimension(800, 400));
    frame.pack();

    frame.setTitle("ComboBoxCat");

    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setVisible(true);

  }



  public ComboBoxCat() {

    // Set text description
    catDescription[0] = "This is 1 cat. There are many different breeds of cats, including Abyssinian, Himalayan, Maine Coon, Manx, Persian, Scottish Fold, and Siamese, to name a few. The Cat Fanciers' Association, which is the world's largest registry of pedigreed cats, recognizes about 40 distinct breeds. The most familiar cats are the domestic shorthair and the domestic longhair, which are really mixtures of different breeds. Cat breeds differ in looks, coat length, and other characteristics but vary relatively little in size. On average, only 5 to 10 pounds separate the smallest and largest domestic breeds of cats.";

    catDescription[1] = "This is 2 cat. Cats also share the rapid metabolism that dogs have, which results in a higher heart rate, respiratory rate, and temperature than those of people (see Description and Physical Characteristics of Cats: Normal Feline Physiologic ValuesTables). Cats generally live longer than dogs, and many live to be 20 years old or older.";

    catDescription[2] = "This is red cat. Cats are better at conserving heat than at cooling themselves, although their small size relative to their large surface area makes for more effective cooling than in dogs. Cats lose heat through external radiation. They have some sweat glands that aid in evaporative cooling, and licking their fur further improves this process. Heat is also lost through panting, although this is not as effective a method of cooling as it is in dogs. Cats typically also seek dark, cool places to shelter themselves from the heat of the day. As with all animals, cats should never be shut in cars or other hot, confined spaces. This can lead to heat stroke and death.";

    catDescription[3] = "This is blue cat. ";




    setDisplay(0);



    // Add combo box and description panel to the list
    add(jcbo, BorderLayout.NORTH);

    add(descriptionPanel, BorderLayout.CENTER);

    add(pane, BorderLayout.EAST);

    // Register listener
    jcbo.addItemListener(new ItemListener() {

      /** Handle item selection */

      public void itemStateChanged(ItemEvent e) {

        setDisplay(jcbo.getSelectedIndex());

      }

    });

  }



  /** Set display information on the description panel */

  public void setDisplay(int index) {

    descriptionPanel.setTitle(catTitles[index]);

    descriptionPanel.setImageIcon(catImage[index]);

    descriptionPanel.setDescription(catDescription[index]);

  }

}



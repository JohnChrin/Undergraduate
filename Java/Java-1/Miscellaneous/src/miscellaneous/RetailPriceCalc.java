package miscellaneous;
/* Chapter 12 In-Class Example
   Name: John A Chrin
   Date: 2015/03/26
   Purpose: Chap 12., #1 (p.839)
   This program Creates a GUI application
   where the user enters the wholesale
   cost of an item and its markup percenage
   into text fields.
   INPUT - 
      Wholesale Cost
      Markup Percentage
   OUTPUT -
      Retail Price - CALCULATE BUTTON
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class RetailPriceCalc extends JFrame
{
   // Instance variables -- components in my window
   private JPanel panel;                                                //To reference a panel
   private JLabel lblMarkup, lblWholesale, lblPct, lblRetail;           // To reference a label
   private JTextField txtMarkup, txtWholesale, txtRetail;               // To reference a text field
   private JButton btnCalc;                                             // To reference a button
   private final int WINDOW_WIDTH = 310;                                // Initial Window Width
   private final int WINDOW_HEIGHT = 100;                               // Initial Windows Height
   
   // Contructor
   public RetailPriceCalc()
   {
      setTitle("Retail Price Calculator");
      setSize(310,100); //required ... can use CONSTANTS
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //required
      
      // Build the panel with all the graphics components in it
      buildPanel();
      
      //add the panel just built to the frame
      add(panel);
      
      setVisible(true);
      // Build your objects
   }
   
   private void buildPanel()
   {
      lblWholesale = new JLabel("Enter Wholesale Cost: ");
      lblMarkup = new JLabel("Enter Markup Percent: ");
      lblPct = new JLabel(" % ");
      lblRetail = new JLabel("Retail Cost:");
      txtMarkup = new JTextField(5);
      txtWholesale = new JTextField(5);
      txtRetail = new JTextField(5);
                  txtRetail.setEditable(false);
      btnCalc = new JButton("Calculate");
      
      panel = new JPanel();
      panel.add(lblWholesale);
      panel.add(txtWholesale);
      panel.add(lblMarkup);
      panel.add(txtMarkup);
      panel.add(lblPct);
      panel.add(lblRetail);
      panel.add(txtRetail);
      panel.add(btnCalc);
   }
   //TEST METHOD
   public static void main(String[] args)
   {
      RetailPriceCalc myCalc = new RetailPriceCalc();
   }
}
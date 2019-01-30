package helloWorld;
/* Chapter 12 Lab
   Name: John A Chrin
   Date: 2015/03/26
   Purpose: Chap 12., #2 (p.840)
   This program is a GUI of the following:
   
   A retail company must file a monthly sales tax report listing the total sales for the month,
   and the amount of state and county sales tax collected. The state sales tax rate is 4 percent
   and the county sales tax rate is 2 percent. Create a GUI application that allows the user to
   enter the total sales for the month into a text field. From this figure, the application should
   calculate and display the follow:
   
   Monthly Sales Tax Report Listing = Total Sales for Month
                                      Total State  Sales Tax Collected
                                      Total County Sales Tax Collected
                                      Total Sales Tax
   State  Sales Tax = 6%
   County Sales Tax = 2%
*/

import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MonthlySalesTax extends JFrame
{
	// FIELDS/INSTANCES - WHAT IS IN MY WINDOW!!!
	private JPanel panel; // INSIDE OF JFRAME
	private JLabel lblTotalSales, lblStateTax, lblCountyTax, lblTotalSalesTax; // TEXT LABELS
	private JTextField txtTotalSales, txtStateTax, txtCountyTax, txtTotalSalesTax; // TEXT BOXES
	private JButton btnCalc; // BUTTON TO CALCULATE
	private final int WINDOW_WIDTH = 200; // DEFAULT WINDOW WIDTH
	private final int WINDOW_HEIGHT = 200; // DEFAULT WINDOW HEIGHT
	private final double StateTaxRate = .06;
	private final double CountyTaxRate = .02;
	private double StateTax;
	private double CountyTax;
	private double TotalSales;
	private double TotalSalesTax;

	// CONSTRUCTORS
	public MonthlySalesTax()
	{
		// JFRAME VALUES (OUTSIDE BORDER WINDOW)
		setTitle("Monthly Sales Tax Calculator");
		setSize(250, 170);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// A METHOD THAT IS AN IMPORTED PANEL
		buildpanel();

		add(panel);

		setVisible(true);

	}

	private void buildpanel()
	{
		// Default location of window upon opening
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Point middle = new Point(screenSize.width / 2, screenSize.height / 2);
		Point newLocation = new Point(middle.x - ((getWidth() / 2)), middle.y - ((getHeight() / 2)));
		setLocation(newLocation);
		lblTotalSales = new JLabel("Total Sales");
		txtTotalSales = new JTextField(11);

		lblStateTax = new JLabel("State Tax");
		txtStateTax = new JTextField(4);
		txtStateTax.setEditable(false);

		lblCountyTax = new JLabel("County Tax");
		txtCountyTax = new JTextField(4);
		txtCountyTax.setEditable(false);

		lblTotalSalesTax = new JLabel("Total Tax");
		txtTotalSalesTax = new JTextField(7);
		txtTotalSalesTax.setEditable(false);

		btnCalc = new JButton("Calculate");
		btnCalc.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				TotalSales = Double.parseDouble(txtTotalSales.getText());

				StateTax = (StateTaxRate * TotalSales);
				CountyTax = (CountyTaxRate * TotalSales);
				TotalSalesTax = (StateTax + CountyTax);

				txtStateTax.setText(Double.toString(StateTax));
				txtCountyTax.setText(Double.toString(CountyTax));
				txtTotalSalesTax.setText(Double.toString(TotalSalesTax));
			}
		});

		panel = new JPanel();
		panel.add(lblTotalSales);
		panel.add(txtTotalSales);
		panel.add(lblStateTax);
		panel.add(txtStateTax);
		panel.add(lblCountyTax);
		panel.add(txtCountyTax);
		panel.add(lblTotalSalesTax);
		panel.add(txtTotalSalesTax);
		panel.add(btnCalc);
	}
	// SETTERS METHODS

	// GETTERS METHODS

	// OTHERS METHODS
	// Driver
	public static void main(String[] args)
	{
		MonthlySalesTax MyCalc = new MonthlySalesTax();

	}
}

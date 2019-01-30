package miscellaneous;

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
   State  Sales Tax = 4%
   County Sales Tax = 2%
*/
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MonthlySalesTax extends JFrame {
    // FIELDS/INSTANCES - WHAT IS IN MY WINDOW!!!
    private JPanel panel; // INSIDE OF JFRAME
    private JLabel lblTotalSales, lblStateTax, lblCountyTax, lblTotalSalesTax; // TEXT LABELS
    private JTextField txtTotalSales, txtStateTax, txtCountyTax, txtTotalSalesTax; // TEXT BOXES
    private JButton btnCalc; // BUTTON TO CALCULATE
    private static final int WINDOW_WIDTH = 250; // DEFAULT WINDOW WIDTH
    private static final int WINDOW_HEIGHT = 170; // DEFAULT WINDOW HEIGHT
    private double stateTaxRate = .04;
    private double countyTaxRate = .02;
    private double stateTax;
    private double countyTax;
    private double totalSales;
    private double totalSalesTax;

    // Driver
    public static void main(String[] args) {
	new MonthlySalesTax();
    }

    // CONSTRUCTOR
    public MonthlySalesTax() {
	// JFRAME VALUES (OUTSIDE BORDER WINDOW)
	setTitle("Monthly Sales Tax Calculator");
	setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// A METHOD THAT IS AN IMPORTED PANEL
	buildpanel();
	add(panel);
	setVisible(true);
    }

    private void buildpanel() {
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
	btnCalc.addActionListener(e -> {
	    totalSales = Double.parseDouble(txtTotalSales.getText());

	    stateTax = (stateTaxRate * totalSales);
	    countyTax = (countyTaxRate * totalSales);
	    totalSalesTax = (stateTax + countyTax);

	    txtStateTax.setText(Double.toString(stateTax));
	    txtCountyTax.setText(Double.toString(countyTax));
	    txtTotalSalesTax.setText(Double.toString(totalSalesTax));
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
}

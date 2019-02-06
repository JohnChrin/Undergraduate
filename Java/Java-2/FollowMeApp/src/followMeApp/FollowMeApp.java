package followMeApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FollowMeApp extends JPanel implements MouseMotionListener {
    // FIELDS
    // constants for size of eye
    final int EYE_WIDTH = 30;
    final int EYE_HEIGHT = 40;
    final int X_LEFTPUPIL_LOOKRIGHT = 80;
    final int Y_PUPIL_LOOKRIGHT = 70;
    final int X_LEFTPUPIL_LOOKLEFT = 55;
    final int Y_PUPIL_LOOKLEFT = 70;
    final int X_LEFTPUPIL_LOOKUP = 70;
    final int Y_PUPIL_LOOKUP = 75;
    final int X_LEFTPUPIL_LOOKDOWN = 70;
    final int Y_PUPIL_LOOKDOWN = 55;
    final int XOFFSET_RIGHTPUPIL = 50;
    final int XOFFSET = 11;
    final int YOFFSET = 10;

    // instance variables
    private int curLeftX;
    private int curLeftY;
    private int curRightX;
    private int curRightY;

    // DRIVERS //TESTER
    public static void main(String[] args) {
	JFrame myApp = new JFrame();
	myApp.setTitle("FollowMe");
	myApp.setSize(300, 175);
	myApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// create PANEL with graphics in it
	JPanel myAppPanel = new FollowMeApp();
	myApp.add(myAppPanel);
	myApp.setVisible(true);
    }

    // CONSTRUCTOR
    public FollowMeApp() {
	curLeftX = 60;
	curLeftY = 70;
	curRightX = 110;
	curRightY = 70;
	addMouseMotionListener(this);
	repaint();
	setVisible(true);
    }

    // draw pure graphics: its like a CANVAS
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	// draw left eye
	g.setColor(Color.BLACK);
	g.drawOval(48, 40, EYE_WIDTH+XOFFSET, EYE_HEIGHT+YOFFSET);
	// draw left pupil
	g.setColor(Color.BLUE);
	g.fillOval(curLeftX, curLeftY, 10, 10);

	// draw right eye
	g.setColor(Color.BLACK);
	g.drawOval(98, 40, EYE_WIDTH+XOFFSET, EYE_HEIGHT+YOFFSET);
	// draw right pupil
	g.setColor(Color.BLUE);
	g.fillOval(curRightX, curRightY, 10, 10);

    }
    // Manages the pupils, ensures they do not leave the bounds of the ellipse. 
    public void mouseMoved(MouseEvent e) {
	curLeftX = e.getX();
	curLeftY = e.getY();
	repaint(); 
	double angle = Math.atan2((double) (curLeftY - 50), (double)(curLeftX - 50));
	curLeftX = (int) Math.round(Math.cos(angle)*(EYE_WIDTH/2)+63);
	curLeftY = (int) Math.round(Math.sin(angle)*(EYE_HEIGHT/2)+60);
	curRightX = curLeftX + XOFFSET_RIGHTPUPIL;
	curRightY = curLeftY;
    }
    @Override
    public void mouseDragged(MouseEvent arg0) {


    }
}
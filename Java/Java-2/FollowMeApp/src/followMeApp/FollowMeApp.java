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
    final int Y_PUPIL_LOOKUP = 55;
    final int X_LEFTPUPIL_LOOKDOWN = 70;
    final int Y_PUPIL_LOOKDOWN = 75;
    final int XOFFSET_RIGHTPUPIL = 50;

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

	g.setColor(Color.BLACK);
	// draw leFollowMeAppdrawOval(50, 50, EYE_WIDTH, EYE_HEIGHT);
	// draw left pupil
	g.setColor(Color.BLUE);
	g.fillOval(curLeftX, curLeftY, 10, 10);
	g.setColor(Color.BLACK);
	// draw right eye
	g.drawOval(100, 50, EYE_WIDTH, EYE_HEIGHT);
	// draw right pupil
	g.setColor(Color.BLUE);
	g.fillOval(curRightX, curRightY, 10, 10);

    }

    public void mouseMoved(MouseEvent e) {
	curLeftX = e.getX();
	curLeftY = e.getY();
	curRightX = e.getX();
	curRightY = e.getY();
	repaint();
    }

    @Override
    public void mouseDragged(MouseEvent arg0) {
	// TODO Auto-generated method stub

    }
}

/*
 * 
 * //listener for mouse motion -- p.961 //INNER CLASS so it has to be private private class MyListener implements MouseListener, MouseMotionListener { //MouseMotionListener REQUIRES mouseDragged() and mouseMoved() methods public void mousePressed(MouseEvent e) { //redraw the pupil when mouse is moved int curX = e.getX(); int curY = e.getY();
 * 
 * } public void mouseDragged(MouseEvent e) { } public void mouseReleased(MouseEvent e) { } }
 */
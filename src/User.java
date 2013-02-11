import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

import javax.swing.ImageIcon;
import javax.swing.Timer;


public class User {

	double x;
	double y;
	private Timer timer;
	
	private int width;
	static ArrayList<Point> points = new ArrayList<Point>();
	private int point = 0;
	private int height;
	private boolean visible;
	private int position = 0;
	private int direction = 1;
	private int half = 1;
	private boolean moving = true;
	ImageIcon userImageIcon = new ImageIcon("user.png");
	Image userImage = userImageIcon.getImage();
	Move move;
	public int health = 0;
	private int score = 0;

	public User() {

		getPoints();
		width = (int) userImage.getWidth(null);
		height = (int) userImage.getHeight(null);
		position = 0;
		visible = true;
		move = new Move();
		timer = new javax.swing.Timer((SwingStart.subMenu.getSpeed() - 2) * 2, move);
		timer.setRepeats(true);
		timer.setInitialDelay(0);
		timer.start();
		
	}
	public int getY() {
		return (int) y;
	}
	
	public void reset() {
		timer.stop();
		timer.removeActionListener(move);
	}

	public int getPosition() {
		return position;
	}

	public int getX() {
		return (int) x;
	}

	public Image getImage() {
		return userImage;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setMoving(boolean tf) {
		moving = tf;
	}

	public int getHalf() {
		return half;
	}
	
	public void sethalf(int x) {
		half = x;
	}
	public int getScore() {
		return score;
	}
	
	public void changeScore(int x) {
		score = score + x;
	}
	
	
	public boolean getMoving() {
		return moving;
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, width, height);
	}

	public int getDirection() {
		return direction;
	}
	
	public static void getPoints() {
		double alpha = ((Math.PI * 2) / 360);
		for(int i = 0; i < 360; i ++) {
			double theta = alpha * i;
			points.add(new Point(((int)(Math.cos(theta) * 155.0)) + 183,((int) (Math.sin(theta) * 155.0)) + 183));
		}
		
	}

	public void leftPressed() {
			moving = true;
			direction = -1;
	}
	public void rightPressed() {
			moving = true;
			direction = 1;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	public void setDirection(int i) {
		direction = i;
	}
	
	public void pause() {
		timer.stop();
	}
	public void unPause() {
		timer = new javax.swing.Timer((SwingStart.subMenu.getSpeed()) * 2, move);
		timer.start();
	}
	public void switchDirection() {
		if(direction == 1)
			direction = -1;
		else
			direction = 1;
	}
}

class Move implements ActionListener {
	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		// TODO Auto-generated method stub

		int xCor = (int) MusicGameBoard.user.x;
		int yCor = (int) MusicGameBoard.user.y;
		if(MusicGameBoard.user.getMoving() == true) {
		if(MusicGameBoard.user.getDirection() == 1) {
		if(MusicGameBoard.user.getPoint() == 359)
			MusicGameBoard.user.setPoint(0);
		else
			MusicGameBoard.user.setPoint(MusicGameBoard.user.getPoint() + 1);
		}
		else {
			if(MusicGameBoard.user.getPoint() == 0)
				MusicGameBoard.user.setPoint(359);
			else
			MusicGameBoard.user.setPoint(MusicGameBoard.user.getPoint() - 1);
			}

		MusicGameBoard.user.x = MusicGameBoard.user.points.get(MusicGameBoard.user.getPoint()).getX();
		MusicGameBoard.user.y = MusicGameBoard.user.points.get(MusicGameBoard.user.getPoint()).getY();
	}
		if(MusicGameBoard.user.getPoint() == 0
				   || MusicGameBoard.user.getPoint() == 0
				   || MusicGameBoard.user.getPoint() == 45
				   || MusicGameBoard.user.getPoint() == 90
				   || MusicGameBoard.user.getPoint() == 135
				   || MusicGameBoard.user.getPoint() == 185
				   || MusicGameBoard.user.getPoint() == 225
				   || MusicGameBoard.user.getPoint() == 270
				   || MusicGameBoard.user.getPoint() == 315
				   || MusicGameBoard.user.getPoint() == 360);
					//MusicGameBoard.user.setMoving(false);
	}
		
	}

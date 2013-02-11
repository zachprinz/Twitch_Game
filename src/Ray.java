import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Arc2D;


import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Ray {

	private int x = 4;
	private int y = 30;
	private int angle = 0;
	private int width;
	private int height;
	private boolean visible;
	static ArrayList<Point> points = new ArrayList<Point>();
	public Point orgin;
	public Point center;
	public int startAngle = 90;
	public int endAngle = 360;
	public int centerPoint;
	public Point p1;
	public Point p2;
	private boolean moving = true;
	private Timer timer;
	private int direction = 1;
	Random random = new Random();
	Arc2D arc = new Arc2D.Double(0,0,360,360,startAngle,270, Arc2D.PIE);
	MoveRay moveRay;
	int beatsSoFar = 0;


	public Ray() {
		visible = true;
		getPoints();
		center = points.get(0);
		orgin = new Point(183,183);
		moveRay = new MoveRay();
		timer = new javax.swing.Timer(SwingStart.subMenu.getSpeed() * 2, moveRay);
		timer.setRepeats(true);
		timer.setInitialDelay(0);
		timer.start();
	}
	
	public void reset() {
		timer.stop();
		timer.removeActionListener(moveRay);
		beatsSoFar = 0;
	}

	public void rotate() {
	}
	
	public static void getPoints() {
		double alpha = ((Math.PI * 2) / 360);
		for(int i = 0; i < 360; i ++) {
			double theta = alpha * i;
			points.add(new Point(((int)(Math.cos(theta) * 155.0)) + 183,((int) (Math.sin(theta) * 155.0)) + 183));
		}
		
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getAngle() {
		return angle;
	}
	
	public int getCenterPoint() {
		return centerPoint;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isVisible() {
		return visible;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}

	public int getDirection() {
		return direction;
	}

	public boolean getMoving() {
		return moving;
	}

	public void setCenterPoint(int i) {
		centerPoint = i;
	}
	
	public void addStartAngle(int x) {
		if(x < 0) {
			if(startAngle == 0)
				startAngle = 359;
			else
				startAngle = startAngle - 1;
		}
		else {
			if(x > 0) {
				if(startAngle == 359)
					startAngle = 0;
				else
					startAngle = startAngle + 1;
			}
		}
	}
	
	public void addEndAngle(int x) {
		if(x < 0) {
			if(endAngle == 0)
				endAngle = 359;
			else
				endAngle = endAngle - 1;
		}
		else {
			if(x > 0) {
				if(endAngle == 359)
					endAngle = 0;
				else
					endAngle = endAngle + 1;
			}
		}
	}
	
	public int getStartAngle() {
		return startAngle;
	}
	public int getEndAngle() {
		return endAngle;
	}
	
	public void switchDirection() {
		if(direction == 1)
			direction = -1;
		else
			direction = 1;
	}
	
	public void pause() {
		timer.stop();
	}
	public void unPause() {
		timer =  new javax.swing.Timer(SwingStart.subMenu.getSpeed() * 2, moveRay);
		timer.start();
	}
}

class MoveRay implements ActionListener {
	public void actionPerformed(ActionEvent evt) {
		int runTime = (int) ((System.currentTimeMillis()/10) - MusicGameBoard.getStartTime() - MusicGameBoard.getPauseTime());
		if(MusicGameBoard.getBeats().get(MusicGameBoard.ray.beatsSoFar) == runTime + 10) { 
				MusicGameBoard.ray.switchDirection();
				MusicGameBoard.ray.beatsSoFar++;
		}
		if(MusicGameBoard.ray.getMoving() == true) {
		if(MusicGameBoard.ray.getDirection() == 1) {
			MusicGameBoard.ray.addStartAngle(1);
			MusicGameBoard.ray.addEndAngle(1);
		}
		else {
			MusicGameBoard.ray.addStartAngle(-1);
			MusicGameBoard.ray.addEndAngle(-1);
			
		}
	}
		MusicGameBoard.ray.arc.setAngleStart(MusicGameBoard.ray.getStartAngle());
}
}
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MusicGameBoard extends JPanel implements ActionListener{

	
	static ImageIcon backgroundImageIcon = new ImageIcon("back.png");
	static Image backGroundImage = backgroundImageIcon.getImage();
	File rayImg = new File("Area.png");
	private Timer timer;
	public static User user;
	public static Ray ray;
	private int B_WIDTH;
	private Timer timer2;
	private int B_HEIGHT;
	private int GAME_STAGE;
	private JPanel panel1;
	private int PLAYING = 2;
	private int MENU = 0;
	private int DEAL = 3;
	static boolean pause = false;
	private boolean complete = false;
	private int score = 0;
	private int z = 3;
	float alpha = 1.0f;
	MusicLevelManager mlm = new MusicLevelManager();
	private static ArrayList<Integer> beats;
	static int startTime;
	Timer time;
	private static boolean printed = false;

	public MusicGameBoard() {
		setFocusable(true);
		setBackground(Color.GRAY);
		setSize(366, 366);
		setVisible(false);
	}
	
	public void startGame() {
		user = new User();
		ray = new Ray();
	
		setFocusable(true);
		setEnabled(true);
		setVisible(true);
		
		startTime = (int) (System.currentTimeMillis() / 10);
		GAME_STAGE = PLAYING;
		time = new Timer(5, this);
		time.setRepeats(true);
		time.setInitialDelay(0);
		time.start();
	}
	
	public void getLevel() {
		beats = mlm.initBeats();
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.DARK_GRAY);
		g2d.fillRect(0, 0, 400, 400 );
		g2d.drawImage(backGroundImage, 0, 0, this);
		g2d.setColor(Color.WHITE);
		//g2d.fillArc(3, 3, 360, 360,  ray.getStartAngle(),  270);

		g2d.drawImage(user.getImage(),(user.getX() - (user.getImage().getWidth(null) /2)),(user.getY() - (user.getImage().getHeight(null) /2)), this);
		g2d.setColor(Color.GRAY);
		
	    for(int a = 0; a < 60; a++) {
			g2d.drawArc(183 - (3 * a), 183 - (3*a),6*a ,6*a, ray.getStartAngle(), 270); 
			repaint();
	    }
	    g2d.setColor(Color.RED);
	    g2d.drawLine(183, 183,(int) ray.arc.getStartPoint().getX(),(int) ray.arc.getStartPoint().getY() );
	    g2d.drawLine(183, 183, (int)ray.arc.getEndPoint().getX(),(int) ray.arc.getEndPoint().getY() );

	    
		g2d.setColor(Color.WHITE);
		Integer timeRun = (int) (System.currentTimeMillis()/10) - MusicGameBoard.getStartTime();
		String timeRunString = Integer.toString(timeRun);
		//g2d.drawString(timeRunString, 0, 10);
		//g2d.drawString("Score: ", 0, 10);
		g2d.drawString("Score: " + user.getScore(), 2, 15);
	}

	public void actionPerformed(ActionEvent e) {
		if (GAME_STAGE == PLAYING) {
			checkCollisions();
			repaint();
		}
	}
	
	public static int getStartTime() {
		return startTime;
	}

	public static ArrayList<Integer> getBeats() {
		if(printed == false){
		System.out.println(beats.toString());
		printed = true;
		return beats;
	}
		return beats;

	}
	
	public static void die() {
		user.setVisible(false);
	}

	public void checkCollisions() {
		if(!ray.arc.contains(user.points.get(user.getPoint())))
			user.changeScore(1);
		//else
			//user.switchDirection();
	}
}




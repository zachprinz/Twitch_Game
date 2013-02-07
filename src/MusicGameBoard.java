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
	private boolean debug = true;
	private static boolean printed = false;

	public MusicGameBoard() {
		setFocusable(true);
		setBackground(Color.GRAY);
		setSize(366, 366);
		
		setVisible(false);
	}
	
	public void reset() {
		ray.reset();
		user.reset();
		//beats.clear();
		score = 0;
		ray = new Ray();
		user = new User();
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
		//Graphics2D g2d = (Graphics2D) g;
		Image bufferedImage = createImage(366, 366);
		Graphics2D buffer = (Graphics2D) bufferedImage.getGraphics();

		buffer.setColor(Color.DARK_GRAY);
		buffer.fillRect(0, 0, 400, 400 );
		buffer.drawImage(backGroundImage, 0, 0, this);
		buffer.setColor(Color.WHITE);
		buffer.drawImage(user.getImage(),(user.getX() - (user.getImage().getWidth(null) /2)),(user.getY() - (user.getImage().getHeight(null) /2)), this);
		buffer.setColor(Color.GRAY);
	    for(int a = 0; a < 60; a++) {
			buffer.drawArc(183 - (3 * a), 183 - (3*a),6*a ,6*a, ray.getStartAngle(), 270); 
			repaint();
	    }
	    buffer.setColor(Color.RED);
	    buffer.drawLine(183, 183,(int) ray.arc.getStartPoint().getX(),(int) ray.arc.getStartPoint().getY() );
	    buffer.drawLine(183, 183, (int)ray.arc.getEndPoint().getX(),(int) ray.arc.getEndPoint().getY() );
		buffer.setColor(Color.WHITE);
		Integer timeRun = (int) (System.currentTimeMillis()/10) - MusicGameBoard.getStartTime();
		String timeRunString = Integer.toString(timeRun);
		buffer.drawString("Score: " + user.getScore(), 2, 15);
		if(debug == true)
		{
			buffer.setColor(Color.RED);
			buffer.drawString(timeRunString,  0, 30);
			buffer.drawString("Beats So Far: " + MusicGameBoard.ray.beatsSoFar, 0, 40);
			buffer.drawString("Next Beat: " + MusicGameBoard.getBeats().get(MusicGameBoard.ray.beatsSoFar), 0, 50);
		}
		g.drawImage(bufferedImage, 0, 0, this);

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




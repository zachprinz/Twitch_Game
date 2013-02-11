import java.awt.event.ActionEvent;
import java.io.File;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
//import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.KeyStroke;

public class SwingStart extends JFrame {

	public static MusicGameBoard board = new MusicGameBoard();
	public static JavaGameMenu menu = new JavaGameMenu();
	public static SubMenu subMenu = new SubMenu();
	public static HighScoresMenu highScoresMenu = new HighScoresMenu();
	public static HTPMenu htpMenu = new HTPMenu();
	public static PauseMenu pauseMenu = new PauseMenu();
	
	static JLayeredPane layeredPane = new JLayeredPane();
	
	private static Action leftAction;
	private static Action rightAction;
	private static Action exitAction;
	
	static MediaPlayer mediaPlayer;
	
	static JFXPanel fxPanel;
	
	static String[] songLocs = new String[4];

    static int selectedSong = 1;

	public SwingStart() {
		songLocs[1] = "TheRiddle.mp3";
		songLocs[2] = "Madness.mp3";
		songLocs[3] = "Splinter.mp3";

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(372, 390);
		setLocationRelativeTo(null);
		setTitle("Music Game");
		setResizable(false);
		setVisible(true);
		
		fxPanel = new JFXPanel();
		add(fxPanel);
		
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel);
            }
        });
		
		rightAction = new RightAction();
		leftAction = new LeftAction();	
		exitAction = new ExitAction();

		board.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( KeyStroke.getKeyStroke("RIGHT") , "doRightAction" );
		board.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( KeyStroke.getKeyStroke("LEFT"), "doLeftAction" );
		board.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( KeyStroke.getKeyStroke("ESCAPE"), "doExitAction" );

		board.getActionMap().put( "doLeftAction" , leftAction );
		board.getActionMap().put( "doRightAction", rightAction );
		board.getActionMap().put( "doExitAction", exitAction );
		

		
		add(layeredPane);
		pauseMenu.setVisible(true);
		board.setVisible(true);
		
		layeredPane.add(pauseMenu, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(board, JLayeredPane.DEFAULT_LAYER);
		layeredPane.setLayer(board, 1);
		layeredPane.setLayer(pauseMenu, 0);
		layeredPane.setBounds(0,0,370,380);
		
		layeredPane.setVisible(false);


		add(subMenu);
		subMenu.setVisible(false);
		add(board);
		board.setVisible(false);
		add(menu);
		add(highScoresMenu);
		highScoresMenu.setVisible(false);
		add(htpMenu);
		htpMenu.setVisible(false);
		add(pauseMenu);
		pauseMenu.setVisible(false);
		
		
		add(layeredPane);
		pauseMenu.setVisible(false);
		board.setVisible(true);
		layeredPane.add(pauseMenu, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(board, JLayeredPane.DEFAULT_LAYER);
		layeredPane.setBounds(0,0,370,380);
		layeredPane.setVisible(false);

		
	}
    public static void initFX(JFXPanel fxPanel) {
        // This method is invoked on JavaFX thread
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }
    
    public static Scene createScene() {
    	Stage stage = new Stage();
    	
    	Group root = new Group();

    	File file = new File(songLocs[1]);
    	String uri = file.toURI().toString();
    	Media hit = new Media(uri);
    	mediaPlayer = new MediaPlayer(hit);
    	
    	Scene myScene = new Scene(root,400,400);
    	return myScene;
    	
    	
    }
    
    public static void reset() {
    	board.reset();
    	subMenu.reset();
    }

	public static void main(String[] args) {
		new SwingStart();
	}
}

class RightAction extends AbstractAction
{
    public void actionPerformed( ActionEvent e )
    {
       MusicGameBoard.user.rightPressed();
    }
} 
class LeftAction extends AbstractAction
{
  public void actionPerformed( ActionEvent e )
  {
     MusicGameBoard.user.leftPressed();
  }
} 
class ExitAction extends AbstractAction
{
  public void actionPerformed( ActionEvent e )
  {
	  SwingStart.pauseMenu.setVisible(true);
	  System.out.println("pause");
	  SwingStart.board.pause();
	  SwingStart.mediaPlayer.pause();
  }
} 
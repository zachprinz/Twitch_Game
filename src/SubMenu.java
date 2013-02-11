import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Label;
import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class SubMenu extends JPanel {
	static String[] beatLocs = new String[4];
	static ImageIcon backgroundImageIcon = new ImageIcon("subMenu.png");
	static Image backGroundImage = backgroundImageIcon.getImage();
	
	private int selectedDifficulty = 1;
	private int HARD = 4;
	private int EASY = 11;
	private int MEDIUM = 7;
	
	private int selectedSong = 0;
	
	Label lblStart;
	static GameLabel lblEasy;
	static GameLabel lblMedium;
	static GameLabel lblHard;
	static GameLabel lblTheRiddle;
	static GameLabel lblMaddness;
	static GameLabel lblSplinter;
	/**
	 * Create the panel.
	 */
	public SubMenu() {
		setFocusable(true);
		setBackground(Color.GRAY);
		setSize(366, 366);
		setLayout(null);
		
		lblEasy = new GameLabel("Easy");
		lblEasy.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEasy.setForeground(new Color(255, 255, 255));
		lblEasy.setBounds(236, 33, 90, 20);
		lblEasy.setLocation();
		lblEasy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearSelectedDifficulty();
		    	lblEasy.setLocation(lblEasy.getUpPoint());	
		    	lblEasy.setSelected(true);
		    	selectedDifficulty = EASY;
		    	lblEasy.setLocation(lblEasy.getUpPoint());		    	

			}
		});
		add(lblEasy);
		
		lblMedium = new GameLabel("Medium");
		lblMedium.setForeground(Color.WHITE);
		lblMedium.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMedium.setBounds(223, 77, 90, 20);
		lblMedium.setLocation();
		lblMedium.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				clearSelectedDifficulty();
		    	lblMedium.setLocation(lblMedium.getUpPoint());	
		    	lblMedium.setSelected(true);
		    	selectedDifficulty = MEDIUM;
		    	lblMedium.setLocation(lblMedium.getUpPoint());		    	

			}
		});
		add(lblMedium);
		
		lblHard = new GameLabel("Hard");
		lblHard.setForeground(Color.WHITE);
		lblHard.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHard.setBounds(237, 122, 90, 20);
		lblHard.setLocation();
		lblHard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearSelectedDifficulty();
		    	lblHard.setLocation(lblHard.getUpPoint());
		    	lblHard.setSelected(true);
		    	selectedDifficulty = HARD;
		    	lblHard.setLocation(lblHard.getUpPoint());		    	
			}
		});
		add(lblHard);
		
		lblTheRiddle = new GameLabel("The Riddle");
		lblTheRiddle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedSong = 1;
				clearSelectedSong();
				lblTheRiddle.setSelected(true);
		    	lblTheRiddle.setLocation(lblTheRiddle.getUpPoint());		    	
			}

		});

		lblTheRiddle.setForeground(Color.WHITE);
		lblTheRiddle.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTheRiddle.setBounds(52, 221, 178, 20);
		lblTheRiddle.setLocation();
		add(lblTheRiddle);
		
		lblMaddness = new GameLabel("Maddness");
		lblMaddness.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedSong = 2;
				clearSelectedSong();
				lblMaddness.setSelected(true);
		    	lblMaddness.setLocation(lblMaddness.getUpPoint());		    	
			}
		});
		lblMaddness.setForeground(Color.WHITE);
		lblMaddness.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMaddness.setBounds(50, 267, 176, 20);
		lblMaddness.setLocation();
		add(lblMaddness);
		
		lblSplinter = new GameLabel("Splinter");
		lblSplinter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedSong = 3;
				clearSelectedSong();
				lblSplinter.setSelected(true);
		    	lblSplinter.setLocation(lblSplinter.getUpPoint());		    	

			}
		});
		lblSplinter.setForeground(Color.WHITE);
		lblSplinter.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSplinter.setBounds(50, 313, 178, 20);
		lblSplinter.setLocation();
		add(lblSplinter);
		
		lblStart = new Label("Start");
		lblStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearSelectedSong();
				clearSelectedDifficulty();
				setVisible(false);
				setFocusable(false);
				SwingStart.board.setFocusable(true);
				SwingStart.layeredPane.setFocusable(true);
				SwingStart.layeredPane.setVisible(true);
				//SwingStart.pauseMenu.setVisible(true);
				System.out.println(getSong());
				SwingStart.board.mlm.loadLevel(beatLocs[selectedSong]);
				SwingStart.board.getLevel();
				SwingStart.mediaPlayer = new MediaPlayer(getSong());
				SwingStart.mediaPlayer.play();
				SwingStart.board.startGame();
			}
		    public void mouseEntered(MouseEvent evt) {
		    	lblStart.setFont(new Font("Tahoma", Font.BOLD, 20));		    	
		    }
		    public void mouseExited(MouseEvent evt) {
		    	lblStart.setFont(new Font("Tahoma", Font.BOLD, 16));
		    }
		});
		lblStart.setForeground(Color.WHITE);
		lblStart.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStart.setBounds(240, 269, 57, 20);
		add(lblStart);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				setFocusable(false);
				SwingStart.menu.setVisible(true);
			}
		});
		lblNewLabel.setBounds(2, 2, 31, 31);
		add(lblNewLabel);
				
		beatLocs[0] = "TheRiddle";
		beatLocs[1] = "TheRiddle";
		beatLocs[2] = "Madness";
		beatLocs[3] = "Splinter";
		
	}
	public void paintComponent( Graphics g )
	{
	  super.paintComponent( g );
	  Graphics2D g2d = (Graphics2D) g;
	  g2d.drawImage(backGroundImage, 0, 0, this);

	}
	
	public void reset() {
		clearSelectedSong();
		clearSelectedDifficulty();
	}
	
	public Media getSong() {
    	File file = new File(SwingStart.songLocs[selectedSong]);
    	String uri = file.toURI().toString();
    	Media hit = new Media(uri);
    	return hit;
	}
	
	public int getSpeed() {
		return selectedDifficulty;
	}
	
	public void clearSelectedSong() {
		if(lblTheRiddle.getSelected()){
			lblTheRiddle.setSelected(false);
	    	lblTheRiddle.setLocation(lblTheRiddle.getStartPoint());		    	
		}
		if(lblMaddness.getSelected()) {
			lblMaddness.setSelected(false);
    		lblMaddness.setLocation(lblMaddness.getStartPoint());		    	
		}
		if(lblSplinter.getSelected()) {
			lblSplinter.setSelected(false);
	    	lblSplinter.setLocation(lblSplinter.getStartPoint());		    	
		}

		}
	
	public static void clearSelectedDifficulty() {
		if(lblEasy.getSelected())
			lblEasy.setSelected(false);
		if(lblMedium.getSelected())
			lblMedium.setSelected(false);
		if(lblHard.getSelected())
			lblHard.setSelected(false);
			
		}
	}


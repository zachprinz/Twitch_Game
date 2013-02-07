import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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
	
	GameLabel lblStart;
	GameLabel lblEasy;
	GameLabel lblMedium;
	GameLabel lblHard;
	GameLabel lblTheRiddle;
	GameLabel lblMaddness;
	GameLabel lblSplinter;
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
		lblEasy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				clearSelectedDifficulty();
		    	lblEasy.setLocation((int)lblEasy.getLocation().getX() + 20,(int) lblEasy.getLocation().getY());		    	
			}
		    public void mouseEntered(MouseEvent evt) {
		    	lblEasy.setLocation((int)lblEasy.getLocation().getX() + 15,(int) lblEasy.getLocation().getY());		    	
		    }
		    public void mouseExited(MouseEvent evt) {
		    	lblEasy.setLocation((int)lblEasy.getLocation().getX() - 15,(int) lblEasy.getLocation().getY());		    	
		    }
		});
		add(lblEasy);
		
		lblMedium = new GameLabel("Medium");
		lblMedium.setForeground(Color.WHITE);
		lblMedium.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMedium.setBounds(223, 69, 90, 20);
		lblMedium.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				clearSelectedDifficulty();
		    	lblMedium.setLocation((int)lblMedium.getLocation().getX() + 20,(int) lblMedium.getLocation().getY());		    	
			}
		    public void mouseEntered(MouseEvent evt) {
		    	lblMedium.setLocation((int)lblMedium.getLocation().getX() + 15,(int) lblMedium.getLocation().getY());		    	
		    }
		    public void mouseExited(MouseEvent evt) {
		    	lblMedium.setLocation((int)lblMedium.getLocation().getX() - 15,(int) lblMedium.getLocation().getY());		    	
		    }
		});
		add(lblMedium);
		
		lblHard = new GameLabel("Hard");
		lblHard.setForeground(Color.WHITE);
		lblHard.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHard.setBounds(237, 104, 90, 20);
		lblHard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				clearSelectedDifficulty();
		    	lblHard.setLocation((int)lblHard.getLocation().getX() + 20,(int) lblHard.getLocation().getY());		    	
			}
		    public void mouseEntered(MouseEvent evt) {
		    	lblHard.setLocation((int)lblHard.getLocation().getX() + 15,(int) lblHard.getLocation().getY());		    	
		    }
		    public void mouseExited(MouseEvent evt) {
		    	lblHard.setLocation((int)lblHard.getLocation().getX() - 15,(int) lblHard.getLocation().getY());		    	
		    }
		});
		add(lblHard);
		
		lblTheRiddle = new GameLabel("The Riddle");
		lblTheRiddle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SwingStart.selectedSong = 1;
				clearSelectedSong();
				lblTheRiddle.setSelected(true);
			}
		    public void mouseEntered(MouseEvent evt) {
		    	if(!lblTheRiddle.getSelected())
		    	lblTheRiddle.setLocation((int)lblTheRiddle.getLocation().getX() + 15,(int) lblTheRiddle.getLocation().getY());		    	
		    }
		    public void mouseExited(MouseEvent evt) {
		    	if(!lblTheRiddle.getSelected())
		    	lblTheRiddle.setLocation((int)lblTheRiddle.getLocation().getX() - 15,(int) lblTheRiddle.getLocation().getY());		    	
		    }
		});

		lblTheRiddle.setForeground(Color.WHITE);
		lblTheRiddle.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTheRiddle.setBounds(149, 155, 178, 20);
		add(lblTheRiddle);
		
		lblMaddness = new GameLabel("Maddness");
		lblMaddness.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SwingStart.selectedSong = 2;
				clearSelectedSong();
				lblMaddness.setSelected(true);
			}
		    public void mouseEntered(MouseEvent evt) {
		    	if(!lblMaddness.getSelected())
		    	lblMaddness.setLocation((int)lblMaddness.getLocation().getX() + 15,(int) lblMaddness.getLocation().getY());		    	
		    }
		    public void mouseExited(MouseEvent evt) {
		    	if(!lblMaddness.getSelected())
		    	lblMaddness.setLocation((int)lblMaddness.getLocation().getX() - 15,(int) lblMaddness.getLocation().getY());		    	
		    }
		});
		lblMaddness.setForeground(Color.WHITE);
		lblMaddness.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMaddness.setBounds(151, 192, 176, 20);
		add(lblMaddness);
		
		lblSplinter = new GameLabel("Splinter");
		lblSplinter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SwingStart.selectedSong = 3;
				clearSelectedSong();
				lblSplinter.setSelected(true);
			}
		    public void mouseEntered(MouseEvent evt) {
		    	if(!lblSplinter.getSelected())
		    	lblSplinter.setLocation((int)lblSplinter.getLocation().getX() + 15,(int) lblSplinter.getLocation().getY());		    	
		    }
		    public void mouseExited(MouseEvent evt) {
		    	if(!lblSplinter.getSelected())
		    	lblSplinter.setLocation((int)lblSplinter.getLocation().getX() - 15,(int) lblSplinter.getLocation().getY());		    	
		    }
		});
		lblSplinter.setForeground(Color.WHITE);
		lblSplinter.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSplinter.setBounds(148, 231, 178, 20);
		add(lblSplinter);
		
		lblStart = new GameLabel("Start");
		lblStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearSelectedSong();
				clearSelectedDifficulty();
				setVisible(false);
				setFocusable(false);
				lblTheRiddle.setText("The Riddle");
				lblMaddness.setText("Maddness");
				System.out.println(getSong());
				SwingStart.board.mlm.loadLevel(beatLocs[SwingStart.selectedSong]);
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
		lblStart.setBounds(148, 302, 90, 20);
		add(lblStart);
				
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
	
	public Media getSong() {
    	File file = new File(SwingStart.songLocs[SwingStart.selectedSong]);
    	String uri = file.toURI().toString();
    	Media hit = new Media(uri);
    	return hit;
	}
	
	public void clearSelectedSong() {
		if(lblTheRiddle.getSelected()){
			lblTheRiddle.setSelected(false);
	    	lblTheRiddle.setLocation((int)lblTheRiddle.getLocation().getX() - 15,(int) lblTheRiddle.getLocation().getY());		    	
		}
		if(lblMaddness.getSelected()) {
			lblMaddness.setSelected(false);
    		lblMaddness.setLocation((int)lblMaddness.getLocation().getX() - 15,(int) lblMaddness.getLocation().getY());		    	
	}
		if(lblSplinter.getSelected()) {
			lblSplinter.setSelected(false);
	    	lblSplinter.setLocation((int)lblSplinter.getLocation().getX() - 15,(int) lblSplinter.getLocation().getY());		    	
		}

		}
	
	public void clearSelectedDifficulty() {
		if(lblEasy.getSelected())
			lblEasy.setSelected(false);
		if(lblMedium.getSelected())
			lblMedium.setSelected(false);
		if(lblHard.getSelected())
			lblHard.setSelected(false);
			
		}
	}


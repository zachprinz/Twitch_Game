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
	static String[] beatLocs = new String[3];
	static ImageIcon backgroundImageIcon = new ImageIcon("subMenu.png");
	static Image backGroundImage = backgroundImageIcon.getImage();
	/**
	 * Create the panel.
	 */
	public SubMenu() {
		setFocusable(true);
		setBackground(Color.GRAY);
		setSize(366, 366);
		setLayout(null);
		
		JLabel lblEasy = new JLabel("Easy");
		lblEasy.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEasy.setForeground(new Color(255, 255, 255));
		lblEasy.setBounds(236, 33, 90, 20);
		add(lblEasy);
		
		JLabel lblMedium = new JLabel("Medium");
		lblMedium.setForeground(Color.WHITE);
		lblMedium.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMedium.setBounds(223, 69, 90, 20);
		add(lblMedium);
		
		JLabel lblHard = new JLabel("Hard");
		lblHard.setForeground(Color.WHITE);
		lblHard.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHard.setBounds(237, 104, 90, 20);
		add(lblHard);
		
		final JLabel lblTheRiddle = new JLabel("The Riddle");
		lblTheRiddle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SwingStart.selectedSong = 1;
				lblTheRiddle.setText("    TheRiddle");
			}
		});
		lblTheRiddle.setForeground(Color.WHITE);
		lblTheRiddle.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTheRiddle.setBounds(149, 155, 178, 20);
		add(lblTheRiddle);
		
		final JLabel lblMaddness = new JLabel("Maddness");
		lblMaddness.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SwingStart.selectedSong = 2;
				lblMaddness.setText("    Maddness");
			}
		});
		lblMaddness.setForeground(Color.WHITE);
		lblMaddness.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMaddness.setBounds(151, 192, 176, 20);
		add(lblMaddness);
		
		JLabel lblSplinter = new JLabel("Splinter");
		lblSplinter.setForeground(Color.WHITE);
		lblSplinter.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSplinter.setBounds(148, 231, 178, 20);
		add(lblSplinter);
		
		JLabel lblStart = new JLabel("Start");
		lblStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
		});
		lblStart.setForeground(Color.WHITE);
		lblStart.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStart.setBounds(148, 302, 90, 20);
		add(lblStart);
				
		beatLocs[0] = "TheRiddle";
		beatLocs[1] = "TheRiddle";
		beatLocs[2] = "Madness";

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
}
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;


public class PauseMenu extends JPanel {
	static ImageIcon backgroundImageIcon = new ImageIcon("pauseMenu.png");
	static Image pauseMenuBack = backgroundImageIcon.getImage();

	/**
	 * Create the panel.
	 */
	public PauseMenu() {
		setFocusable(true);
		//setBackground(Color.GRAY);
		setBounds(43,43,280,280);
		setSize(280, 280);
		setLayout(null);
		
		GameLabel lblResume = new GameLabel("Resume");
		lblResume.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SwingStart.mediaPlayer.play();
				setVisible(false);
				SwingStart.board.unPause();
				setFocusable(false);
			}
		});
		lblResume.setFont(new Font("Modeno LX", Font.PLAIN, 25));
		lblResume.setBounds(107, 116, 74, 28);
		lblResume.setLocation();
		add(lblResume);
		
		GameLabel lblMainMenu = new GameLabel("Main Menu");
		lblMainMenu.setFont(new Font("Modeno LX", Font.PLAIN, 25));
		lblMainMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SwingStart.reset();
				SwingStart.board.pause();
			    SwingStart.menu.setVisible(true);
			    SwingStart.menu.setFocusable(true);
			    SwingStart.mediaPlayer.stop();
				SwingStart.layeredPane.setVisible(false);
				SwingStart.pauseMenu.setVisible(false);
				SwingStart.board.setFocusable(false);
				SwingStart.pauseMenu.setFocusable(false);
			}
		});
		lblMainMenu.setBounds(91, 179, 95, 34);
		lblMainMenu.setLocation();
		add(lblMainMenu);
		
	}
	
	public void paintComponent( Graphics g )
	{
	  super.paintComponent( g );
	  Graphics2D g2d = (Graphics2D) g;
	  g2d.drawImage(pauseMenuBack,0,0, this);

	}
}

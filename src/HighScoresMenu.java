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


public class HighScoresMenu extends JPanel {
	static ImageIcon backgroundImageIcon = new ImageIcon("highScoresMenuBack.png");
	static Image highScoresBackground = backgroundImageIcon.getImage();

	/**
	 * Create the panel.
	 */
	public HighScoresMenu() {
		setFocusable(true);
		setBackground(Color.GRAY);
		setSize(366, 366);
		setLayout(null);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				setFocusable(false);
				SwingStart.menu.setVisible(true);
			}
		});
		label.setBounds(2, 3, 39, 37);
		add(label);
		
	}
	public void paintComponent( Graphics g )
	{
	  super.paintComponent( g );
	  Graphics2D g2d = (Graphics2D) g;
	  g2d.drawImage(highScoresBackground, 0, 0, this);

	}
	}

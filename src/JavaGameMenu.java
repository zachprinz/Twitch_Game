import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TimerTask;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.ArcType;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;


public class JavaGameMenu extends JPanel{

	
	static String[] beatLocs = new String[4];
	static ImageIcon backgroundImageIcon = new ImageIcon("MenuBack.png");
	static Image backGroundImage = backgroundImageIcon.getImage();

	/**
	 * Create the panel.
	 */
	public JavaGameMenu() {
		setFocusable(true);
		setBackground(Color.GRAY);
		setSize(366, 366);
		setLayout(null);
				
		beatLocs[0] = "TheRiddle";
		beatLocs[1] = "TheRiddle";
		beatLocs[2] = "Madness";
		beatLocs[3] = "Splinter";
		
		final JLabel lblPlay = new JLabel("Play");
		lblPlay.setForeground(Color.WHITE);
		lblPlay.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				setFocusable(false);
				SwingStart.subMenu.setVisible(true);
			}
		});
		lblPlay.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblPlay.setBounds(143, 307, 101, 45);
		add(lblPlay);
		lblPlay.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	lblPlay.setFont(new Font("Tahoma", Font.BOLD, 30));		    	
		    }
		    public void mouseExited(MouseEvent evt) {
		    	lblPlay.setFont(new Font("Tahoma", Font.BOLD, 26));
		    }
		});
		
		final JLabel lblOptions_1 = new JLabel("How To Play");
		lblOptions_1.setForeground(Color.WHITE);
		lblOptions_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblOptions_1.setBounds(115, 201, 181, 57);
		lblOptions_1.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	lblOptions_1.setFont(new Font("Tahoma", Font.BOLD, 26));		    	
		    }
		    public void mouseExited(MouseEvent evt) {
		    	lblOptions_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		    }
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				setFocusable(false);
				SwingStart.htpMenu.setVisible(true);
			}
		});
		add(lblOptions_1);

		final JLabel lblScores_1 = new JLabel("Scores");
		lblScores_1.setForeground(Color.WHITE);
		lblScores_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblScores_1.setBounds(137, 254, 129, 57);
		lblScores_1.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	lblScores_1.setFont(new Font("Tahoma", Font.BOLD, 30));		    	
		    }
		    public void mouseExited(MouseEvent evt) {
		    	lblScores_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		    }
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				setFocusable(false);
				SwingStart.highScoresMenu.setVisible(true);
			}
		    
		});
		add(lblScores_1);
	}
	
	public void paintComponent( Graphics g )
	{
	  super.paintComponent( g );
	  Graphics2D g2d = (Graphics2D) g;
	  g2d.drawImage(backGroundImage, 0, 0, this);
	}
	
	public Media getSong() {
    	File file = new File(SwingStart.songLocs[1]);
    	String uri = file.toURI().toString();
    	Media hit = new Media(uri);
    	return hit;
	}
	
}



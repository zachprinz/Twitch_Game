import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

public class GameLabel extends JLabel{
	
	public boolean selected = false;
	public Point startPoint;
	public Point upPoint;
			
	public GameLabel(String text) {
		super(text);
		selected = false;
		this.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseEntered(MouseEvent evt) {
		    	if(!getSelected())
		    	setLocation(upPoint);		    	
		    }
		    public void mouseExited(MouseEvent evt) {
		    	if(!getSelected())
		    	setLocation(startPoint);		    	
		    }
		});
	}
	
	public void setLocation() {
		startPoint = getLocation();
		upPoint = new Point((int) startPoint.getX() + 15,(int) startPoint.getY());
	}
	
	public void setSelected(Boolean x) {
		selected = x;
	}
	
	public boolean getSelected() {
		return selected;
	}
	
	public Point getUpPoint() {
		return upPoint;
	}
	public Point getStartPoint() {
		return startPoint;
	}
}

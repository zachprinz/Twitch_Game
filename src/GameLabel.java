import javax.swing.JLabel;


public class GameLabel extends JLabel{
	
	public boolean selected = false;
			
	public GameLabel(String text) {
		super(text);
		selected = false;
	}
	
	public void setSelected(Boolean x) {
		selected = x;
	}
	
	public boolean getSelected() {
		return selected;
	}
}

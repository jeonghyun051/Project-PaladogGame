package DarkDog;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Main.GamePanel;
import lombok.Data;

@Data
public class DarkDog extends JLabel {
	public ImageIcon darkIcon, dark_attackicon;
	public DarkDog darkdog = this;
	public GamePanel gamepanel;
	public int x = 940;
	public int y = 190;
	public int hp = 100;
	public final static String TAG = "DarkDog:";
	public boolean isMoving = true;

	public DarkDog() {

		darkIcon = new ImageIcon("images/darkdog.png");
		dark_attackicon = new ImageIcon("images/mouse_attackimg.gif");
		setIcon(darkIcon);
		setSize(190, 190);
		setLocation(x, y);
	
	}


}
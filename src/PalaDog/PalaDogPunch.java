package PalaDog;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import DarkDog.Zombie;
import Main.GamePanel;

public class PalaDogPunch extends JLabel {
	public GamePanel gamepanel;
	public PalaDogPunch punch = this;
	public ImageIcon icPunch;
	public int Punchx;
	public int Punchy;
	public boolean isPunch = true;
	public int attack=10;
	public PalaDogPunch() {
		icPunch = new ImageIcon("images/PaladogPunch.jpg");
		setSize(80, 80);
		setIcon(icPunch);
	}

	public void moveRight() {
		// 스레드가 돌면서 x 값변경하면서 repaint()
		ArrayList<PalaDogPunch> PList = new ArrayList<PalaDogPunch>();
		PList.add(punch);
		new Thread(new Runnable() {
			@Override
			public void run() {

				while (isPunch) {
					Punchx = Punchx + 10;
					try {
						
						Thread.sleep(20);
						setLocation(Punchx, Punchy);
						for (int i = 0; i < PList.size(); i++) {
//							System.out.println("펀치의  i의좌표"+PList.get(i).getX());
						}

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}).start();
	}
	
	
	
	
}

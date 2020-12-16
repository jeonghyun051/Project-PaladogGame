package PalaDog;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import DarkDog.DarkDog;
import DarkDog.Zombie;
import Main.GamePanel;
import lombok.Data;

@Data
public class Bear extends JLabel {
	public ImageIcon bearIcon, bear_attackicon;
	public Bear bear = this;
	public GamePanel gamepanel;
	public int x = 0;
	public int y = 220;
	public int z = 30;

	public int hp = 50;
	public int attack = 10;
	public final static String TAG = "Bear:";
	public boolean isMoving = true;

	public Bear() {

		bearIcon = new ImageIcon("images/bear_walk.gif");
		bear_attackicon = new ImageIcon("images/bear_attack.gif");
		setIcon(bearIcon);
		setSize(120, 120);
		setLocation(x, y);
		MoveLight();

	}

	public void MoveLight() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {

					try {
						Thread.sleep(1);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					while (isMoving) {
						bear.x += 10;
						setLocation(x, y);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}).start();
	}
	public static void Bear_attack(ArrayList<Bear> bear, ArrayList<Zombie> zombie, DarkDog darkdog) {

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						for (int i = 0; i < bear.size(); i++) {
							for (int j = 0; j < zombie.size(); j++) {
								try {
									if (bear.get(i).x >= zombie.get(j).x - 100) {
										System.out.println("false실행");
										bear.get(i).isMoving = false;
										bear.get(i).setIcon(bear.get(i).bear_attackicon);
										Thread.sleep(500);

										try {
											zombie.get(j).hp = zombie.get(j).hp - bear.get(i).attack;
										} catch (Exception e) {
											// TODO: handle exception
										}

									}
								} catch (Exception e) {
									// TODO: handle exception
								}

							}

						}

						for (int i = 0; i < bear.size(); i++) {
							for (int j = 0; j < zombie.size(); j++) {
								if (bear.get(i).x >= darkdog.getX() - 100 && darkdog.getX() <= bear.get(i).x +100) {
									System.out.println("다크독공격실행");
									bear.get(i).isMoving = false;
									bear.get(i).setIcon(bear.get(i).bear_attackicon);
									Thread.sleep(500);
									darkdog.hp = darkdog.hp - bear.get(i).attack;

								} else {
									try {
				
										bear.get(i).isMoving = true;
										bear.get(i).setIcon(bear.get(i).bearIcon);
										Thread.sleep(100);
									} catch (Exception e) {
										// TODO: handle exception
									}

								}
							}
						

						}

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}).start();
	}
	
}

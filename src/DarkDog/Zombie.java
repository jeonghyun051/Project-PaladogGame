package DarkDog;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Main.GamePanel;
import PalaDog.Bear;
import PalaDog.Mouse;
import PalaDog.PalaDog;
import lombok.Data;

public class Zombie extends JLabel {
	public ImageIcon zombieIcon, zombie_attackIcon, zombie_attackIcon2;
	public PalaDog paladog;
	public GamePanel gamepanel;
	public Zombie zombie = this;
	public int x = 1100;
	public int y = 240;
	public int hp = 50;
	public int attack = 5;
	public final static String TAG = "Zombie:";
	public Boolean isMoving2 = true;

	public Zombie() {
		
		zombieIcon = new ImageIcon("images/zombie_walk.gif");
		zombie_attackIcon = new ImageIcon("images/zombie_attack01.png");
		zombie_attackIcon2 = new ImageIcon("images/zombie_attack02.png");
		setIcon(zombieIcon);
		setSize(90, 90);
		setLocation(x, y);

	}

	public void MoveLeft() {
		new Thread(new Runnable() {

			@Override
			synchronized public void run() {
				while (true) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					while (isMoving2) {
						zombie.x -= 10;
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

	public static void Zombie_attack(ArrayList<Mouse> mouse, ArrayList<Zombie> zombie, PalaDog paladog) {

		new Thread(new Runnable() {

			@Override
			public void run() {

				while (true) {

					try {
						for (int i = 0; i < zombie.size(); i++) {
							for (int j = 0; j < mouse.size(); j++) {

								// while(zombie.get(j).x <= mouse.get(i).x + 100 && zombie.size() != 0)
								try {
									if (zombie.get(i).x <= mouse.get(j).x + 100) {
										System.out.println("false실행");
										zombie.get(i).isMoving2 = false;

										zombie.get(i).setIcon(zombie.get(i).zombie_attackIcon);
										Thread.sleep(150);

										try {
											zombie.get(i).setIcon(zombie.get(i).zombie_attackIcon2);
										} catch (Exception e) {
											// TODO: handle exception
										}

										Thread.sleep(150);
										// zombie.get(i).hp = zombie.get(i).hp - mouse.get(j).attack;

										try {
											mouse.get(j).hp = mouse.get(j).hp - zombie.get(i).attack;
										} catch (Exception e) {
											// TODO: handle exception
										}

									}
								} catch (Exception e) {
									// TODO: handle exception
								}

							}

						}
						try {
						for (int i = 0; i < zombie.size(); i++) {
							if (zombie.get(i).x <= paladog.getX() + 150) {
								System.out.println("false실행");
								zombie.get(i).isMoving2 = false;

								zombie.get(i).setIcon(zombie.get(i).zombie_attackIcon);
								Thread.sleep(400);

								zombie.get(i).setIcon(zombie.get(i).zombie_attackIcon2);
								Thread.sleep(400);
								paladog.hp = paladog.hp - zombie.get(i).attack;
								System.out.println(paladog.hp);

							} else {
								try {

									zombie.get(i).isMoving2 = true;
									zombie.get(i).setIcon(zombie.get(i).zombieIcon);
								} catch (Exception e) {
									// TODO: handle exception
								}

							}

						}
						}catch (Exception e) {
							// TODO: handle exception
						}

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}).start();

}
	
	public static void Zombie_attack2(ArrayList<Bear> bear, ArrayList<Zombie> zombie) {

		new Thread(new Runnable() {

			@Override
			public void run() {

				while (true) {

					try {
						for (int i = 0; i < zombie.size(); i++) {
							for (int j = 0; j < bear.size(); j++) {

								// while(zombie.get(j).x <= mouse.get(i).x + 100 && zombie.size() != 0)
								try {
									if (zombie.get(i).x <= bear.get(j).x + 100) {
										System.out.println("false실행");
										zombie.get(i).isMoving2 = false;
										zombie.get(i).setIcon(zombie.get(i).zombie_attackIcon);
										Thread.sleep(200);
										try {
											zombie.get(i).setIcon(zombie.get(i).zombie_attackIcon2);
										} catch (Exception e) {
											// TODO: handle exception
										}

										Thread.sleep(200);
										// zombie.get(i).hp = zombie.get(i).hp - mouse.get(j).attack;

										try {
											bear.get(j).hp = bear.get(j).hp - zombie.get(i).attack;
										} catch (Exception e) {
											// TODO: handle exception
										}

									}
								} catch (Exception e) {
									// TODO: handle exception
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
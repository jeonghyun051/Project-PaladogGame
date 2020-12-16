package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DarkDog.DarkDog;
import DarkDog.Zombie;
import Main.GamePanel.MouseHpLabel;
import Main.GamePanel.PalaDogHpLabel;
import Main.GamePanel.ZombieHpLabel;
import Main.GamePanel.Á×´Â½º·¹µå;
import PalaDog.Bear;
import PalaDog.Mouse;
import PalaDog.PalaDog;
import PalaDog.PalaDogPunch;

public class GamePanel extends JFrame {
	private MyPanel m1, m2;
	private Mouse mouse;
	private Bear bear;
	private Zombie zombie;
	private PalaDog paladog;
	private PalaDogPunch punch;
	private DarkDog darkdog;
	private boolean count = true;
	public boolean isEnding = true;
	public boolean isÁ»ºñ¼ÒÈ¯ = true;
	public boolean is¶óº§¹«ºù = false;
	private ZombieHpLabel zombiehplabel;
	private MouseHpLabel mousehplabel;
	private BearHpLabel bearhplabel;
	private PalaDogHpLabel paladoghplabel;
	private DarkDogHpLabel darkdoghplabel;

	public GamePanel gamepanel;
	private ArrayList<Zombie> zombielist;
	private ArrayList<Mouse> mouselist;
	private ArrayList<Bear> bearlist;
	private ArrayList<PalaDogPunch> punchlist;
	public ArrayList<ZombieHpLabel> Zombiehplabellist;
	public ArrayList<MouseHpLabel> mousehplabellist;
	public ArrayList<BearHpLabel> bearhplist;
	public int sohwanhp = 0;
	public int skillmp = 0;

	ImageIcon img;
	JPanel panel;
	JLabel bottom_imgLabel, goldLabel, mpLabel, hpLabel;

	public int back1X = 0;
	public ImageIcon backicon = new ImageIcon("images/background_img.png");
	public Image backimg = backicon.getImage();
	public int back2X = backimg.getWidth(null);

	public GamePanel() {

		init();
		setting();
		batch();
		listener();

		setVisible(true);

	}

	public void init() {

		panel = new MyPanel();

		img = new ImageIcon("images/mainbottom4.jpg");

		bottom_imgLabel = new JLabel();
		goldLabel = new JLabel("0/40");
		mpLabel = new JLabel("0/40");
		hpLabel = new JLabel("100");
		mouselist = new ArrayList<Mouse>();
		zombielist = new ArrayList<Zombie>();
		Zombiehplabellist = new ArrayList<>();
		mousehplabellist = new ArrayList<>();
		bearlist = new ArrayList<Bear>();
		bearhplist = new ArrayList<>();
		punchlist = new ArrayList<>();
		ZombieSoHwan zombiesohwan = new ZombieSoHwan();
		zombiesohwan.start();

		GoldLabel goldLabel = new GoldLabel();
		goldLabel.start();

		SkillLabel skillLabel = new SkillLabel();
		skillLabel.start();

		paladog = new PalaDog();
		paladoghplabel = new PalaDogHpLabel();
		darkdog = new DarkDog();
		darkdoghplabel = new DarkDogHpLabel();

		HpLabelMoving hpLabelMoving = new HpLabelMoving();
		hpLabelMoving.start();
		
		mouse.Mouse_attack(mouselist, zombielist, darkdog);
		bear.Bear_attack(bearlist, zombielist, darkdog);
		zombie.Zombie_attack(mouselist, zombielist, paladog);
		zombie.Zombie_attack2(bearlist, zombielist);
		ÆÝÄ¡¾îÅÃ(punchlist,zombielist);
		
		Á×´Â½º·¹µå Á×´Â½º·¹µå = new Á×´Â½º·¹µå();
		Á×´Â½º·¹µå.start();

		
	}

	public void setting() {
		setSize(1130, 574);
		// setSize(760, 574);
		setLocationRelativeTo(null); // ÇÁ·¹ÀÓÀ» Áß¾Ó¹èÄ¡
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(panel);
		// panel.setBounds(0, 0, 743, 375);
		panel.setBounds(0, 0, 1500, 375);
		panel.setLayout(null);
		bottom_imgLabel.setIcon(img);
		// bottom_imgLabel.setBounds(0, 372, 743, 165);
		bottom_imgLabel.setBounds(0, 372, 1500, 165);

		goldLabel.setBounds(812, 480, 57, 30);
		getContentPane().add(goldLabel);
		goldLabel.setForeground(Color.orange);
		goldLabel.setFont(new Font("", Font.PLAIN, 18));

		mpLabel.setBounds(995, 480, 57, 30);
		mpLabel.setForeground(Color.blue);
		mpLabel.setFont(new Font("", Font.PLAIN, 18));

		hpLabel.setBounds(200, 200, 200, 200);
		hpLabel.setForeground(Color.red);
		hpLabel.setFont(new Font("", Font.PLAIN, 30));
		hpLabel.setVisible(false);
	}

	public void batch() {
		getContentPane().add(hpLabel);
		getContentPane().add(goldLabel);
		getContentPane().add(mpLabel);
		getContentPane().add(panel);
		panel.add(paladog);
		panel.add(paladoghplabel);
		panel.add(darkdog);
		panel.add(darkdoghplabel);
		getContentPane().add(bottom_imgLabel);

	}

	public void listener() {

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == '1') {
					new Thread(new Runnable() {

						@Override
						public void run() {
							if (sohwanhp > 10) {

								sohwanhp -= 10;
								mouse = new Mouse();
								mousehplabel = new MouseHpLabel();
								mouselist.add(mouse);
								mousehplabellist.add(mousehplabel);
								panel.add(mousehplabel);
								panel.add(mouse);

							}

						}
					}).start();

				}

				if (e.getKeyChar() == '3') {
					new Thread(new Runnable() {

						@Override
						public void run() {
							if (sohwanhp > 30) {
								sohwanhp -= 30;
								bear = new Bear();
								bearlist.add(bear);
								bearhplabel = new BearHpLabel();
								bearhplist.add(bearhplabel);
								panel.add(bear);
								panel.add(bearhplabel);

							}
						}
					}).start();

				}

				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					paladog.moveLeft();

					// System.out.println("ÆÈ¶óµ¶ xÁÂÇ¥ : " + paladog.x);

				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					paladog.moveRight();

					// System.out.println("ÆÈ¶óµ¶ xÁÂÇ¥ : " + paladog.x);
				}
				if (e.getKeyChar() == 'j') {

					new Thread(new Runnable() {

						@Override
						synchronized public void run() {
							if (skillmp > 10) {

								punch = new PalaDogPunch();
								punchlist.add(punch);
								panel.add(punch);
								punch.moveRight();
								punch.Punchx = paladog.x+50;
								punch.Punchy = paladog.y + 50;
								skillmp = skillmp - 10;
								

							}

						}
					}).start();

				} else if (e.getKeyChar() == 'J') {

					new Thread(new Runnable() {
						@Override
						synchronized public void run() {
							punch = new PalaDogPunch();
							punchlist.add(punch);
							panel.add(punch);
							punch.moveRight();
							punch.Punchx = paladog.x+50;
							punch.Punchy = paladog.y + 50;
							;

						}
					}).start();
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					paladog.isLeft = false;
					paladog.Letf();

				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					paladog.isRight = false;
					paladog.Right();

				}
			}
		});

	}

	class Á×´Â½º·¹µå extends Thread {
		@Override
		public void run() {
			try {
				while (isEnding) {
					Thread.sleep(1);
					for (int i = 0; i < zombielist.size(); i++) {
						if (zombielist.get(i).hp <= 0 || zombielist.get(i).x < 0) {
							panel.remove(zombielist.get(i));
							panel.remove(Zombiehplabellist.get(i));
							zombielist.remove(i);
							Zombiehplabellist.remove(i);
							panel.repaint();
						}
					}
					for (int i = 0; i < mouselist.size(); i++) {
						if (mouselist.get(i).hp <= 0) {
							panel.remove(mouselist.get(i));
							panel.remove(mousehplabellist.get(i));
							mousehplabellist.remove(i);
							mouselist.remove(i);
							panel.repaint();
						}
					}
					for (int i = 0; i < bearlist.size(); i++) {
						if (bearlist.get(i).hp <= 0) {
							panel.remove(bearlist.get(i));
							panel.remove(bearhplist.get(i));
							bearhplist.remove(i);
							bearlist.remove(i);
							panel.repaint();
						}
					}
					
					for (int i = 0; i < punchlist.size(); i++) {
						if(punchlist.get(i).getX() >1000) {
							panel.remove(punchlist.get(i));
							punchlist.remove(i);
							panel.repaint();
							
						}
					}
					
					if(paladog.hp <=0) {
						isEnding=false;
						new GameOver();
						setVisible(false);
						
						
					}
					
					if(darkdog.hp <=0) {
						isEnding=false;
						new EndImg();
						setVisible(false);
					
						
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public class GoldLabel extends Thread {

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				while (sohwanhp < 40) {
					try {
						sohwanhp++;

//                  System.out.println(hp);
						goldLabel.setText(sohwanhp + "/" + "40");

						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}

		}
	}

	public class HpLabelMoving extends Thread {
		@Override
		public void run() {

			while (true) {

				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					paladoghplabel.setLocation(paladog.x + 80, paladog.y - 80);
					darkdoghplabel.setLocation(darkdog.x + 55, darkdog.y - 70);
				} catch (Exception e) {
					// TODO: handle exception
				}

				try {
					paladoghplabel.setText(paladog.hp + "");
					darkdoghplabel.setText(darkdog.hp + "");
				} catch (Exception e) {
					// TODO: handle exception
				}

				for (int i = 0; i < mouselist.size(); i++) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						mousehplabellist.get(i).setLocation(mouselist.get(i).x + 30, mouselist.get(i).y - 50);
						mousehplabellist.get(i).setText(mouselist.get(i).hp + "");

					} catch (Exception e) {
						// TODO: handle exception
					}

				}

				for (int i = 0; i < zombielist.size(); i++) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						Zombiehplabellist.get(i).setLocation(zombielist.get(i).x + 30, zombielist.get(i).y - 50);
					} catch (Exception e) {
						// TODO: handle exception
					}

					try {
						Zombiehplabellist.get(i).setText(zombielist.get(i).hp + "");
					} catch (Exception e) {
						// TODO: handle exception
					}

				}
//   
				for (int i = 0; i < bearlist.size(); i++) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						bearhplist.get(i).setLocation(bearlist.get(i).x + 55, bearlist.get(i).y - 47);
					} catch (Exception e) {
						// TODO: handle exception
					}

					try {
						bearhplist.get(i).setText(bearlist.get(i).hp + "");
					} catch (Exception e) {
						// TODO: handle exception
					}

				}
			}
		}

	}

	public class SkillLabel extends Thread {

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e1) {

					e1.printStackTrace();
				}
				while (skillmp < 40) {
					try {
						skillmp++;
						mpLabel.setText(skillmp + "/" + "40");
						Thread.sleep(300);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
			}

		}
	}

	public class PalaDogHpLabel extends JLabel {
		public int x;
		public int y;

		public PalaDogHpLabel() {

			setForeground(Color.red);
			setSize(200, 200);
			setLocation(x, y);

		}

	}

	public class DarkDogHpLabel extends JLabel {
		public int x;
		public int y;

		public DarkDogHpLabel() {

			setForeground(Color.red);
			setSize(200, 200);
			setLocation(x, y);

		}

	}

	public class MouseHpLabel extends JLabel {
		public int x;
		public int y;

		public MouseHpLabel() {

			setForeground(Color.orange);
			setSize(80, 80);
			setLocation(x, y);

		}

	}
	public class ZombieHpLabel extends JLabel {
		public int x;
		public int y;

		public ZombieHpLabel() {

			setForeground(Color.cyan);
			setSize(80, 80);
			setLocation(x, y);

		}
	}
	public class BearHpLabel extends JLabel {
		public int x;
		public int y;

		public BearHpLabel() {

			setForeground(Color.orange);
			setSize(80, 80);
			setLocation(x, y);

		}
	}
	class ZombieSoHwan extends Thread {
		@Override
		public void run() {
			while (isÁ»ºñ¼ÒÈ¯) {
				zombie = new Zombie();
				zombie.MoveLeft();
				zombielist.add(zombie);
				panel.add(zombie);
				zombiehplabel = new ZombieHpLabel();
				panel.add(zombiehplabel);
				Zombiehplabellist.add(zombiehplabel);
				System.out.println("Á»ºñ ¼ÒÈ¯" + zombielist.size());
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void ÆÝÄ¡¾îÅÃ(ArrayList<PalaDogPunch> punchlist,ArrayList<Zombie> zombie) {
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
						for (int i = 0; i < punchlist.size(); i++) {
							for (int j = 0; j < zombie.size(); j++) {
								try {
									if (punchlist.get(i).getX() >= zombie.get(j).x - 50) {
										System.out.println("ÆÝÄ¡¸ÂÀ½");
										
										zombie.get(j).hp = zombie.get(j).hp - punchlist.get(i).attack;
										
										panel.remove(punchlist.get(i));
										punchlist.remove(i);
										panel.repaint();
										

									}
								} catch (Exception e) {
									// TODO: handle exception
								}

							}

						}
					}catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		}).start();
	}



	class MyPanel extends JPanel {
		public boolean isBackMoving = false;

		public MyPanel() {

		}

		@Override
		public void paintComponent(Graphics g) {

			super.paintComponent(g);

			g.drawImage(backimg, 0, 0, 1115, 375, this);
			// g.drawImage(backimg, back2X, 0, this);
		}
	}
}
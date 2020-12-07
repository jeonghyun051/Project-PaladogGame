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

import DarkDog.Zombie;
import PalaDog.Mouse;
import PalaDog.PalaDog;
import PalaDog.PalaDogPunch;
import PalaDog.PalaDog;

public class GamePanel extends JFrame {
	private MyPanel m1, m2;
	private Mouse mouse;
	private Zombie zombie;
	private PalaDog paladog;
	private PalaDogPunch punch;

	public GamePanel gamepanel;
	public ArrayList<Zombie> zombielist;
	public ArrayList<Mouse> mouselist;
	public ArrayList<PalaDogPunch> punchlist;
	public int hp = 0;

	ImageIcon img;
	JPanel panel;
	JLabel lblNewLabel_2, lblNewLabel;

	public int back1X = 0;
	public ImageIcon backicon = new ImageIcon("images/background_img3.png");
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

		img = new ImageIcon("images/mainbottom.jpg");

		lblNewLabel_2 = new JLabel();
		lblNewLabel = new JLabel("0/40");

		mouselist = new ArrayList<Mouse>();
		zombielist = new ArrayList<Zombie>();
		punchlist = new ArrayList<>();
		ZombieSoHwan zombiesohwan = new ZombieSoHwan();
		zombiesohwan.start();

		GoldLabel goldLabel = new GoldLabel();
		goldLabel.start();

		paladog = new PalaDog();

	}

	public void setting() {

		setSize(760, 574);
		setLocationRelativeTo(null); // ÇÁ·¹ÀÓÀ» Áß¾Ó¹èÄ¡
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(panel);
		panel.setBounds(0, 0, 743, 375);
		panel.setLayout(null);
		lblNewLabel_2.setIcon(img);
		lblNewLabel_2.setBounds(0, 372, 743, 165);

		lblNewLabel.setBounds(538, 480, 57, 30);
		getContentPane().add(lblNewLabel);
		lblNewLabel.setForeground(Color.cyan);
		lblNewLabel.setFont(new Font("", Font.PLAIN, 18));
	}

	public void batch() {

		getContentPane().add(panel);
		panel.add(paladog);
		getContentPane().add(lblNewLabel_2);

	}

	public void listener() {

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == '1') {
					new Thread(new Runnable() {

						@Override
						public void run() {
							if (hp > 10) {

								mouse = new Mouse();
								mouselist.add(mouse);
								panel.add(mouse);
								hp -= 10;
								°Å¸®°è»ê();
							}

						}
					}).start();

				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					paladog.moveLeft();
					¿ÞÂÊÈ­¸éÈå¸£±â();
					System.out.println("ÆÈ¶óµ¶ xÁÂÇ¥ : " + paladog.x);

				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					paladog.moveRight();

					¿À¸¥ÂÊÈ­¸éÈå¸£±â();

					System.out.println("ÆÈ¶óµ¶ xÁÂÇ¥ : " + paladog.x);
				}
				if (e.getKeyChar() == 'j') {
					
					punch = new PalaDogPunch();
					punchlist.add(punch);
					panel.add(punch);
					punch.moveRight();
					punch.Punchx = paladog.x;
					punch.Punchy = paladog.y + 50;
					new Thread(new Runnable() {

						@Override
						public void run() {
						
							ÆÝÄ¡°ø°Ý();

						}
					}).start();

				} else if (e.getKeyChar() == 'J') {
					punch = new PalaDogPunch();
					panel.add(punch);
					punch.moveRight();
					punch.Punchx = paladog.x;
					punch.Punchy = paladog.y + 50;
					new Thread(new Runnable() {
						@Override
						public void run() {
			
							ÆÝÄ¡°ø°Ý();

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
				while (hp < 40) {
					try {
						hp++;
//						System.out.println(hp);
						lblNewLabel.setText(hp + "/" + "40");
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
	}

	public void ÆÝÄ¡°ø°Ý() {
		while (true) {
			for (int i = 0; i < punchlist.size(); i++) {
				for (int j = 0; j < zombielist.size(); j++) {
					if (zombielist.get(j).x < punchlist.get(i).Punchx + 100) {

						panel.remove(punchlist.get(i));
						panel.remove(zombielist.get(j));
						panel.repaint();
						punchlist.remove(i);
						zombielist.remove(i);

						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			}
		}

	}

	public void °Å¸®°è»ê() {
		while (true) {
			for (int i = 0; i < mouselist.size(); i++) {
				for (int j = 0; j < zombielist.size(); j++) {
					if (zombielist.get(j).x < mouselist.get(i).x + 100) {
						mouselist.get(i).isMoving = false;
						zombielist.get(j).isMoving2 = false;
						
					}else {
						mouselist.get(i).isMoving = true;
						zombielist.get(j).isMoving2 = true;
					}
					System.out.println("Áã" + i + "¹ø" + mouselist.get(i).x);
					System.out.println("Á»ºñ" + j + "¹ø" + zombielist.get(j).x);

					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}
	}

	class ZombieSoHwan extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 20; i++) {
				zombie = new Zombie();
				zombielist.add(zombie);
				panel.add(zombie);

				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	public void ¿ÞÂÊÈ­¸éÈå¸£±â() {
		back1X += 5;
		back2X += 5;

		if (back1X < -(backimg.getWidth(null))) {
			back1X = backimg.getWidth(null);
		}
		if (back2X < -(backimg.getWidth(null))) {
			back2X = backimg.getWidth(null);
		}

		repaint();
	}

	public void ¿À¸¥ÂÊÈ­¸éÈå¸£±â() {
		back1X -= 5;
		back2X -= 5;

		if (back1X < -(backimg.getWidth(null))) {
			back1X = backimg.getWidth(null);
		}
		if (back2X < -(backimg.getWidth(null))) {
			back2X = backimg.getWidth(null);
		}

		repaint();
	}

	class MyPanel extends JPanel {
		public boolean isBackMoving = false;

		public MyPanel() {

			new Thread(new Runnable() {

				@Override
				public void run() {

					while (isBackMoving) {

						try {
							Thread.sleep(2);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

			}).start();

		}

		@Override
		public void paintComponent(Graphics g) {

			super.paintComponent(g);

			g.drawImage(backimg, back1X, 0, this);
			g.drawImage(backimg, back2X, 0, this);
		}
	}

}

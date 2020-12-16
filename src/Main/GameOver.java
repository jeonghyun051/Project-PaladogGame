package Main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOver extends JFrame {

   private GameOver gameover = this;
   GameOverPanel gameoverpanel = new GameOverPanel();

   public GameOver() {

      setTitle("팔라독사망화면");
      setSize(1130, 574);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(null);
      setLocationRelativeTo(null); // 프레임을 중앙배치
      setContentPane(gameoverpanel);
      

      setVisible(true);
   }


   class GameOverPanel extends JPanel {
      private ImageIcon icon = new ImageIcon("images/gameover.jpg");
      private Image img = icon.getImage();

      public void paintComponent(Graphics g) {
         super.paintComponent(g);

         // 이미지를 패널 크기로 조절하여 그린다
         g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

      }

   }

}
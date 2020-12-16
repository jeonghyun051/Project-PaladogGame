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

public class EndImg extends JFrame {

   private EndImg endimg = this;
   EndPanel endpanel = new EndPanel();

   public EndImg() {

      setTitle("팔라독엔딩화면");
      setSize(1130, 574);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(null);
      setLocationRelativeTo(null); // 프레임을 중앙배치
      setContentPane(endpanel);
      

      setVisible(true);
   }

   class EndPanel extends JPanel {
      private ImageIcon icon = new ImageIcon("images/gameclear.jpg");
      private Image img = icon.getImage();

      public void paintComponent(Graphics g) {
         super.paintComponent(g);

         // 이미지를 패널 크기로 조절하여 그린다
         g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

      }

   }

}
package PalaDog;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Main.GamePanel;


public class PalaDog extends JLabel{
	
	public PalaDog Paladog = this;
	public int x=0;
	public int y = 160;
	public boolean isRight = false;
	public boolean isLeft = false;
	public boolean isPunch = true;   
	public GamePanel gamepanel;
	public ImageIcon icPaladogR,icPaladogL, icPaladogRM, icPaladogLM;

	
	public PalaDog() {
		setSize(500,200);
		//이미지 설정
		icPaladogRM = new ImageIcon("images/PaladogRightMove.gif");
		icPaladogLM = new ImageIcon("images/PaladogLeftMove.gif");
		icPaladogR = new ImageIcon("images/paladogright.png");
		icPaladogL = new ImageIcon("images/PaladogLeft.png");
		setIcon(icPaladogR);
		setLocation(x, y);
		System.out.println("팔라독 나온다");

	}
	public void Right() {
		setIcon(icPaladogR);
	}
	public void Letf() {
		setIcon(icPaladogR);
	}
	
	
	public void moveRight() {
	     if(isRight==false) {
	         new Thread(new Runnable() {
	            
	            @Override
	            public void run() {
	               setIcon(icPaladogRM);
	               isRight = true;
	               while (isRight) {
	                  x++;
	                  setLocation(x, y); //내부에 repaint() 존재
	                  try {
	                	  if(x>70) {
	                
	                		 break;
	                		 
	                	  }
	                     Thread.sleep(10);
	                  } catch (InterruptedException e) {
	                     // TODO Auto-generated catch block
	                     e.printStackTrace();
	                  }
	               }            
	            }
	         }).start();
	      }
	}
	
	
	public void moveLeft() {
	      if(isLeft==false) {
	          new Thread(new Runnable() {
	             
	             @Override
	             public void run() {
	                setIcon(icPaladogLM);
	                isLeft = true;
	                while (isLeft) {
	                   x--;
	                   setLocation(x, y); //내부에 repaint() 존재
	                   try {
	                	   if(x<60) {
	                		break;
	                	   }
	                      Thread.sleep(10);
	                      
	                   } catch (InterruptedException e) {
	                      // TODO Auto-generated catch block
	                      e.printStackTrace();
	                   }
	                }            
	             }
	          }).start();
	       }
	}
}

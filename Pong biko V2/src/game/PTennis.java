package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import org.w3c.dom.html.HTMLIsIndexElement;

public class PTennis extends JPanel implements KeyListener ,ActionListener{
	
	private int delay = 8;
	Timer timer;
	int handy;
	int ballx, bally;
	int ballxdr, ballydr;
	boolean gamestart, pause, won;
	int score , count, level;
	
	public PTennis() {
		// TODO Auto-generated constructor stub
		//addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
		handy = 280;
		ballx =20;
		bally=310;
		ballxdr = 4;
		ballydr = -1;
		count = 0;
		level = 1;
		score = 0;
		gamestart = false;
		pause= false;
		won = false;
		timer = new Timer(delay,this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		// background
		g.setColor(new Color(13,30,23));
		g.fillRect(0, 0, 698, 590);
		
		//border
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, 700, 6);
		g.fillRect(688, 0, 6, 600);
		g.fillRect(0, 566, 700, 6);
		
		//paddle 1
		g.setColor(Color.CYAN);
		g.fillRect(10, handy, 10, 80);
		
		//ball
		g.setColor(Color.ORANGE);
		g.fillOval(ballx, bally, 20, 20);
		
		//score
		if(ballx > 0){
		g.setColor(Color.white);
		g.setFont(new Font("serif", Font.BOLD, 20));
		g.drawString("Score: "+ score, 580, 30);
		}
		
		//gameover
		if(ballx +20 < 0){
			g.setColor(Color.white);
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Game Over, Score: " + score, 240, 280);
			gamestart = false;
			pause = false;
			
			g.setColor(new Color(250,90,70));
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Developed By: Abubaker Azhari", 200, 480);
		}
		
		// start
		if(!gamestart && !pause && ballx >0){
			g.setColor(Color.white);
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("To Start Press Enter... ", 240, 270);
			
			g.setColor(new Color(250,90,70));
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Developed By: Abubaker Azhari", 200, 480);
		}	
		
		//pause
		if(pause && gamestart && ballx >0){
			g.setColor(Color.white);
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Paused", 320, 270);
		}
		
		// draw level
		if(count == 7 || count == 16 || count ==27){
			g.setColor(Color.white);
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Level: "+level, 300, 240);
		}
	}
	
	public void speed(){
		if(count > 6 && count < 8){
			ballxdr +=1;
			level +=1;
			System.out.println("level 1" + "speed "+ballxdr);
		}
		if(count > 15 && count < 17){
			ballxdr +=1;
			level +=1;
			System.out.println("level 2" + "speed "+ballxdr);
		}
		if(count > 26 && count < 28){
			ballxdr +=1;
			ballydr -=1;
			level +=1;
			System.out.println("level 3" + "speed "+ballxdr);
		}
		if(count > 36 && count < 38){
			ballxdr +=1;
			level +=1;
			System.out.println("level 4" + "speed "+ballxdr);
		}
		if(count > 46 && count < 48){
			ballxdr +=1;
			ballydr +=1;
			level +=1;
			System.out.println("level 5" + "speed "+ballxdr);
		}
		if(count > 56 && count < 58){
			ballxdr +=1;
			level +=1;
			System.out.println("level 6" + "speed "+ballxdr);
		}
		if(count > 66 && count < 68){
			ballxdr +=1;
			level +=1;
			System.out.println("level 7" + "speed "+ballxdr);
		}
		if(count > 76 && count < 78){
			ballxdr +=1;
			level +=1;
			System.out.println("level 8" + "speed "+ballxdr);
		}
		if(count > 86 && count < 88){
			ballxdr +=1;
			ballydr +=1;
			level +=1;
			System.out.println("level 9" + "speed "+ballxdr);
		}
		if(count > 96 && count < 98){
			ballxdr +=1;
			level +=1;
			System.out.println("level 10" + "speed "+ballxdr);
		}
		if(count > 109 && count < 111){
			ballxdr +=1;
			level +=1;
		}
		if(count > 119 && count < 121){
			ballxdr +=1;
			level +=1;
		}
		if(count > 129 && count < 131){
			ballxdr +=1;
			level +=1;
		}
		if(count > 139 && count < 141){
			ballxdr +=1;
			level +=1;
		}
		if(count > 149 && count < 151){
			ballxdr +=1;
			level +=1;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		timer.start();
		
		if(gamestart && !pause){
			
			// clash between ball and hand
			if(new Rectangle(ballx, bally, 20, 20).intersects(new Rectangle(10, handy, 10, 80))){
				ballxdr = -ballxdr;
				score +=5;
				count +=1;
				
				speed();
			}
			
			// ball
			ballx += ballxdr;
			bally += ballydr;
			
			// clash between ball and upper border
			if(new Rectangle(ballx, bally, 20, 20).intersects(new Rectangle(0, 0, 700, 4))){
				ballydr = -ballydr;
			}
			
			// clash between ball and right border
			if(new Rectangle(ballx, bally, 20, 20).intersects(new Rectangle(690, 0, 4, 600))){
				ballxdr = -ballxdr;
			}
			
			// clash between ball and lower border
			if(new Rectangle(ballx, bally, 20, 20).intersects(new Rectangle(0, 567, 700, 4))){
				ballydr = -ballydr;
			}
			
			// prevent hand from going outside the screen
			if(handy < 0){
				handy=0;
			}
			if(handy > 500){
				handy=500;
			}
		}
		
		
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_UP ){
			if(!pause && gamestart){
				handy -=30;
			}
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			if(!pause && gamestart){
				handy +=30;
			}
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			if(!gamestart){
				gamestart = true;
				handy = 280;
				ballx =20;
				bally=310;
				ballxdr = 4;
				ballydr = -1;
				score = 0;
				pause = false;
				
				repaint();
			}else{
				pause = !pause;
			}
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}

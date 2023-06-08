package Soccerkey;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Soccerkey {
	JField field;
	Ball ball;
	Player p,q,r,h,i;
	boolean timeout, goal;
	int clock;
	
	public static void main(String a[]) {
		new Soccerkey();
	}
	Soccerkey(){
		field = new JField(640/2,480/2,this);
		ball = new Ball(field);
		p=new Player("손흥민","P",field,-50,20);
		q=new Player("기성용","Q",field,50,20);
		h=new Player("이청용","P",field,50,-20);
		i=new Player("박주호","Q",field,-50,-20);
		JPanel pan=new JPanel(null);
		pan.setBackground(Color.WHITE);
		pan.add(field);
		field.setLocation(20,10);
		
		JFrame f=new JFrame("핵심J:Soccer Graphical");
		f.getContentPane().add(pan);
		f.setSize(320+56,240+60);
		f.setVisible(true);
		f.setResizable(false);
		start();
	}
	
	void start() {
		System.out.println(" * START * ");
		timeout = false;
		run();
	}
	void stop() {
		timeout=true;
	}
	void run() {
		 while(!timeout) {
	         clock++; 
	         System.out.println("["+clock+"]");
	         int dist=p.move(ball);
	         int distq=q.move(ball);
	         int disth=h.move(ball);
	         int disti=i.move(ball);
	         
	         r=p;
	         if(distq<dist) {
	            r=q; 
	            dist=distq;
	         }
	         else if(disth<dist) {
	        	 r=h;
	        	 dist=disth;
	         }
	         else if(disti<dist) {
	        	 r=i;
	        	 dist=disti;
	         }
	         if(dist<5) {
	            r.kick(ball);  // 공과 선수의 거리가 5이하면 공을 참.
	            System.out.print("->"+ r.name+" kick->");
	         }
	         goal=ball.move();
	         field.repaint();
	         if(goal) {
	            System.out.println(" *골인* ");
	            r.count++;
	            goal=false;
	            ball.reset();
	         }
	         try {Thread.sleep(100);;}catch(Exception e) {}
	         if(clock>90) stop();
		 }
		 System.out.println(" * TIME OUT * ");
		 System.out.println(q.name+":"+q.count+"골   "+p.name+":"+p.count+"골   "+h.name+":"+h.count+"골   "+i.name+":"+i.count+"골   ");
		 if((q.count+i.count)==(p.count+h.count)) {
			 System.out.println("무승부!!");
		 }
		 else if((q.count+i.count)>(p.count+h.count)) {
			 System.out.println("Q팀 승!!");
		 }
		 else {
			 System.out.println("P팀 승!!");
		 }
	}
	void show() {			/* member variables: {field, b, p, q} */
		int dH = 10, dW = 3;	/* 운동장 cell dimension: dHxdW */
		int bx = ball.getX() / dW;
		int by = ball.getY() / dH;
		int px = p.getX() / dW;
		int py = p.getY() / dH;
		int qy = q.getY() / dH;
		int qx = q.getX() / dW;
		int hx = h.getX() / dW;
		int hy = h.getY() / dH;

		hline(field.getRight()/dW - field.getLeft()/dW + 1);
		for(int r = field.getTop()/dH; r <= field.getBottom()/dH; r ++) {
		    tpr("|");
		    for(int i = field.getLeft()/dW; i<= field.getRight()/dW; i ++) {
			if (r == by && i == bx) {
				tpr("*");
				if (r == py && i == px) {
					tpr("p"); i++;
					if (r == qy && i == qx) { tpr("q"); i++; }
				} else if (r == qy && i == qx) { tpr("q"); i++; }
			} else if (r == py && i == px) {
				tpr("p");
				if (r == qy && i == qx) { tpr("q"); i++; }
			} else if (r == qy && i == qx) { tpr("q");
			} else { /* if (r == 0 && i == 0) tpr("+"); else  */
				tpr(" ");
			}
		    }
		    tprl("|"+r);
		}
		hline(field.getRight()/dW - field.getLeft()/dW + 1);
	}
	void hline(int n) {
		tpr("+");
		for(int i = 1; i<=n; i++)  tpr("-");
		tprl("+");
	}
	void tpr(String s) { System.out.print(s); }
	void tprl(String s) { System.out.println(s); }
}
class JField extends JPanel {
   private int x0, x1, y0,y1,w,h;
   Soccerkey match;
   JField(int width, int height, Soccerkey match){
      w=width; 
      h=height;
      this.match=match;
      setSize(w,h);
      setBackground(Color.green);
      x1=w/2; 
      y1=h/2;
      x0=-x1; 
      y0=-y1;
      setFocusable(true);
      addKeyListener(new MyKeyListener(match));
   }
   
   class MyKeyListener extends KeyAdapter{
	   Soccerkey match;
	   int speed = 4;
	   MyKeyListener(Soccerkey m){match=m;}
	   public void keyPresssed(KeyEvent e) {
		   switch(e.getKeyCode()) {
		   case KeyEvent.VK_RIGHT:
			   match.h.runtoward(5*speed,0);
			   break;
		   case KeyEvent.VK_LEFT:
			   match.h.runtoward(-5*speed,0);
			   break;
		   case KeyEvent.VK_UP:
			   match.h.runtoward(0,-5*speed);
			   break;
		   case KeyEvent.VK_DOWN:
			   match.h.runtoward(0,5*speed);
			   break;
		   }
	   }
   }
   int getLeft() {
      return x0;
   }
   int getRight() {
      return x1;
   }
   int getTop() {
      return y0;
   }
   int getBottom() {
      return y1;
   }
   int getCx() {
	   return x1;
   }
   int getCy() {
	   return y1;
   }
   public void paint(Graphics g) {
	   super.paint(g);
	   g.setFont(new Font("궁서",Font.BOLD,15));
	   g.setColor(Color.white);
	   g.drawRect(0, 0, w, h);
	   g.drawLine(getCx(), getCy()+y0, getCx(), getCy()+y1);
	   g.drawOval(getCx()-40, getCy()-40, 80, 80);
	   
	   match.ball.draw(g);
	   g.setColor(Color.red);match.p.draw(g);
	   g.setColor(Color.blue);match.q.draw(g);
	   g.setColor(Color.MAGENTA);match.h.draw(g);
	   g.setColor(Color.gray);match.i.draw(g);
	   drawClock(g);
	   drawScore(g);
   }
   void drawClock(Graphics g) {
	   int r=10,x=w-r-10,y=r+10;
	   double a=Math.PI/180*(-90+match.clock*(360/90));
	   g.setColor(Color.BLACK);
	   g.drawOval(x-r, y-r, 2*r, 2*r);
	   g.drawLine(x, y, (int)(x+r*Math.cos(a)), (int)(y+r*Math.sin(a)));
   }
   void drawScore(Graphics g) {
	   int x=5,y=5,x1=100,y1=20;
	   g.drawRect(x, y, x1, y1);
	   g.drawLine(55, 5, 55, 25);
	   g.drawLine(20, 5, 20, 25);
	   g.drawLine(71, 5, 71, 25);
	   g.setColor(Color.black);
	   g.drawString("P", 8, 21);
	   g.drawString(String.valueOf(match.p.count+match.h.count), 32, 21);
	   g.drawString(String.valueOf(match.q.count+match.i.count), 83, 21);
	   g.drawString("P", 5, 120);
	   g.drawString("Q", 305, 120);
   }
}

class Ball{
   JField f;
   private int x,y,diameter;
   private double vx, vy;
   Ball(JField f){
      x=0; 
      vx=0; 
      y=0; 
      vy=0; 
      this.f=f;
   }
   boolean move() {
      x=x+(int)vx; 
      y=y+(int)vy;
      System.out.println("공("+x+","+y+")");
      vx=vx*0.8; 
      vy=vy*0.8; // 마찰로 감속*비율
      checkBounds();
      return (x > f.getRight()-1 || x < f.getLeft()+1);  // 골인인지, 공의 크기가 있기 때문에 -1,+1;
   }
   void checkBounds() { // 공이 경기장 밖으로 넘어갔을 때 공을 다시 경기장 안으로
	   if(y<f.getTop()) {
		   vy=-vy;
		   y=2*f.getTop()-y;
	   }
	   if(y>f.getBottom()) {
		   vy=-vy;
		   y=2*f.getBottom()-y;
	   }
	   if(x<f.getLeft()) {
		   vx=-vx;
		   x=2*f.getLeft()-x;
	   }
	   if(x>f.getRight()) {
		   vx=-vx;
		   x=2*f.getRight()-x;
	   }
   }
   void draw(Graphics g) { // 반지름이 5인 공
	   int radius=5;
	   g.setColor(Color.BLACK);
	   g.fillOval(f.getCx()+x-radius, f.getCy()+y-radius, radius*2, radius*2);
   }
   void fly(double kx, double ky) {
      this.vx += kx; 
      this.vy += ky; 
   }
   int getX() { 
      return x; 
   }
   int getY() { 
      return y; 
   }
   void reset() {
	   vx=0;
	   x=3*f.getLeft()-x;
	   x=randM(5)-4;
	   y=0;
	   vx=0;
	   vy=0;
   }
   int randM(int M) {
	   return (int)Math.random()*M;
   }
}
class Player {
   JField f;
   int x, y;
   double dx, dy, speed;
   String name,team;
   int count=0;

   Player(String 이름, String tm, JField f, int x0, int y0){ 
      name = 이름;
      x = x0;
      y = y0;
      team=tm;
      this.f = f;
   }

   int move(Ball b) {
      dash(b);      
      x = x + (int)dx; 
      y = y + (int)dy;
      int dist = (int) distance(b);
      System.out.print (name +" "+ dist+" ");
      return dist;
   }

   double distance(Ball b) { 
      double x2x = x - b.getX();
      double y2y = y- b.getY();
      return Math.sqrt(x2x*x2x + y2y*y2y);
   }

   void kick(Ball b){ 
      double kx = dx*2 + randM(10) - 5;
      double ky = dy*2 + randM(8) - 5;
      b.fly(kx, ky);
      speed = speed / 2;
   }
   
   double randM(int M){
      return Math.random() * M;
   }
   
   void dash (Ball b) { 
   double dist = distance(b) + 1;   // 나눌때 0으로 나눌 수 없으므로 기본값을 1로 설정
      speed = speed*0.8 + randM(4); // 속도 조절 
      dx = (b.getX() - x)/dist * speed; 
      dy = (b.getY() - y)/dist * speed; 

   }
   
   int getX() { 
      return x; 
   }
   int getY() { 
      return y; 
   }
   void draw(Graphics g) {
	   g.drawRect(f.getCx()+x-5, f.getCy()+y-20, 10, 20);
   }
   void runtoward(int dx, int dy) {
	   x+=dx;
	   y+=dy;
   }
 }

package soccer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class JField extends JPanel{
	
	private int x0,x1,y0,y1,w,h;
	String p_num="0", q_num="0";
	Soccer match;
	
	JField(int wide, int high, Soccer match) {
		w = wide; h = high; this.match = match;
		setSize(w,h);
		setBackground(Color.green);
		x1=w/2; x0=-x1; y1=h/2; y0=-y1; 
		
		addKeyListener(new MyKeyListener(match));
		setFocusable(true);
	}
	
	int getLeft() { return x0; } int getRight() { return x1; }
	int getTop() { return y0; } int getBottom() { return y1; }
	int getCx() {return x1;} int getCy() { return y1; }

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.white); // 테두리 흰색
		g.drawRect(0,0,w,h); // 사각 테
		g.drawLine(getCx(), getCy()+y0, getCx(), getCy()+y1);
		g.drawOval(getCx()-40, getCy()-40, 80, 80);
		//골대
		g.setColor(Color.yellow);
		g.drawRect(0,getBottom()/2,20,h/2); g.drawRect(getRight()*2-20,getBottom()/2,20,h/2);
		
		match.ball.draw(g);
		g.setColor(Color.red); 
		//키 이벤트를 적용할 선수
		match.p[0].keyEventdraw(g);
		for(int i=1;i<3;i++) match.p[i].draw(g); 
		g.setColor(Color.blue); 
		for(int i=0;i<3;i++) match.q[i].draw(g);
		drawClock(g);
		Scoreboard(g);
	}
	//시계를 그린다.
	void drawClock(Graphics g) {
		int r=10, x=w-r-10, y=r+10;
		double a = Math.PI/180*(-90+match.clock*(360/90)); //0~90
		g.drawOval(x-r, y-r, 2*r, 2*r);
		g.drawLine(x, y, (int)(x+r*Math.cos(a)), (int)(y+r*Math.sin(a)));
	}
	//점수판을 그린다.
	void Scoreboard(Graphics g) {
		
		g.setColor(Color.BLACK);
		g.drawRect(w/2-30, 0, 60, 29);
		
		g.setFont(new Font("Arial", Font.ITALIC, 15));
		g.drawString(p_num, w/2-15,18);
		g.drawString(q_num, w/2+5, 18);
	}
}

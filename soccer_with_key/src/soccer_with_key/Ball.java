package soccer;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	JField f;
	int x, y;
	double vx, vy;
	
	Ball (JField f) { x=0; vx=0; y=0; this.f=f; }
	
	void draw(Graphics g) {
		int radius = 5;
		g.setColor(Color.black);
		g.fillOval(f.getCx()+x-radius, f.getCy()+y-radius, radius*2, radius*2);
	}
	
	int move() {
		x = x + (int)vx;	y = y + (int)vy;
		System.out.println("공("+x+","+y+").");
		vx = vx * 0.8; vy = vy * 0.8; //마찰로 감속*비율
		
		//골이 오른쪽 골대에 들어갔을 때
		if ( (Math.abs(y) < f.getBottom()/2) && (x > f.getRight()-1) )
			return 1;
		//골이 왼쪽 골대에 들어갔을 때
		else if ( (Math.abs(y) < f.getBottom()/2) && (x < f.getLeft()+1) )
			return 2;
		//ball이 필드를 벗어났을 때 (골대에 들어가지 못하고 x축 범위를 벗어났을 때)
		else if ( Math.abs(y) >= f.getBottom()/2 && (x>f.getRight()-1||x<f.getLeft()+1) )
			return -1;
		//ball이 필드를 벗어났을 때 (ball이 y축 범위를 벗어났을 때)
		else if( Math.abs(y) >= f.getBottom() )
			return -1;
		
		//공이 필드 안에 있을 때
		return 0;
		//ball이 필드를 벗어났을 때
	}
	
	void fly(double kx, double ky) { vx = vx+kx; vy += ky; }
	void ball_return() {
		x=0; vx=0; y=0; vy=0;
	}
	int getX() { return x; }
	int getY() { return y; }
}

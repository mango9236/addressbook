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
		System.out.println("��("+x+","+y+").");
		vx = vx * 0.8; vy = vy * 0.8; //������ ����*����
		
		//���� ������ ��뿡 ���� ��
		if ( (Math.abs(y) < f.getBottom()/2) && (x > f.getRight()-1) )
			return 1;
		//���� ���� ��뿡 ���� ��
		else if ( (Math.abs(y) < f.getBottom()/2) && (x < f.getLeft()+1) )
			return 2;
		//ball�� �ʵ带 ����� �� (��뿡 ���� ���ϰ� x�� ������ ����� ��)
		else if ( Math.abs(y) >= f.getBottom()/2 && (x>f.getRight()-1||x<f.getLeft()+1) )
			return -1;
		//ball�� �ʵ带 ����� �� (ball�� y�� ������ ����� ��)
		else if( Math.abs(y) >= f.getBottom() )
			return -1;
		
		//���� �ʵ� �ȿ� ���� ��
		return 0;
		//ball�� �ʵ带 ����� ��
	}
	
	void fly(double kx, double ky) { vx = vx+kx; vy += ky; }
	void ball_return() {
		x=0; vx=0; y=0; vy=0;
	}
	int getX() { return x; }
	int getY() { return y; }
}

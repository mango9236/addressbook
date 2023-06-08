package soccer_with_key;

import java.awt.Graphics;

public class Player {
	JField f;
	int x, y, goal, owngoal;
	double dx, dy, speed;
	String name, team;
	
	Player(String �̸�, String tm, JField f, int x0, int y0, int g, int og){
		name = �̸�; x=x0; y=y0;
		team = tm; this.f = f;
		goal = g; owngoal=og;
	}
	
	void draw(Graphics g) {
		g.drawRect(f.getCx()+x-5, f.getCy()+y-20, 10, 20);
	}
	void keyEventdraw(Graphics g) {
		g.fillRect(f.getCx()+x-5, f.getCy()+y-20, 10, 20);
	}
	int move(Ball b) {
		//������ �ٴٺ��� �ӵ��� �ٲ�� ������ dash
		//���� ������ ��������� dash�� ����� �ӵ��� ����
		dash(b);
		x = x + (int)dx; y = y + (int)dy;
		int dist = (int)distance(b);
		System.out.print(name + " " + dist + " ");
		return dist;
	}
	int keyEventmove(Ball b) {
		x = x + (int)dx; y = y + (int)dy;
		int dist = (int)distance(b);
		System.out.print(name + " " + dist + " ");
		return dist;
	}
	//�������� �ִ������Ÿ�
	double distance(Ball b) { 
		double x2x = x - b.getX();
		double y2y = y - b.getY();
		return Math.sqrt(x2x*x2x + y2y*y2y);
	}
	//��ü�� ���� �ٴ� �������� �帮��
	void kick(Ball b) { 
		double kx = dx*2 + randM(10) - 5;
		double ky = dy*2 + randM(8) - 5;
		b.fly(kx, ky);
		//���� ���� ���� speed�� �پ���.
		speed = speed/2;
	}
	double randM(int M) {
		return Math.random()*M;
	}
	//���� ����, ���� ���� ���� �����ϴ� �ӵ��� ����
	void dash(Ball b) {
		double dist = distance(b) + 1;
		speed = speed * 0.8 + randM(4); //���� �ӵ� ����
		dx = (b.getX()-x)/dist*speed;
		dy = (b.getY()-y)/dist*speed;
	}
	void runtoward(int dx, int dy) { x += dx; y += dy; }
	int getX() { return x; }
	int getY() { return y; }
}

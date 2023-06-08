package soccer;

import java.awt.Graphics;

public class Player {
	JField f;
	int x, y, goal, owngoal;
	double dx, dy, speed;
	String name, team;
	
	Player(String 이름, String tm, JField f, int x0, int y0, int g, int og){
		name = 이름; x=x0; y=y0;
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
		//선수가 뛰다보면 속도가 바뀌기 때문에 dash
		//공과 선수가 가까워지면 dash를 사용해 속도를 높임
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
	//공까지의 최단직선거리
	double distance(Ball b) { 
		double x2x = x - b.getX();
		double y2y = y - b.getY();
		return Math.sqrt(x2x*x2x + y2y*y2y);
	}
	//대체로 내가 뛰는 방향으로 드리블
	void kick(Ball b) { 
		double kx = dx*2 + randM(10) - 5;
		double ky = dy*2 + randM(8) - 5;
		b.fly(kx, ky);
		//공을 차고 나면 speed가 줄어든다.
		speed = speed/2;
	}
	double randM(int M) {
		return Math.random()*M;
	}
	//공을 향해, 공을 뺏기 위해 질주하는 속도를 결정
	void dash(Ball b) {
		double dist = distance(b) + 1;
		speed = speed * 0.8 + randM(4); //질주 속도 결정
		dx = (b.getX()-x)/dist*speed;
		dy = (b.getY()-y)/dist*speed;
	}
	void runtoward(int dx, int dy) { x += dx; y += dy; }
	int getX() { return x; }
	int getY() { return y; }
}

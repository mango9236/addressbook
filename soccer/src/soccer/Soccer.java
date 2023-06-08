package soccer;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Soccer {

	Ball ball;
	Player p[], q[], r;
	boolean timeout;
	int goal, owngoal;
	JField field;
	int clock=0, p_num=0, q_num=0;
	String people=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Soccer();
	}
	
	Soccer(){
		
		field = new JField(640/2, 480/2, this); //경기장 크기 
		ball = new Ball(field); //공을 경기장에 배치한다.

		// 각 팀의 선수를 배정한다.
		player();

		JPanel pan = new JPanel(null);
		pan.setBackground(Color.WHITE); //관중석
		pan.add(field); 
		field.setLocation(20,10); //경기장
		
		JFrame f = new JFrame("핵심J: Soccer Graphical");
		f.getContentPane().add(pan);
		f.setSize(320+56, 240+60);
		f.setVisible(true); //완성된 축구경기장이 보이게 한다.
		f.setResizable(false);
		
		//경기 시작
		start();
	}
	void player() {
		
		p=new Player[3]; q=new Player[3];
		p[0] = new Player("손", "P",field,-50,0,0,0);
		p[1] = new Player("김", "P", field, -50,-20,0,0);
		p[2] = new Player("박", "P", field, -50, 20, 0,0);
		
		q[0]= new Player("기", "Q", field, 50,0,0,0);
		q[1] = new Player("이", "Q", field, 50, -20, 0,0);
		q[2] = new Player("최", "Q", field, 50, 20, 0,0);
		
	}
	void start() {
		System.out.println("* START *");
		timeout = false;
		run();
	}
	void stop() {
		timeout = true;
	}
	void run() {
	
		while (!timeout) {
			
			field.repaint();
			clock++; System.out.print("["+clock+"]");
			
			int dist[] = new int[6];
			
			dist[0]=p[0].keyEventmove(ball);
			for(int i=1;i<3;i++) {dist[i] = p[i].move(ball);} //dist: p와 공 사이의 거리		
			for(int i=3;i<6;i++) {dist[i] = q[i-3].move(ball);}
			
			//d: 공과 가장 가까운 거리 , r: 공과 가장 가까운 거리에 있는 선수
			int d=p[0].move(ball); r = p[0];
			
			for (int i=0;i<dist.length-1;i++) {
				if(dist[i] > dist[i+1]) {
					d=dist[i+1]; 
				}
			}
			//공과 가장 가까운 거리에 있는 선수를 r로 지정
			int n=0;
			for(int i=0;i<dist.length;i++) {
				if(d==dist[i]) {
					switch(n) {
						case 0:	r=p[0]; break;
						case 1: r=p[1]; break;
						case 2: r=p[2]; break;
						case 3: r=q[0]; break;
						case 4: r=q[1]; break;
						case 5: r=q[2]; break;
					}
				}else { n++; }
			}
			// 가장 가까이에 있는 거리 d가 5보다 작으면 공을 찬다.
			if (d < 5) { 
				r.kick(ball); people=r.name;
				System.out.println("->"+r.name+"kicks ->");;
			}
			goal = ball.move();
			
			//p팀의 골대에 공이 들어갔을 때
			if(goal==1) {
				p_num++; System.out.println("*골인*");
				field.p_num=String.valueOf(p_num);
				//공의 위치를 중앙으로 옮긴다.  
				ball.ball_return(); 
				for(int i=0;i<p.length;i++) {
					if(people==p[i].name) {	p[i].goal++; }
				}
				//q팀의 자책골(owngoal)
				for(int i=0;i<q.length;i++) {
					if(people==q[i].name) { q[i].owngoal++;}
				}
				initPlayer();
			}
			//q팀의 골대에 공이 들어갔을 때
			else if (goal == 2) {
				q_num++; System.out.println("*골인*");
				field.q_num=String.valueOf(q_num);
				//공의 위치를 중앙으로 옮긴다.  
				ball.ball_return(); 
				for(int i=0;i<q.length;i++) {
					if(people==q[i].name) { q[i].goal++; }
				}
				//p팀의 자책골
				for(int i=0;i<p.length;i++) {
					if(people==p[i].name) { p[i].owngoal++; }
				}
				//선수의 위치를 초기화시킨다.
				initPlayer();
			}
			
			else if (goal == -1) {
				System.out.println("*공이 필드를 벗어났습니다*");
				ball.ball_return();
				//선수의 위치를 초기화시킨다.
				initPlayer();
			}
		
			try {Thread.sleep(100);} catch(Exception e) {}
			if(clock > 90) stop(); //경기 종료
		}
		System.out.println("* TIME OUT *");
		System.out.println("경기가 종료되었습니다");
		
		for(int i=0;i<3;i++) {
			//p팀의 선수가 골을 넣었을 때
			if(p[i].goal != 0)	{
				//그 골이 자책골이 아니라면
				if(p[i].owngoal == 0) { 
					System.out.println("P팀의 "+p[i].name+"선수: "+p[i].goal+"골 입니다."); }
				//그 골이 자책골이라면
				else { 
					System.out.println("P팀의 "+p[i].name+"선수: "+p[i].owngoal+"골 입니다.(자책골)");}
				}}
		
		for(int i=0;i<3;i++) {
			//q팀의 선수가 골을 넣었을 때
			if(q[i].goal != 0)	{
				//그 골이 자책골이 아니라면
				if(q[i].owngoal == 0) { 
					System.out.println("Q팀의 "+q[i].name+"선수: "+q[i].goal+"골 입니다."); }
				//그 골이 자책골이라면
				else { 
					System.out.println("Q팀의 "+q[i].name+"선수: "+q[i].owngoal+"골 입니다.(자책골)");}
				}}
		
		if(p_num>q_num)	{System.out.println(p_num+":"+q_num+"으로 P팀의 승리입니다.");}
		else if(p_num<q_num){System.out.println(p_num+":"+q_num+"으로 Q팀의 승리입니다.");}
		else {System.out.println(p_num+":"+q_num+"으로 무승부입니다.");}
	}

	public void initPlayer() {
		// TODO Auto-generated method stub
		p[0].x=-50; p[0].y=0;
		p[1].x=-50; p[0].y=-20;
		p[2].x=-50; p[0].y=20;
		
		q[0].x=50; q[0].y=0;
		q[1].x=50; q[1].y=-20;
		q[2].x=50; q[2].y=20;
	}
}	
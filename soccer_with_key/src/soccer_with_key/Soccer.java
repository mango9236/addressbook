package soccer_with_key;

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
		
		field = new JField(640/2, 480/2, this); //����� ũ�� 
		ball = new Ball(field); //���� ����忡 ��ġ�Ѵ�.

		// �� ���� ������ �����Ѵ�.
		player();

		JPanel pan = new JPanel(null);
		pan.setBackground(Color.WHITE); //���߼�
		pan.add(field); 
		field.setLocation(20,10); //�����
		
		JFrame f = new JFrame("�ٽ�J: Soccer Graphical");
		f.getContentPane().add(pan);
		f.setSize(320+56, 240+60);
		f.setVisible(true); //�ϼ��� �౸������� ���̰� �Ѵ�.
		f.setResizable(false);
		
		//��� ����
		start();
	}
	void player() {
		
		p=new Player[3]; q=new Player[3];
		p[0] = new Player("��", "P",field,-50,0,0,0);
		p[1] = new Player("��", "P", field, -50,-20,0,0);
		p[2] = new Player("��", "P", field, -50, 20, 0,0);
		
		q[0]= new Player("��", "Q", field, 50,0,0,0);
		q[1] = new Player("��", "Q", field, 50, -20, 0,0);
		q[2] = new Player("��", "Q", field, 50, 20, 0,0);
		
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
			for(int i=1;i<3;i++) {dist[i] = p[i].move(ball);} //dist: p�� �� ������ �Ÿ�		
			for(int i=3;i<6;i++) {dist[i] = q[i-3].move(ball);}
			
			//d: ���� ���� ����� �Ÿ� , r: ���� ���� ����� �Ÿ��� �ִ� ����
			int d=p[0].move(ball); r = p[0];
			
			for (int i=0;i<dist.length-1;i++) {
				if(dist[i] > dist[i+1]) {
					d=dist[i+1]; 
				}
			}
			//���� ���� ����� �Ÿ��� �ִ� ������ r�� ����
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
			// ���� �����̿� �ִ� �Ÿ� d�� 5���� ������ ���� ����.
			if (d < 5) { 
				r.kick(ball); people=r.name;
				System.out.println("->"+r.name+"kicks ->");;
			}
			goal = ball.move();
			
			//p���� ��뿡 ���� ���� ��
			if(goal==1) {
				p_num++; System.out.println("*����*");
				field.p_num=String.valueOf(p_num);
				//���� ��ġ�� �߾����� �ű��.  
				ball.ball_return(); 
				for(int i=0;i<p.length;i++) {
					if(people==p[i].name) {	p[i].goal++; }
				}
				//q���� ��å��(owngoal)
				for(int i=0;i<q.length;i++) {
					if(people==q[i].name) { q[i].owngoal++;}
				}
				initPlayer();
			}
			//q���� ��뿡 ���� ���� ��
			else if (goal == 2) {
				q_num++; System.out.println("*����*");
				field.q_num=String.valueOf(q_num);
				//���� ��ġ�� �߾����� �ű��.  
				ball.ball_return(); 
				for(int i=0;i<q.length;i++) {
					if(people==q[i].name) { q[i].goal++; }
				}
				//p���� ��å��
				for(int i=0;i<p.length;i++) {
					if(people==p[i].name) { p[i].owngoal++; }
				}
				//������ ��ġ�� �ʱ�ȭ��Ų��.
				initPlayer();
			}
			
			else if (goal == -1) {
				System.out.println("*���� �ʵ带 ������ϴ�*");
				ball.ball_return();
				//������ ��ġ�� �ʱ�ȭ��Ų��.
				initPlayer();
			}
		
			try {Thread.sleep(100);} catch(Exception e) {}
			if(clock > 90) stop(); //��� ����
		}
		System.out.println("* TIME OUT *");
		System.out.println("��Ⱑ ����Ǿ����ϴ�");
		
		for(int i=0;i<3;i++) {
			//p���� ������ ���� �־��� ��
			if(p[i].goal != 0)	{
				//�� ���� ��å���� �ƴ϶��
				if(p[i].owngoal == 0) { 
					System.out.println("P���� "+p[i].name+"����: "+p[i].goal+"�� �Դϴ�."); }
				//�� ���� ��å���̶��
				else { 
					System.out.println("P���� "+p[i].name+"����: "+p[i].owngoal+"�� �Դϴ�.(��å��)");}
				}}
		
		for(int i=0;i<3;i++) {
			//q���� ������ ���� �־��� ��
			if(q[i].goal != 0)	{
				//�� ���� ��å���� �ƴ϶��
				if(q[i].owngoal == 0) { 
					System.out.println("Q���� "+q[i].name+"����: "+q[i].goal+"�� �Դϴ�."); }
				//�� ���� ��å���̶��
				else { 
					System.out.println("Q���� "+q[i].name+"����: "+q[i].owngoal+"�� �Դϴ�.(��å��)");}
				}}
		
		if(p_num>q_num)	{System.out.println(p_num+":"+q_num+"���� P���� �¸��Դϴ�.");}
		else if(p_num<q_num){System.out.println(p_num+":"+q_num+"���� Q���� �¸��Դϴ�.");}
		else {System.out.println(p_num+":"+q_num+"���� ���º��Դϴ�.");}
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
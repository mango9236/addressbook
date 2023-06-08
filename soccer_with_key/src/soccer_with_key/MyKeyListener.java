package soccer_with_key;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener{
	Soccer match;
	int push;
	int speed = 4;
	MyKeyListener(Soccer m){ match = m; }
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()) {
			case KeyEvent.VK_RIGHT:
				match.p[0].runtoward(5*speed,0); break;
			case KeyEvent.VK_LEFT:
				match.p[0].runtoward(-5*speed, 0); break;
			case KeyEvent.VK_UP:
				match.p[0].runtoward(0, -5*speed); break;
			case KeyEvent.VK_DOWN:
				match.p[0].runtoward(0,5*speed); break;
			case KeyEvent.VK_SPACE:
				match.stop(); break;
		}  
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}

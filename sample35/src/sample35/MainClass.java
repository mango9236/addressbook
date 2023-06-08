package sample35;

import cls.Child;

public class MainClass {

	public static void main(String[] args) {
	
	/*
	 	private
	 	public
	 	protected : 자식 클래스에서는 접근 허용, 그러나 외부에서는 허용 x
	 	
	 	protected 보다는 setter getter를 많이 사용한다. 
	 */
		
		Child ch = new Child();
		ch.func();
		
		// protected -> 자식 클래스에서는 허용 했지만 밖에서는 불가능 
		// ch.num = 30;
		// ch.swap();
		
	}

}

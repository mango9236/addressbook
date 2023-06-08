package cls;

public class Parent {
	protected int num;
	protected String name;
	
	public void method() {
		// private이면 내부만 접근 가능
		num = 12;
		name = "홍길동";
	}
	
	// swap은 protected 가끔 씀
	protected void swap() {
			
	}
	
	/* 
		1. setter getter 사용
		
		public int getNum() {
			return num;
		}
	
		public void setNum(int num) {
			this.num = num;
		}
	*/
	
	/*
	 	2. protected 사용
	 */
	
}

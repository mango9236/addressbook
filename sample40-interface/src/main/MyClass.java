package main;

public class MyClass implements MyInterface{ // 인터페이스는 implements
	
	//add unimplemented method 해주기
	@Override
	public void func() {
		System.out.println("MyClass func()");
	} 
	
}

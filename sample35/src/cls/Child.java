package cls;

public class Child extends Parent{
	
	public void func() {
		// protected 접근 허용 
		num = 133; // setNum(133)
		name = "최민규";
		
		// protected는 같은 집안(복합체)만 가능
		swap();
	}
	
}

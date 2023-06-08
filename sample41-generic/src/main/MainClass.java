package main;

public class MainClass {

	public static void main(String[] args) {
		/*
			Generic == 	Template (자료 형태)
						: 자료형(Wrapper) 변수
						: 같은 클래스에서 다양한 자료형을 사용하는 경우에 사용하는 요소 
		*/
		
		// Box라는 제네릭 클래스 정의 -> T: type안에 타입 정의
		Box<Integer> box = new Box<Integer>(1000);
		System.out.println(box.getTemp());
		box.setTemp(2000);
		
		// 아무 타입이나 사용가능
		Box<String> box1 = new Box<String>( "Hello" );
		System.out.println(box1.getTemp());
		box1.setTemp("World");
		
		// key: 1111 -> value: 홍길동 
		BoxMap<Integer, String> bm = new BoxMap<Integer, String>(1111, "홍길동");
		System.out.println(bm.toString());
		
		// key: first -> value: 2222
		BoxMap<String, Integer> mb = new BoxMap<String, Integer>("first", 2222);
		System.out.println(mb.toString());
		
		
		Parent arr[] = new Parent[2];
		arr[0] = new ChildOne();
		arr[1] = new ChildTwo();
		
		Object obj[] = new Object[10];
		obj[0] = new ChildOne();
		obj[1] = new ChildTwo();
		obj[2] = new String();
		obj[3] = new Character('A');	
		
	}
}

// <T> :generic
class Box<T>{	
	T temp;
	
	// 생성자
	public Box(T temp) { 
		this.temp = temp;
	}
	
	// get
	public T getTemp() {
		return temp;
	}
	
	// set
	public void setTemp(T temp) {
		System.out.println("temp:" + temp);		
	}	
}

// key-value쌍
class BoxMap<Key, Value>{
	Key key;
	Value value;
	
	public BoxMap(Key key, Value value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	// source -> generate toString()
	@Override 
	public String toString() {
		return "BoxMap [key=" + key + ", value=" + value + "]";
	}	
	
}

class Parent extends Object{	
}

class ChildOne extends Parent{	
}

class ChildTwo extends Parent{		
}













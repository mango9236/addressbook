package dto;

public class StudentDto {
	
	// 멤버변수
	private int no;
	private String name;
	private double height;
	
	// 생성자
	public StudentDto() {
	}

	// super(); -> object 클래스 
	public StudentDto(int no, String name, double height) {
		super();
		this.no = no;
		this.name = name;
		this.height = height;
	}
	
	/* source -> getter setter */
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	/* generate toString() */
	@Override
	public String toString() {
		return "StudentDto [no=" + no + ", name=" + name + ", height=" + height + "]";
	}
}

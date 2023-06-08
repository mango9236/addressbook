package cls;

public class Batter extends Human{
	private int batcount;
	private int hit;
	private double hitavg; //타율
	
	public Batter() {
	}
	
	public Batter(int number, String name, double height, int batcount, int hit, double hitavg) {
		super(number, name, height);
		this.batcount = batcount;
		this.hit = hit;
		this.hitavg = hitavg;
		
	}
	
	@Override
	public String toString() {
		return "Batter 타수: " + batcount + "이름: " + hit + "키: " + hitavg + " " +super.toString();
	}
}


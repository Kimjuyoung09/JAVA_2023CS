package problem1;

public class Frame {
	private String name;
	private String num, score;
	
	public Frame(String name, String num, String score) {
		this.name = name;
		this.num = num;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNum() {
		return num;
	}
	
	public void setNum(String num) {
		this.num = num;
	}
	
	public String getScore() {
		return score;
	}
	
	public void setScore(String score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return name + ", " + num + ", " + score;
	}
	
}

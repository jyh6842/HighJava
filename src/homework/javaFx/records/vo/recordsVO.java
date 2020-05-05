package homework.javaFx.records.vo;

public class recordsVO {
	private String name;
	private Integer kor;
	private int math;
	private int eng;
	
	
	public recordsVO(String name, Integer kor, int math, int eng) {
		super();
		this.name = name;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getKor() {
		return kor;
	}
	public void setKor(Integer kor) {
		this.kor = kor;
	}
	public Integer getMath() {
		return math;
	}
	public void setMath(Integer math) {
		this.math = math;
	}
	public Integer getEng() {
		return eng;
	}
	public void setEng(Integer eng) {
		this.eng = eng;
	}
	
	
}

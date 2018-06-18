package model;

public class FrInfo {
	private int num;
	private String fr_id;
	private String info1;
	private String info2;
	
	
	public String getFr_id() {
		return fr_id;
	}
	public void setFr_id(String fr_id) {
		this.fr_id = fr_id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getInfo1() {
		return info1;
	}
	public void setInfo1(String info1) {
		this.info1 = info1;
	}
	public String getInfo2() {
		return info2;
	}
	public void setInfo2(String info2) {
		this.info2 = info2;
	}
	
	@Override
	public String toString() {
		return "FrInfo [num=" + num + ", info1=" + info1 + ", info2=" + info2 + "]";
	}

}

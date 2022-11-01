package thong_tin;

import java.io.Serializable;

public class ConNguoi implements Serializable{
	private String hoten;
	private String diachi;
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public ConNguoi(String hoten, String diachi) {
		super();
		this.hoten = hoten;
		this.diachi = diachi;
	}
	public ConNguoi() {
		super();
	}
	
}

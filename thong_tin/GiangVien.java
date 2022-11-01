package thong_tin;

public class GiangVien extends ConNguoi {
	private String magv;
	private float hsluong;
	private float luong;
	public GiangVien() {
		super();
	}
	public GiangVien( String magv,String hoten, String diachi, float hsluong, float luong) {
		super(hoten, diachi);
		this.magv = magv;
		this.hsluong = hsluong;
		this.luong = luong;
	}
	public String getMagv() {
		return magv;
	}
	public void setMagv(String magv) {
		this.magv = magv;
	}
	public float getHsluong() {
		return hsluong;
	}
	public void setHsluong(float hsluong) {
		this.hsluong = hsluong;
	}
	public float getLuong() {
		return luong;
	}
	public void setLuong(float luong) {
		this.luong = luong;
	}
	@Override
	public String toString() {
		return "GiangVien [magv=" + magv +", ho ten=" + getHoten()
				+ ", dia chi =" + getDiachi() + ", hsluong=" + hsluong + ", luong=" + luong +  "]";
	}
	public GiangVien(String magv) {
		super();
		this.magv = magv;
	}
	
}

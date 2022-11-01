package thong_tin;

import java.util.Objects;

public class SinhVien extends ConNguoi implements Comparable<SinhVien>{
	private String masv;
	private float diemtk;
	private String lop;
	public SinhVien() {	
	}
	public SinhVien( String masv,String hoten, String diachi, float diemtk, String lop) {
		super(hoten, diachi);
		this.masv = masv;
		this.diemtk = diemtk;
		this.lop = lop;
	}
	public String getMasv() {
		return masv;
	}
	public void setMasv(String masv) {
		this.masv = masv;
	}
	public float getDiemtk() {
		return diemtk;
	}
	public void setDiemtk(float diemtk) {
		this.diemtk = diemtk;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	@Override
	public String toString() {
		return "SinhVien [masv=" + masv + ", hoten=" + getHoten()
				+ ", dia chi =" + getDiachi() +", diemtk=" + diemtk + ", lop=" + lop +  "]";
	}
	public SinhVien(String masv) {
		this.masv = masv;
	}
	@Override
	public int compareTo(SinhVien o) {
		if(this.diemtk<o.diemtk) {
			return 1;
		}else if(this.diemtk>o.diemtk) {
			return -1;
		}else {
		return 0;			
		}
	}
	@Override
	public int hashCode() {
		return Objects.hash(masv);
	}
	@Override
	public boolean equals(Object obj) {
		if (this.masv == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SinhVien other = (SinhVien) obj;
		return Objects.equals(masv, other.masv);
	}
	
	
}

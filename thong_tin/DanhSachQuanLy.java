 package thong_tin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import phuong_thuc_dtbs.pt_SinhVien;
import phuong_thuc_dtbs.*;
public class DanhSachQuanLy <T>{
	private ArrayList<T> danhsach;

	public DanhSachQuanLy() {
		this.danhsach=new ArrayList<T>();
	}

	public DanhSachQuanLy(ArrayList<T> danhsach) {
		super();
		this.danhsach = danhsach;
	}
	public void themthongtin(T t) {
		this.danhsach.add(t);
	}
	public void hienthisachsinhvien() {
		//c1
		for(T x : danhsach) {
			if(x instanceof SinhVien) {
				System.out.println(x);
			}
		}
//		this.danhsach.stream().filter(sv->sv instanceof SinhVien).forEach(sv->System.out.println(sv)); //c2
	}
	public void hienthisachgiangvien() {
		this.danhsach.stream().filter(gv->gv instanceof GiangVien).forEach(gv->System.out.println(gv));
	}
	public void xoasinhsinhvien(SinhVien sv) {
		Iterator<T> itr = danhsach.iterator();
		while(itr.hasNext()) {
			T t=itr.next();
			if(t.equals(sv)) {
				itr.remove();
			}
		}
	}
	public void xoagiangvien(String mgv) {
		GiangVien gv=(GiangVien) this.danhsach.stream().filter(x->((GiangVien) x).getMagv().equals(mgv)).findFirst().orElse(null);
		if(gv!=null) {
			this.danhsach.remove(gv);
		}
	}
	public void timkiem(String ma) {
		for(T x : danhsach) {
			if(x instanceof SinhVien) {
				if(((SinhVien)x).getMasv().equals(ma)){
					System.out.println(x);
				}
			}
		}
	}
	pt_SinhVien a=new pt_SinhVien();
	pt_GiangVien b=new pt_GiangVien();
	public void capnhapSinhVienvaoDataBase() {
		for(T x : danhsach) {
			if(x instanceof SinhVien) {
				a.them((SinhVien) x);
			}
		}
	}
	
	public void xoaSinhVienkhoiDataBase(String ma) {
		a.xoa(ma);
	}
	public void capnhatSinhVienDataBase(SinhVien sv) {
		a.capnhat(sv);
	}
	public void hienthiSinhVienDatabse() {
		a.hienthi();
	}
	public void xoadulieutrongbangSinhVien() {
		a.xoaDULIEUdatabase();
	}
	public void capnhapGiangVienvaoDataBase() {
		for(T x : danhsach) {
			if(x instanceof GiangVien) {
				
				b.them((GiangVien) x);
			}
		}
	}
	public void xoaGiangVienkhoiDatabase(String ma) {
		b.xoa(ma);
	}
	public void capnhatGiangVienvaoDatabase(GiangVien gv) {
		b.capnhat(gv);
	}
	public void hienthiGiaangViendatabase() {
		b.hienthi();
	}
	public void xoadulieutrongbangGiangVien() {
		b.xoaDULIEUdatabase();
	}
	public void xoadanhsach() {
		Iterator<T> itr=danhsach.iterator();
		while(itr.hasNext()) {
			itr.remove();
		}
	}
	public void sapxeptangdan() {
		Collections.sort((List<SinhVien>) danhsach);
	}
	public void luuvaofile() {
		FileOutputStream fos=null;
		try {
			fos = new FileOutputStream("D:\\filejava\\quanlytruonghoc.txt");
			ObjectOutputStream oos= new ObjectOutputStream(fos);
			for(T t:danhsach) {
					oos.writeObject(t);
			}
			oos.flush();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void docflie() {
		try {
			FileInputStream fis =new FileInputStream("D:\\filejava\\quanlytruonghoc.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			T t=null;
			while(true) {
				t=(T)ois.readObject();
				if(t!=null) {
					this.danhsach.add(t);
				}
		}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
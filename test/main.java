package test;

import java.util.Scanner;

import thong_tin.DanhSachQuanLy;
import thong_tin.GiangVien;
import thong_tin.SinhVien;

public class main {
	public static void main(String[] args) {
		DanhSachQuanLy dsql=new DanhSachQuanLy();
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println(
					"--------------------------------------\n"
					+"1.Thêm thông tin vào danh sach \n"
					+"2.Hiển thị danh sách \n"
					+"3.Xóa thông tin \n"
					+"4.Tìm kiếm thông tin \n"
					+"5.Sắp xếp danh sách \n"
					+"6.Lưu danh sach vào file \n"
					+"7.Thao tac voi database\n"
					+"8.Hiển thị danh sách từ file\n"
					+"9.Xóa danh sách \n"
					+"0.Thoát khỏi chương trình "
					+"\n-------------------------------------"
					);
			int luachon=sc.nextInt();
			if(luachon==1) {
				System.out.println(
						"a.Nhập thông tin của sinh viên"
						+"\nb.Nhập thông tin của giảng viên"
						);
				sc.nextLine();
				String luachon1=sc.nextLine();
				if(luachon1.equals("a")) {
					System.out.println("Nhập vào mã sinh viên : ");
					String ma=sc.nextLine();
					System.out.println("Nhập vào tên sinh viên : ");
					String hoten=sc.nextLine();
					System.out.println("Nhập vào quê quán ");
					String quequan=sc.nextLine();
					System.out.println("Nhập vào điểm tổng kết ");
					float diemtk=sc.nextFloat();
					System.out.println("Nhập vào lớp");
					sc.nextLine();
					String lop=sc.nextLine();
					SinhVien sv=new SinhVien(ma, hoten, quequan, diemtk, lop);
					dsql.themthongtin(sv);
				}else if(luachon1.equals("b")) {
					System.out.println("Nhập vào mã giảng viên : ");
					String ma=sc.nextLine();
					System.out.println("Nhập vào tên giảng viên : ");
					String hoten=sc.nextLine();
					System.out.println("Nhập vào quê quán ");
					String quequan=sc.nextLine();
					System.out.println("Nhập vào hệ số lương ");
					float diemtk=sc.nextFloat();
					System.out.println("Nhập vào lương");
					float luong=sc.nextFloat();
					GiangVien gv=new GiangVien(ma, hoten, quequan, luong, luong);
					dsql.themthongtin(gv);
				}
					
				
			}else if(luachon==2) {
				System.out.println(
						"a.Hiển thị danh sach sinh vien "
						+"\nb.Hiển thị danh sach giang vien"
						);
				sc.nextLine();
				String luachon1=sc.nextLine();
				if(luachon1.equals("a")) {
					dsql.hienthisachsinhvien();	
				}else if(luachon1.equals("b")) {
					dsql.hienthisachgiangvien();
				}
				
			}else if(luachon==3) {
				System.out.println(
						"a.Xóa thông tin sinh viên \n"
						+"b.Xóa thông tin giang vien"
					);
				sc.nextLine();
				String luachon1=sc.nextLine();
				if(luachon1.equalsIgnoreCase("a")) {
					System.out.println("Nhap vao ma sinh vien cua sinh vien can xoa : ");
					String masv=sc.nextLine();
					SinhVien sv=new SinhVien(masv);
					dsql.xoasinhsinhvien(sv);
					System.out.println("danh sach sinh vien sau khi xoa la : ");
					dsql.hienthisachsinhvien();
				}else if(luachon1.equals("b")){
					System.out.println("Nhap vao ma gv cua giang vien can xoa : ");
					String magv=sc.nextLine();
					dsql.xoagiangvien(magv);
					System.out.println("danh sach giang vien sau khi xoa la : ");
					dsql.hienthisachgiangvien();
				}
			}else if(luachon==4) {
				System.out.println(
						"a.Tim sinh viên "
						+"\nb.Tim giang viên");
				sc.nextLine();
				String luachon1=sc.nextLine();
				if(luachon1.equals("a")) {
					System.out.println("Nhap vao ma sinh vien : ");
					String msv=sc.nextLine();
					dsql.timkiem(msv);
				}else if(luachon1.equals("b")) {
					System.out.println("Nhap vao ma Giang vien : ");
					String mgv=sc.nextLine();
					dsql.timkiem(mgv);
				}
			}else if(luachon==5) {
				dsql.sapxeptangdan();
			}else if(luachon==6) {
				dsql.luuvaofile();
			}else if(luachon==7) {
				sc.nextLine();
				while(true) {
				System.out.println(
						"================================="
						+"\na.Xóa sinh viên "
						+"\nb.Xóa giang viên"
						+"\nc.Them danh sach vua nhap sinh vien vao database"
						+"\nd.Xoa du lieu trong bang sinh vien "
						+"\ne.Xoa du lieu trong bang giang vien "
						+"\nf.Sua thong tin cua sinh vien trong bang "
						+"\ng.Sua thong tin cua giang vien trong bang "
						+"\nh.Them danh sach vua nhap giang vien vao database"
						+"\ni.Hien thi danh sach sinh vien trong database"
						+"\nk.Hien thi danh sach giang vien trong databse"
						+"\nx.Ve menu chinh"
						+"\n=================================");
				
				String luachon1=sc.nextLine();
				if(luachon1.equals("a")) {
					System.out.println("Nhap vao ma sinh vien can xoa : ");
					String msv=sc.nextLine();
					dsql.xoaSinhVienkhoiDataBase(msv);
				}else if(luachon1.equals("b")) {
					System.out.println("Nhap vao ma giang vien can xoa : ");
					String msv=sc.nextLine();
					dsql.xoaGiangVienkhoiDatabase(msv);
				}
				else if(luachon1.equals("c")) {
					dsql.capnhapSinhVienvaoDataBase();
				}
				else if(luachon1.equals("d")) {
					dsql.xoadulieutrongbangSinhVien();
				}
				else if(luachon1.equals("e")) {System.out.println("Nhap vao ma giang vien can xoa : ");
					String msv=sc.nextLine();
					dsql.xoaGiangVienkhoiDatabase(msv);
				}else if(luachon1.equals("g")) {
					System.out.println("Nhap vao ma giang vien can xoa : ");
					String msv=sc.nextLine();
					dsql.xoaGiangVienkhoiDatabase(msv);	
				}else if(luachon1.equals("f")) {
					System.out.println("nhap vao ma sinh vien can sua");
					String masv=sc.nextLine();
					System.out.println("Nhập vào tên sinh viên : ");
					String hoten=sc.nextLine();
					System.out.println("Nhập vào quê quán ");
					String quequan=sc.nextLine();
					System.out.println("Nhập vào điểm tổng kết ");
					float diemtk=sc.nextFloat();
					System.out.println("Nhập vào lớp");
					sc.nextLine();
					String lop=sc.nextLine();
					SinhVien sv=new SinhVien(masv, hoten, quequan, diemtk, lop);
					dsql.capnhatSinhVienDataBase(sv);
				}
				else if(luachon1.equals("h")) {
					dsql.capnhapGiangVienvaoDataBase();
				}else if(luachon1.equals("i")) {
					dsql.hienthiSinhVienDatabse();
				}else if(luachon1.equals("k")) {
					dsql.hienthiGiaangViendatabase();
				}else if(luachon1.equals("x")) {
					break;
				}
				}
			}else if(luachon==8) {
				dsql.docflie();
			}else if(luachon==9) {
				dsql.xoadanhsach();
			}else if(luachon==0) {
				break;
			}
		}
	}
}

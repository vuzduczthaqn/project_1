package phuong_thuc_dtbs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectiondatabase.connect;
import thong_tin.GiangVien;

public class pt_GiangVien implements phuong_thuc_tongquat<GiangVien>{

	@Override
	public int them(GiangVien sv) {
		try {
			Connection conn=connect.connectionDatabase();
			Statement str=conn.createStatement();
			String sql="INSERT INTO GIANGVIEN "+
						"VALUES ('"+sv.getMagv()+"','"+sv.getHoten()+"','"+sv.getDiachi()+"','"+sv.getHsluong()+"','"+sv.getLuong()+"')";
			str.executeUpdate(sql);
			connect.closeconnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int xoa(String ma) {
		try {
			Connection conn=connect.connectionDatabase();
			Statement str=conn.createStatement();
			String sql="DELETE FROM GIANGVIEN"+
						" WHERE GIANGVIEN.MAGV="+ma;
			str.executeUpdate(sql);
			connect.closeconnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int capnhat(GiangVien sv) {
		try {
			Connection conn=connect.connectionDatabase();
			Statement str=conn.createStatement();
			String sql="UPDATE GIANGVIEN "+
						" SET MAGV='"+sv.getMagv()+"',HOTEN='"+sv.getHoten()+"',DIACHI='"+sv.getDiachi()+"',HSLUONG="+sv.getHsluong()+",LUONG='"+sv.getLuong()+"'"
						+ "WHERE MAGV='"+sv.getMagv()+"'";
			str.executeUpdate(sql);
			connect.closeconnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void hienthi() {
		try {
			Connection conn=connect.connectionDatabase();
			Statement str=conn.createStatement();
			ResultSet rss=str.executeQuery("select * from GIANGVIEN");
			while(rss.next())
				System.out.println(rss.getString(1)+"\t"+rss.getString(2)+"\t"+rss.getString(3)+"\t"+rss.getFloat(4)+"\t"+rss.getString(5));
			rss.close();
			str.close();
			connect.closeconnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void xoaDULIEUdatabase() {
		try {
			Connection conn=connect.connectionDatabase();
			Statement str=conn.createStatement();
			String sql="DELETE FROM GIANGVIEN";
			str.executeUpdate(sql);
			connect.closeconnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	@Override
//	public String kiemtratontai(String ma) { 
//		try {
//			Connection conn=connect.connectionDatabase();
//			Statement str=conn.createStatement();
//			String sql="IF EXISTS (SELECT * FROM SINHVIEN "
//					+"WHERE MASV='"+ma+"')"
//					+" RETURN 1";
//			int dk=str.executeUpdate(sql);
//			connect.closeconnection(conn);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}

}

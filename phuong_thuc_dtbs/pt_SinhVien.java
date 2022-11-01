package phuong_thuc_dtbs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectiondatabase.connect;
import thong_tin.SinhVien;

public class pt_SinhVien implements phuong_thuc_tongquat<SinhVien>{

	@Override
	public int them(SinhVien sv) {
		
		try {
			Connection conn=connect.connectionDatabase();
			Statement str=conn.createStatement();
			String sql="INSERT INTO SINHVIEN "+
						"VALUES ('"+sv.getMasv()+"','"+sv.getHoten()+"','"+sv.getDiachi()+"','"+sv.getDiemtk()+"','"+sv.getLop()+"')";
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
			String sql="DELETE FROM SINHVIEN"+
						" WHERE SINHVIEN.MASV="+ma;
			str.executeUpdate(sql);
			connect.closeconnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int capnhat(SinhVien sv) {
		try {
			Connection conn=connect.connectionDatabase();
			Statement str=conn.createStatement();
			String sql="UPDATE SINHVIEN "+
						" SET MASV='"+sv.getMasv()+"',HOTEN='"+sv.getHoten()+"',DIACHI='"+sv.getDiachi()+"',DIEMTK="+sv.getDiemtk()+",LOP='"+sv.getLop()+"'"
						+ "WHERE MASV='"+sv.getMasv()+"'";
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
			ResultSet rss=str.executeQuery("select * from SINHVIEN");
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
			String sql="DELETE FROM SINHVIEN";
			str.executeUpdate(sql);
			connect.closeconnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

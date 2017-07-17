package com.hanbit.gms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.gms.constant.DB;
import com.hanbit.gms.domain.MemberBean;

public class MemberDAOImpl implements MemberDAO {
	public MemberDAOImpl() {
		try {
			Class.forName(DB.DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER LOAD FAIL....");
			e.printStackTrace();
		}
		
	}
	@Override
	public int insert(MemberBean member) {
		int rs = 0;
		try {
			rs = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeUpdate(
					String.format("INSERT INTO %s(%s,%s,%s,%s,%s) VALUES('%s','%s','%s','%s',SYSDATE)",DB.TABLE_MEMBER,DB.MEMBER_ID,DB.MEMBER_NAME,DB.MEMBER_PASS,DB.MEMBER_SSN,DB.MEMBER_REGDATE,member.getId(),member.getName(),member.getPw(),member.getSsn())
					);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public List<MemberBean> selectAll() {
		List<MemberBean> list = new ArrayList<>();
		// TODO Auto-generated method stub
		try {
			ResultSet rs=DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeQuery(
					String.format("SELECT * FROM %s",DB.TABLE_MEMBER));
			MemberBean member = null;
			while(rs.next()) {
				member = new MemberBean();
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setName(rs.getString(DB.MEMBER_NAME));
				member.setPw(rs.getString(DB.MEMBER_PASS));
				member.setRegdate(rs.getString(DB.MEMBER_REGDATE));
				member.setSsn(rs.getString(DB.MEMBER_SSN));
				
				list.add(member);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int countMembers() {
		int res =0;
		try {
			ResultSet rs=DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeQuery(
					String.format("SELECT COUNT(*) AS %s FROM %s","count",DB.TABLE_MEMBER)
					);
			if(rs.next()) {
				res=Integer.parseInt(rs.getString("count"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public MemberBean selectById(String id) {
		MemberBean member = new MemberBean();
		try {
			Connection conn = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD);
			Statement stmt = conn.createStatement();
			String sql="SELECT * FROM Member WHERE id ='"+id+"'";
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()) {
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setName(rs.getString(DB.MEMBER_NAME));
				member.setPw(rs.getString(DB.MEMBER_PASS));
				member.setRegdate(rs.getString(DB.MEMBER_REGDATE));
				member.setSsn(rs.getString(DB.MEMBER_SSN));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return member;
	}

	@Override
	public List<MemberBean> selectByNames(String name) {
		List<MemberBean> temp = new ArrayList<>();
		MemberBean member = null;
		try {
			ResultSet rs=DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeQuery(String.format("SELECT * FROM %s WHERE %s ='"+name+"'", DB.TABLE_MEMBER,DB.MEMBER_NAME));
			while(rs.next()) {
				member=new MemberBean();
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setName(rs.getString(DB.MEMBER_NAME));
				member.setPw(rs.getString(DB.MEMBER_PASS));
				member.setRegdate(rs.getString(DB.MEMBER_REGDATE));
				member.setSsn(rs.getString(DB.MEMBER_SSN));
				temp.add(member);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public int update(MemberBean member) {
		int rs=0;
		try {
			Class.forName(DB.DRIVER);
			rs = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeUpdate(
					String.format("INSERT INTO %s VALUES('%s','%s','%s','%s',SYSDATE)",DB.TABLE_MEMBER,member.getId(),member.getName(),member.getPw(),member.getSsn())
					);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public int delete(String id) {
		int rs=0;
		try {
			rs = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeUpdate(
					String.format("%s", "")
					);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}

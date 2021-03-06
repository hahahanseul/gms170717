package com.hanbit.gms.dao;

import java.util.List;

import com.hanbit.gms.domain.MemberBean;

public interface MemberDAO {
	public String insert(MemberBean member);
	public List<MemberBean> selectAll();
	public String countMembers();
	public MemberBean selectById(String id);
	public List<MemberBean> selectByNames(String name);
	public String update(MemberBean member);
	public String delete(String id);
	//MemberBean[] list=new MemberBean[4];
}

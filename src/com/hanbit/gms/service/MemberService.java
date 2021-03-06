package com.hanbit.gms.service;

import java.util.List;

import com.hanbit.gms.domain.MemberBean;

public interface MemberService {
	public String addMember(MemberBean member);
	public List<MemberBean> getMembers();
	public List<MemberBean> findByNames(String name);
	public MemberBean findById(String id);
	public String countMembers();
	public String modify(MemberBean member);
	public String remove(String id);
	//MemberBean[] list=new MemberBean[4];
}

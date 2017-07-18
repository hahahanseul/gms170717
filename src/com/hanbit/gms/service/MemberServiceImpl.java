package com.hanbit.gms.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hanbit.gms.dao.MemberDAO;
import com.hanbit.gms.dao.MemberDAOImpl;
import com.hanbit.gms.domain.MemberBean;
import com.hanbit.gms.service.MemberService;

public class MemberServiceImpl implements MemberService {
	public static MemberServiceImpl getInstance() {
		return new MemberServiceImpl();
		}
	private MemberServiceImpl() {}
	@Override
	public String addMember(MemberBean member) {
		return (MemberDAOImpl.getInstance().insert(member).equals("1"))?"등록성공":"실패";
	}
	@Override
	public List<MemberBean> getMembers() {
		return MemberDAOImpl.getInstance().selectAll();
	}
	@Override
	public String countMembers() {
		return String.valueOf(MemberDAOImpl.getInstance().countMembers());
	}
	@Override
	public List<MemberBean> findByNames(String name) {
		return MemberDAOImpl.getInstance().selectByNames(name);
	}
	@Override
	public MemberBean findById(String id) {
		return MemberDAOImpl.getInstance().selectById(id);
	}

	@Override
	public String modify(MemberBean param) {
		String msg="";
		return msg;	
	}
	@Override
	public String remove(String id) {
		String msg="";
		return msg;
		
	}
}
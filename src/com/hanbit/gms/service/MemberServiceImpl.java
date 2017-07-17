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
	Map<String,MemberBean> map;
	public MemberServiceImpl() {
		map = new HashMap<>();
	} // i는 처음 입력받은 회원수, 총 회원수는 count에 담겨서 그 숫자만큼 MemberBean의 공간이 생성됨

	@Override
	public String addMember(MemberBean member) {
		return (new MemberDAOImpl().insert(member)==1)?"등록성공":"실패";
	}
	
	@Override
	public List<MemberBean> getMembers() {
		return new MemberDAOImpl().selectAll();
	}
	@Override
	public int countMembers() {
		return new MemberDAOImpl().countMembers();
	}
	@Override
	public List<MemberBean> findByNames(String name) {
		return new MemberDAOImpl().selectByNames(name);
	}
	@Override
	public MemberBean findById(String id) {
		MemberBean member =new MemberBean();
		MemberDAO dao = new MemberDAOImpl();
		member = dao.selectById(id);
		return member;
	}

	@Override
	public String modify(MemberBean param) {
		String msg="";
			if(!param.getName().equals("")) {
				map.get(param.getId()).setName(param.getName());
			}
			if(!param.getPw().equals("")) {
				map.get(param.getPw()).setPw(param.getPw());
			}
			if(!param.getSsn().equals("")) {
				map.get(param.getSsn()).setSsn(param.getSsn());
			}
		return msg;	
	}
	@Override
	public String remove(String id) {
		String msg="";
		map.remove(id);
		return msg;
		
	}
}
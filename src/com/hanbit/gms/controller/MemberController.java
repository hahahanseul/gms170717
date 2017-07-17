package com.hanbit.gms.controller;
import com.hanbit.gms.constant.Butt;
import com.hanbit.gms.domain.MemberBean;
import com.hanbit.gms.service.MemberService;
import com.hanbit.gms.service.MemberServiceImpl;

import java.util.List;

import javax.swing.*;

public class MemberController {
	public static void main(String[] args) {
		MemberService service = new MemberServiceImpl();
		MemberBean member = null;
		Butt[] buttons = {Butt.EXIT,Butt.ADD,Butt.LIST,Butt.FIND_NAME,Butt.FIND_ID,Butt.COUNT,Butt.UPDATE,Butt.DEL};
		do{
			flag:
			switch((Butt)JOptionPane.showInputDialog(null, "MEMBER ADMIN","SELECT MENU", JOptionPane.QUESTION_MESSAGE,null, buttons,buttons[1])){
			case EXIT:
				return;
			case ADD:
				member = new MemberBean();
				String[] arr = JOptionPane.showInputDialog("NAME/ID/PASSWORD/SSN").split("/");
				member.setName(arr[0]);
				member.setId(arr[1]);
				member.setPw(arr[2]);
				member.setSsn(arr[3]);
				JOptionPane.showMessageDialog(null, service.addMember(member));			
				break flag;
			case COUNT:
				JOptionPane.showMessageDialog(null, service.countMembers());
				break flag;
			case LIST:
				JOptionPane.showMessageDialog(null, service.getMembers());
				break flag;
			case FIND_ID:
				JOptionPane.showMessageDialog(null,service.findById(JOptionPane.showInputDialog("검색할 Id를 입력하세요")).toString());
				break flag;
			case FIND_NAME:
				String name = JOptionPane.showInputDialog("검색할 이름을 입력하세요");
				JOptionPane.showMessageDialog(null,service.findByNames(name));
				break flag;
			case UPDATE:
				String id = JOptionPane.showInputDialog("아이디");
				String newPassword = JOptionPane.showInputDialog("새로운 비밀번호를 입력하세요");
				String newName = JOptionPane.showInputDialog("새로운 이름을 입력하세요");
				String newSsn = JOptionPane.showInputDialog("새로운 주민등록번호를 입력하세요");
				member = new MemberBean();
				member.setId(id);
				member.setPw(newPassword);
				member.setName(newName);
				member.setSsn(newSsn);
				service.modify(member);
				JOptionPane.showMessageDialog(null, "수정완료");
				break flag;
			case DEL:
				service.remove(JOptionPane.showInputDialog("삭제할 아이디를 입력하세요"));
				JOptionPane.showMessageDialog(null, "삭제완료");
				break flag;
			}
		}while(true);
	}
}
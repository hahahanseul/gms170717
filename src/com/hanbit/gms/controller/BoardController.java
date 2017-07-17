package com.hanbit.gms.controller;

import com.hanbit.gms.constant.Butt;
import com.hanbit.gms.domain.ArticleBean;
import com.hanbit.gms.service.ArticleService;
import com.hanbit.gms.service.ArticleServiceImpl;

import oracle.net.ano.Service;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class BoardController {
 public static void main(String[] args) {
	 Butt[] buttons = {Butt.EXIT,Butt.ADD,Butt.LIST,Butt.FIND_ID,Butt.FIND_SEQ,Butt.COUNT,Butt.UPDATE,Butt.DEL};
	 ArticleBean bean = new ArticleBean();
	 List<ArticleBean> list = new ArrayList<>();
	 ArticleService service = new ArticleServiceImpl();
	 do{
		flag:
		switch((Butt)JOptionPane.showInputDialog(null, "MEMBER ADMIN","SELECT MENU", JOptionPane.QUESTION_MESSAGE,null, buttons,buttons[1])) {
		case EXIT:
			return;
		case ADD:
			String[] arr = (JOptionPane.showInputDialog("id/글제목/내용")).split("/");
			bean.setId(arr[0]);
			bean.setTitle(arr[1]);
			bean.setContent(arr[2]);
			JOptionPane.showMessageDialog(null, service.write(bean));
			break flag;
		case COUNT:
			JOptionPane.showMessageDialog(null, service.count());
			break flag;
		case LIST:
			JOptionPane.showMessageDialog(null, service.list());
			break flag;
		case FIND_ID:
			JOptionPane.showMessageDialog(null,  service.findById(JOptionPane.showInputDialog("작성자 ID를 입력하세요.")));
			break flag;
		case FIND_SEQ:
			JOptionPane.showMessageDialog(null, service.findBySeq(Integer.parseInt(JOptionPane.showInputDialog("작성글 번호를 입력하세요."))));
			break flag;
		case UPDATE:
			bean.setArticleSeq(Integer.parseInt(JOptionPane.showInputDialog("글번호를 입력하세요")));
			bean.setTitle(JOptionPane.showInputDialog("제목을 입력하세요"));
			bean.setContent(JOptionPane.showInputDialog("수정내용을 입력하세요"));
			JOptionPane.showMessageDialog(null, service.modify(bean));
			break flag;
		case DEL:
			service.remove(Integer.parseInt(JOptionPane.showInputDialog("삭제할 게시글 번호를 입력하세요.")));
			JOptionPane.showMessageDialog(null, "삭제완료");
			break flag;			
		}		
	 }while(true);
 }
}

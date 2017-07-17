package com.hanbit.gms.dao;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.gms.constant.DB;
import com.hanbit.gms.domain.ArticleBean;

public class ArticleDAOImpl implements ArticleDAO {
	public ArticleDAOImpl() {
		try {
			Class.forName(DB.DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER LOAD FAIL....");
			e.printStackTrace();
		}
		
	}
	@Override
	public String insert(ArticleBean bean) {
		int rs = 0;
		try {
			rs = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeUpdate(
					String.format("INSERT INTO %s(%s,%s,%s,%s,%s,%s) VALUES (article_seq.nextval,'%s','%s','%s','0',SYSDATE)"
					,DB.TABLE_BOARD
					,DB.BOARD_SEQ,DB.MEMBER_ID,DB.BOARD_TITLE,DB.BOARD_CONTENT,DB.BOARD_HITCNT,DB.BOARD_REGDATE
					,bean.getId(),bean.getTitle(), bean.getContent())
					);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return String.valueOf(rs);
	}

	@Override
	public List<ArticleBean> selectAll() {
		List<ArticleBean> list = new ArrayList<>();
		try {
			ResultSet rs = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeQuery(
					String.format("SELECT * FROM %s",DB.TABLE_BOARD )
					);
			ArticleBean article=null;
			while(rs.next()) {
				article = new ArticleBean();
				article.setArticleSeq(Integer.parseInt(rs.getString(DB.BOARD_SEQ)));
				article.setId(rs.getString(DB.BOARD_ID));
				article.setTitle(rs.getString(DB.BOARD_TITLE));
				article.setContent(rs.getString(DB.BOARD_CONTENT));
				article.setRegdate(rs.getString(DB.BOARD_ID));
				article.setId(rs.getString(DB.BOARD_REGDATE));
				article.setHitcount(rs.getInt(DB.BOARD_HITCNT));
				
				list.add(article);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ArticleBean> selectById(String id) {
		List<ArticleBean> list = new ArrayList<>();
		try {
			ResultSet rs = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeQuery(
					String.format("SELECT * FROM %s WHERE id = '%s'",DB.TABLE_BOARD, id )
					);
			ArticleBean article=null;
			while(rs.next()) {
				article = new ArticleBean();
				article.setArticleSeq(Integer.parseInt(rs.getString(DB.BOARD_SEQ)));
				article.setId(rs.getString(DB.BOARD_ID));
				article.setTitle(rs.getString(DB.BOARD_TITLE));
				article.setContent(rs.getString(DB.BOARD_CONTENT));
				article.setRegdate(rs.getString(DB.BOARD_ID));
				article.setId(rs.getString(DB.BOARD_REGDATE));
				article.setHitcount(rs.getInt(DB.BOARD_HITCNT));
				
				list.add(article);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArticleBean selectBySeq(int seq) {
		ArticleBean article = new ArticleBean();
		try {
			ResultSet rs = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeQuery(
					String.format("SELECT * FROM %s WHERE %s='%d'",DB.TABLE_BOARD,DB.BOARD_SEQ,seq)
					);
			if(rs.next()) {
				article.setArticleSeq(Integer.parseInt(rs.getString(DB.BOARD_SEQ)));
				article.setId(rs.getString(DB.BOARD_ID));
				article.setTitle(rs.getString(DB.BOARD_TITLE));
				article.setContent(rs.getString(DB.BOARD_CONTENT));
				article.setRegdate(rs.getString(DB.BOARD_ID));
				article.setId(rs.getString(DB.BOARD_REGDATE));
				article.setHitcount(rs.getInt(DB.BOARD_HITCNT));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return article;
	}

	@Override
	public int count() {
		int res =0;
		try {
			ResultSet rs=DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeQuery(
					String.format("SELECT COUNT(*) AS %s FROM %s","count",DB.TABLE_BOARD)
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
	public String update(ArticleBean bean) {
		int rs =0;
		try {
			rs = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeUpdate(
					"UPDATE Board SET title='" + bean.getTitle() + "', content='" + bean.getContent() + "' WHERE article_seq = '"+bean.getArticleSeq()+"'"); 
				  //"UPDATE Board SET title='"+bean.getTitle()+"', content='"+bean.getContent()+"'WHERE article_seq='"+bean.getArticleSeq()+"'");

		}
		catch(Exception e){
			e.printStackTrace();
		}
		return String.valueOf(rs);
	}

	@Override
	public String delete(int seq) {
		int rs=0;
		try {
			rs = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeUpdate(
					"DELETE FROM Board WHERE article_seq ='"+seq+"'"); 
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//
		return String.valueOf(rs);
	}

}

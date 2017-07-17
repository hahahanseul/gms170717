package com.hanbit.gms.service;

import java.util.List;

import com.hanbit.gms.dao.ArticleDAO;
import com.hanbit.gms.dao.ArticleDAOImpl;
import com.hanbit.gms.domain.ArticleBean;

public class ArticleServiceImpl implements ArticleService {

	@Override
	public String write(ArticleBean bean) {
		return (new ArticleDAOImpl().insert(bean).equals("1")) ? "글이 등록되었습니다.":"등록실패";
	}

	@Override
	public int count() {
		return new ArticleDAOImpl().count();
	}

	@Override
	public List<ArticleBean> list() {
		return new ArticleDAOImpl().selectAll();
	}

	@Override
	public List<ArticleBean> findById(String id) {
		// TODO Auto-generated method stub
		return new ArticleDAOImpl().selectById(id);
	}

	@Override
	public ArticleBean findBySeq(int seq) {
		return new ArticleDAOImpl().selectBySeq(seq);
	}

	@Override
	public String modify(ArticleBean bean) {
		// TODO Auto-generated method stub
		return new ArticleDAOImpl().update(bean).equals("1")?"업데이트됐습니다":"다시요";
	}

	@Override
	public String remove(int seq) {
		// TODO Auto-generated method stub
		return (new ArticleDAOImpl().delete(seq).equals("1")) ? "삭제성공했슈" : "삭제실패";
	}

}

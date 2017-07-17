package com.hanbit.gms.dao;

import java.util.List;

import com.hanbit.gms.domain.ArticleBean;

public interface ArticleDAO {
	public String insert(ArticleBean bean);
	public int count();
	public List<ArticleBean> selectAll();
	public List<ArticleBean> selectById(String id);
	public ArticleBean selectBySeq(int seq);
	public String update(ArticleBean bean);
	public String delete(int seq);	
}

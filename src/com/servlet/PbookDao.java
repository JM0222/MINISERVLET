package com.servlet;

import java.util.List;


public interface PbookDao {
	public List<PbookVo> getList();
	public int insert(PbookVo vo);
	public int delete(Long no); 
	public List<PbookVo> searchUser(String keyword);
}

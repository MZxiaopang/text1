package com.zhiyou.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zhiyou.model.mytest;

public interface UserService {
	// 增加数据
	void AddMessage(mytest mytest);

	// 删除数据
	void DeleteMessage(Integer id);

	// 修改数据
	void UpdateMessage(mytest mytest);

	// 查询信息
	List<mytest> SelectMessage(int page, int number);

	// 根据账户查询数据是否存在
	mytest SelectByName(HttpServletRequest req, String username, String password);

	// 通过ID查询用户
	mytest SelectById(Integer id);

	// 查询总条数
	int selectCount();
}

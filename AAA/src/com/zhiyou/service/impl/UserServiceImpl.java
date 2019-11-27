package com.zhiyou.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zhiyou.dao.UserDao;
import com.zhiyou.dao.impl.UserDaoUser;
import com.zhiyou.model.mytest;
import com.zhiyou.service.UserService;

public class UserServiceImpl implements UserService {

	private static UserDao dao = new UserDaoUser();

	@Override
	public void AddMessage(mytest mytest) {

		dao.AddMessage(mytest);
	}

	@Override
	public void DeleteMessage(Integer id) {
		// TODO Auto-generated method stub
		dao.DeleteMessage(id);
	}

	@Override
	public void UpdateMessage(mytest mytest) {
		// TODO Auto-generated method stub
		dao.UpdateMessage(mytest);
	}

	@Override
	public List<mytest> SelectMessage(int page, int number) {
		// TODO Auto-generated method stub
		return dao.SelectMessage(page, number);
	}

	@Override
	public mytest SelectByName(HttpServletRequest req, String username, String password) {
		// TODO Auto-generated method stub
		mytest mytest = dao.SelectByName(username);
		if (mytest != null) {
			if (mytest.getPASSWORD().equals(password)) {
			} else {
				req.setAttribute("msg", "密码错误");
				return null;
			}

		} else {
			req.setAttribute("msg", "用户不存在");
			return null;
		}
		return mytest;
	}

	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		return dao.selectCount();
	}

	@Override
	public mytest SelectById(Integer id) {
		// TODO Auto-generated method stub
		return dao.SelectById(id);
	}

}

package com.zhiyou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zhiyou.dao.UserDao;
import com.zhiyou.model.mytest;
import com.zhiyou.util.JDBCUtil;

public class UserDaoUser implements UserDao {

	@Override
	public void AddMessage(mytest mytest) {

		JDBCUtil.dbDML("insert into mytest values(null,?,?,?)", mytest.getSEX(), mytest.getUSERNAME(),
				mytest.getPASSWORD());

	}

	@Override
	public void DeleteMessage(Integer id) {
		// TODO Auto-generated method stub
		JDBCUtil.dbDML("delete from mytest where id=?", id);
	}

	@Override
	public void UpdateMessage(mytest mytest) {
		// TODO Auto-generated method stub
		JDBCUtil.dbDML("update mytest set sex=?,username=?,password=? where id=?", mytest.getSEX(),
				mytest.getUSERNAME(), mytest.getPASSWORD(), mytest.getID());
	}

	@Override
	public List<mytest> SelectMessage(int page, int number) {

		String sql = "select * from mytest limit " + page + "," + number;
		return JDBCUtil.dbDQL(sql, mytest.class);
	}

	@Override
	public mytest SelectByName(String name) {
		List<mytest> list = JDBCUtil.dbDQL("select * from mytest where username=?", mytest.class, name);
		if (list.size() != 0) {
			return list.get(0);

		} else {
			return null;
		}

	}

	@Override
	public int selectCount() {
		Connection conn = JDBCUtil.getConnection();
		String sql = "select count(*) from mytest";
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ps, rs);
		}
		return count;
	}

	@Override
	public mytest SelectById(Integer id) {
		// TODO Auto-generated method stub
		return JDBCUtil.dbDQL("select * from mytest where id=?", mytest.class, id).get(0);
	}

}

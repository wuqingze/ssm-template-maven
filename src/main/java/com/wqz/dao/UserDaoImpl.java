package com.wqz.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wqz.pojo.User;

public class UserDaoImpl implements UserDao {
	
	private SqlSessionFactory sqlSessionFactory;
	
	
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public User findUserById(Integer id) {
		SqlSession openSession = sqlSessionFactory.openSession();
		User user = openSession.selectOne("com.wqz.mapper.UserMapper.findUserById",id);
		return user;
	}

	public List<User> findUserByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

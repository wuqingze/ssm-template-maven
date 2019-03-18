package com.wqz.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mysql.cj.xdevapi.SessionFactory;
import com.wqz.pojo.User;

public class MySQLTest {

	@Test
	public void test() throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
//		byte[] b = new byte[inputStream.available()];
//		inputStream.read(b);
//		System.out.println(new String(b,"utf-8"));
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sessionFactory.openSession();
		User user = openSession.selectOne("test.findUserById",1);
		System.out.println(user);
		

		openSession.selectOne("test.findUserById",1);
	}
	
	@Test
	public void jdbc() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
//		<property name="driver" value="com.mysql.jdbc.Driver" />
//		<property name="url" value="jdbc:mysql://localhost:3306/mybatis" />
//		<property name="username" value="root" />
//		<property name="password" value="root" />
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis", "root", "root");
		String sql = "select * from user";
		PreparedStatement statement = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet s = statement.executeQuery();
		while(s.next()) {
			System.out.println("jj");
		}
		s.close();
		statement.close();
		conn.close();
	}
	
	
	@Test
	public void finduserbyname() throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sessionFactory.openSession();
		List<User> l = session.selectList("test.findUserByUsername","%三%");
		System.out.println(l);
	}
	
	@Test
	public void insertuser() throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sessionFactory.openSession();
	
		User user = new User(); 
		user.setAddress("上海市普陀区中山北路3663号");
//		user.setBirthday(new Date("1997-04-05").toString());
		user.setBirthday(new Date());
		user.setSex("1");
		user.setUsername("wuqingze");
		
		int id = session.insert("test.insertuser",user);
		System.out.println(id);
		session.commit();
	}
	
	
	@Test
	public void deleteuser() throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sessionFactory.openSession();
	
		int id = session.delete("deleteuser",29);
		System.out.println(id);
		session.commit();
	}
	
	@Test
	public void updateuser() throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sessionFactory.openSession();
	
		User user = new User();
		user.setId(25);
		user.setBirthday(new Date());
		int id = session.update("updateuser",user);
		System.out.println(id);
		session.commit();
	}
}

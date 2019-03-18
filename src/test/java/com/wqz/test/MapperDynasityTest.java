package com.wqz.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.IOException;
import java.io.InputStream;


import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.wqz.mapper.UserMapper;
//import com.wqz.pojo.CustomOrders;
import com.wqz.pojo.Orders;
//import com.wqz.pojo.QueryVo;
import com.wqz.pojo.User;
import com.wqz.pojo.UserExample;

public class MapperDynasityTest {

	
	private SqlSessionFactory factory;
	private String sqlxml = "SqlMapConfig.xml";
	private UserMapper mapper;
	private String dpproperties = "db.properties";
	
	@Before
	public void setup() throws IOException {
		InputStream in = MapperDynasityTest.class.getClassLoader().getResourceAsStream(sqlxml);
		byte[] b = new byte[in.available()];
		factory = new SqlSessionFactoryBuilder().build(in);
		mapper = factory.openSession().getMapper(com.wqz.mapper.UserMapper.class);
	}
	
//	@Test
//	public void findUserById() {
//		User user = mapper.findUserById(25);
//		System.out.println(user);
//	}
//	
//	@Test
//	public void findUserByName() {
//		List<User> l = mapper.findUserByUserName("王");
//		System.out.println(l);
//	}
//	
//	@Test
//	public void insert() {
//		User u = new User();
//		u.setAddress("shanghaiecnu");
//		u.setBirthday(new Date("1997/04/05"));
//		u.setUsername("wuqingze");
//		
//		mapper.insertUser(u);
//		System.out.println(u);
//	}
//	
//	@Test
//	public void findUserByIds() {
//		QueryVo v = new QueryVo();
//		List<Integer> l = new ArrayList<Integer>();
//		l.add(1);l.add(10);l.add(16);l.add(22);l.add(24);l.add(25);
//		v.setIds(l);
//		
//		List<User> ll = mapper.findUserByIds(v);
//		System.out.println(ll);
//	}
//	
//	@Test
//	public void findOrdersAndUser1() {
//		List<CustomOrders> l = mapper.findOrdersAndUser1();
//		System.out.println(l);
//	}
//	
//	@Test
//	public void findOrdersAndUser2() {
//		List<Orders> orders = mapper.findOrdersAndUser2();
//		System.out.println(orders);
//	}
//	
//	@Test
//	public void findOrders() {
//		System.out.println(mapper.findOrders());
//	}
//	
//	@Test
//	public void findUserAndOrders() {
//		System.out.println(mapper.findUserAndOrders());
//	}
	
	
	@Test
	public void testjj() {
//		UserExample userExample = new UserExample();
//		UserExample.Criteria criteria = userExample.createCriteria();
//		criteria.andIdEqualTo(25);
//		List<User> l = mapper.selectByExample(criteria);
//		System.out.println(l);
//		System.out.println("hello");
		System.out.println(mapper.selectByPrimaryKey(25));
	}
	
	
	@Test
	public void finduserandsex() {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUsernameLike("%王%");
//		criteria.andSexEqualTo("1");
		System.out.println(mapper.selectByExample(example));
	}
	
	
	@Test
	public void testdp() throws IOException {
		InputStream in = MapperDynasityTest.class.getClassLoader().getResourceAsStream(dpproperties);
		byte[] b = new byte[in.available()];
		in.read(b);
		System.out.println(new String(b));
	}

}

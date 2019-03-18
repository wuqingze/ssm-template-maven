package com.wqz.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wqz.mapper.UserMapper;
import com.wqz.pojo.Items;
import com.wqz.pojo.User;
import com.wqz.pojo.UserExample;

public class ItemsTest {
	private ApplicationContext applicatonContext;
	
	@Before
	public void setUp() throws Exception{
		String configLocation = "classpath:ApplicationContext.xml";
		applicatonContext = new ClassPathXmlApplicationContext(configLocation);
	}
	
	
	@Test
	public void itemsmapper() throws Exception{
		com.wqz.mapper.ItemsMapper itemMapper = (com.wqz.mapper.ItemsMapper)applicatonContext.getBean(com.wqz.mapper.ItemsMapper.class);
		
		Items items = itemMapper.selectByPrimaryKey(1);
		System.out.println(items);
	}

}

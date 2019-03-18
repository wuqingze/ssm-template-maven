package com.wqz.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wqz.pojo.Items;

public class ServiceTest {
private ApplicationContext applicatonContext;
	
	@Before
	public void setUp() throws Exception{
		String configLocation = "classpath:ApplicationContext.xml";
		applicatonContext = new ClassPathXmlApplicationContext(configLocation);
	}
	
	
	@Test
	public void itemsmapper() throws Exception{
		com.wqz.service.ItemsService service = applicatonContext.getBean(com.wqz.service.ItemsServiceImpl.class);
		System.out.println(service.list());
		System.out.println(service.findItemsById(1));
	}
}

package com.wqz.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.ibatis.io.Resources;
import org.junit.Test;

public class RecourcesFileTest {
	
//	private String filename = "helloworld";
	private String filename = "./myconfig/helloworld";
	@Test
	public void test() throws IOException {
		
		InputStream in = Resources.getResourceAsStream(filename);
		byte[] b = new byte[in.available()];
		in.read(b);
		String s = new String(b);
		System.out.println(s);
	}
	
	@Test
	public void classloaderrecource() throws IOException {
		String url = RecourcesFileTest.class.getResource("").getPath();
		System.out.println(url);
		InputStream in = RecourcesFileTest.class.getClassLoader().getResourceAsStream(filename);
		byte[] b = new byte[in.available()];
		in.read(b);
		String s = new String(b);
		System.out.println(s);
		System.out.println(RecourcesFileTest.class.getClassLoader().getResource("").getPath());
	}
}

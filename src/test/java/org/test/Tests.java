package org.test;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring.xml", "classpath*:spring-mybatis.xml" })
public class Tests {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(Tests.class);


	@Test
	public void test2() {
		
	}
}
	

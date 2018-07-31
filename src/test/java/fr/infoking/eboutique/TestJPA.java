package fr.infoking.eboutique;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJPA {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {
		try {
			
			ClassPathXmlApplicationContext	context = new ClassPathXmlApplicationContext(new String[]{"ApplicationContext.xml"});
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
		
	}

}

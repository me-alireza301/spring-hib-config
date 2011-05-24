package com.gs.sample.component;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-lego-config.xml"})
public class LegoServiceTest {

	@Autowired
	private LegoService legoService;
	
	@Test public void basicTesting() {
		
	}
}

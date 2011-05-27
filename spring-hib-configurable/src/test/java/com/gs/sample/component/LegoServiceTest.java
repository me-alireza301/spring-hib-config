package com.gs.sample.component;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gs.sample.pojo.LegoIndianaJonesPojo;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-lego-config.xml"})
public class LegoServiceTest {

	@Autowired
	private LegoService legoService;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Test public void checkAspectOnPojo() {
		LegoIndianaJonesPojo indi = new LegoIndianaJonesPojo();
//		LegoIndianaJonesPojo indi = applicationContext.getBean(LegoIndianaJonesPojo.class);
		assertNotNull(indi.getLegoService());
		// add aspect using @Configurable/spring-config/aspectj to inject the LegoService to the LegoIndianaJonesPojo
		indi.doYourThingIndi();
	}
	
	@Ignore
	@Test public void basicTesting() {
		assertNotNull(legoService);
		legoService.whipHorse();
		legoService.whipMerchant();
		System.out.println("AFTER");
	}
	
	@Ignore
	@Test public void beanDumper() {
		for(String s : applicationContext.getBeanDefinitionNames()) {
			System.out.printf("%s - %s\n",s,applicationContext.getBean(s));
		}
	}
}

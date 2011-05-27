package com.gs.sample.component;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gs.sample.domain.other.Light;
import com.gs.sample.repository.LightRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-candle-config.xml"})
public class LightTest {
	
	@Autowired ApplicationContext applicationContext;
	@Autowired @Qualifier("hibLightRepository") LightRepository lightRepository;
	
	@Autowired SessionFactory sessionFactory;
	
	@Test public void lightPersist() {
		Light light = applicationContext.getBean("light",Light.class);
		light.setBrightnessLevel(34);
		light.setManufacturer("Westinghouse");
		light.persist();
		System.out.println(lightRepository.findAll().size());
		
		System.out.println("HERE");
	}
	
	
	@Ignore
	@Test public void basic() {
		lightRepository.save(Light.createLight(3,"GE"));
		lightRepository.save(Light.createLight(3,"Con-Ed"));
		lightRepository.save(Light.createLight(3,"Westinghouse"));
		List<Light> lights = lightRepository.findAll();
		assertFalse(lights.isEmpty());
		assertEquals(3, lights.size());
		for (Light light : lights) {
			System.out.println(light);
		}
	}

	@Ignore
	@Test public void dumpBeanNames() {
		for (String beanName : applicationContext.getBeanDefinitionNames()) {
			System.out.println(beanName+"  " + applicationContext.getBean(beanName).getClass().getName());
		}
		
	}
}

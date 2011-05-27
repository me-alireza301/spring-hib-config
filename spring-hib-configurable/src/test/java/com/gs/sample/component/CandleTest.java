package com.gs.sample.component;

import java.util.List;
import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gs.sample.domain.Candle;
import com.gs.sample.repository.CandleRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-candle-config.xml"})
public class CandleTest {
	
	@Autowired ApplicationContext applicationContext;
	@Autowired @Qualifier("candleRepository") CandleRepository candleRepository;
	
	@Autowired SessionFactory sessionFactory;
	@Test public void basic() {
		candleRepository.save(Candle.createCandle("red"));
		candleRepository.save(Candle.createCandle("blue"));
		candleRepository.save(Candle.createCandle("green"));
		List<Candle> candles = candleRepository.findAll();
		assertFalse(candles.isEmpty());
		assertEquals(3, candles.size());
		for (Candle candle : candles) {
			System.out.println(candle);
		}
	}

//	@Ignore
	@Test public void dumpBeanNames() {
		for (String beanName : applicationContext.getBeanDefinitionNames()) {
			System.out.println(beanName+"  " + applicationContext.getBean(beanName).getClass().getName());
		}
		
	}
}

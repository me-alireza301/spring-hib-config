package com.gs.sample.hibernatestuff;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gs.sample.domain.Candle;
import com.gs.sample.repository.CandleRepository;

@Component
public class CandleFactory implements IObjectFactory {

	public void injectDependencies(Object entity) {
		System.out.println("ENTITY TIME");
		if (entity instanceof Candle) {
			injectCandleDependencies((Candle) entity);
		} else {
			throw new IllegalArgumentException("Unsupported type: "
					+ entity.getClass());
		}
	}

	private void injectCandleDependencies(Candle entity) {
		System.out.println("Injecting Candle Dependencies");
		
	}

	public void injectDependencies(Object entity, Map<Object, Object> items) {
		System.out.println("HURAY: injectDependencies");
		Candle candle = (Candle) entity;
		candle.setCandleRepository((CandleRepository)items.get("candleRepository"));
	}

}
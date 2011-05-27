package com.gs.sample.hibernatestuff;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gs.sample.domain.Candle;
import com.gs.sample.domain.other.Light;
import com.gs.sample.repository.LightRepository;

@Component
public class LightFactory implements IObjectFactory {

	public void injectDependencies(Object entity) {
		System.out.println("LIGHT ENTITY TIME");
		if (entity instanceof Light) {
			injectLightDependencies((Light) entity);
		} else {
			throw new IllegalArgumentException("Unsupported type: "
					+ entity.getClass());
		}
	}

	private void injectLightDependencies(Light entity) {
		System.out.println("Injecting Light Dependencies");
		
	}

	public void injectDependencies(Object entity, Map<Object, Object> items) {
		System.out.println("HURAY LIGHT: injectDependencies");
		Light light = (Light) entity;
		light.setLightRepository((LightRepository)items.get("lightRepository"));
	}

}
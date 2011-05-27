package com.gs.sample.hibernatestuff;

import java.util.Map;

public interface IObjectFactory {
	void injectDependencies(Object entity);
	void injectDependencies(Object entity,Map<Object,Object> items);
}

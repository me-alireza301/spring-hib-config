package com.gs.sample.hibernatestuff;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.gs.sample.repository.CandleRepository;

@SuppressWarnings("serial")
public class ObjectFactoryHibernateInterceptor extends EmptyInterceptor
		implements ApplicationContextAware {
	
	public ObjectFactoryHibernateInterceptor() {
		super();
		factories.put("com.gs.sample.domain.Candle","candleFactory");
	}
	
	@Autowired
	CandleRepository candleRepository;
	Map<Object,Object> candleDependencyItems;
	
	@PostConstruct
	public void justAfterConstruction() {
		System.out.println("JUST AFTER CONSTRUCTION candleRepository="+candleRepository);
		System.out.println("JUST AFTER CONSTRUCTION factories="+factories);
		
		candleDependencyItems=new HashMap<Object, Object>();
		candleDependencyItems.put("candleRepository", candleRepository);
	}
	
	private Map<String, String> factories = new HashMap<String, String>();
	
	@SuppressWarnings("unused")
	private ApplicationContext applicationContext;

	@Autowired @Qualifier("objectFactoryFactories")
	public void setFactories(final Map<String, String> factories) {
		System.out.println("INJECTING factories: "+factories);
		this.factories = factories;
	}

	public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	@Override
	public boolean onSave(
			Object entity, 
			Serializable id, 
			Object[] state, 
			String[] propertyNames, 
			Type[] types) {
		System.out.println("INTERCEPTOR: Save time "+entity.getClass().getName());
		return false;
	}

	
	@Override
	public boolean onLoad(final Object entity, final Serializable id, final Object[] state,
	        final String[] propertyNames, final Type[] types) {
		
		System.out.println("INTERCEPTOR: LOAD TIME "+entity.getClass().getCanonicalName());
	    String factoryName = this.factories.get(entity.getClass().getCanonicalName());
	    System.out.println(factories);
	    if (factoryName!=null) {
	    	System.out.println("factoryName: "+factoryName);
	    	if(applicationContext!=null) {
		        IObjectFactory factory = (IObjectFactory)this.applicationContext
		            .getBean(factoryName);
		        if (factory!=null) {
		        	
		            factory.injectDependencies(entity,candleDependencyItems);
		        }
	    	}
	    }
	    return super.onLoad(entity, id, state, propertyNames, types);
	}	
}

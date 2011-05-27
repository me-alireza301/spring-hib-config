package com.gs.sample.hibernatestuff;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

public class OurLocalContainerEntityManagerFactoryBean extends LocalContainerEntityManagerFactoryBean implements BeanPostProcessor {
	ObjectFactoryHibernateInterceptor objectFactoryHibernateInterceptor;
	
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		if("objectFactoryHibernateInterceptor".equals(beanName)) {
			objectFactoryHibernateInterceptor=(ObjectFactoryHibernateInterceptor)bean;
			System.out.println("SSSSSS: objectFactoryHibernateInterceptor "+objectFactoryHibernateInterceptor);
		}
		//System.out.println(objectFactoryHibernateInterceptor+" POST PROC postProcessBeforeInitialization "+beanName);
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("POST PROC postProcessAfterInitialization "+beanName);
		if ("entityManagerFactory".equals(beanName)) {
			System.out.println("XXXXXXXXXX: entityManagerFactory " + bean);
//			getJpaPropertyMap().put("hibernate.ejb.interceptor", objectFactoryHibernateInterceptor);
		}
		System.out.println("getPersistenceProvider(): " + getPersistenceProvider());
		HibernateJpaVendorAdapter j = (HibernateJpaVendorAdapter)getJpaVendorAdapter();
		return bean;
	}

	
}

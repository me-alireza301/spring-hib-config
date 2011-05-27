package com.gs.sample.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.gs.sample.domain.other.Light;

@Repository(value="hibLightRepository")
public class HibernateLightRepository extends HibernateDaoSupport implements LightRepository {
	
	public HibernateLightRepository() {}
	
	@Autowired
	public HibernateLightRepository(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public void save(Light light) {
		getHibernateTemplate().save(light);
		
	}

	public List<Light> findAll() {
		return getHibernateTemplate().loadAll(Light.class);
	}
}

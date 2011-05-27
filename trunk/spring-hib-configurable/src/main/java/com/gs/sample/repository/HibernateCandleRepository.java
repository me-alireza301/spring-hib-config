package com.gs.sample.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.gs.sample.domain.Candle;

@Repository(value="hibCandleRepository")
public class HibernateCandleRepository extends HibernateDaoSupport implements CandleRepository {
	
	public HibernateCandleRepository() {}
	
	@Autowired
	public HibernateCandleRepository(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public void save(Candle candle) {
		getHibernateTemplate().save(candle);
		
	}

	public List<Candle> findAll() {
		return getHibernateTemplate().loadAll(Candle.class);
	}
}

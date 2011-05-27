package com.gs.sample.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gs.sample.domain.Candle;

@Repository(value="candleRepository")
public class JpaCandleRepository implements CandleRepository {
	 private EntityManager entityManager;

     @PersistenceContext
     public void setEntityManager(EntityManager entityManager) {
             this.entityManager = entityManager;
     }

     public List<Candle> findAll() {
             return entityManager.createQuery("select c from Candle c", Candle.class).getResultList();
     }

     @Transactional
     public void save(Candle candle) {
             entityManager.persist(candle);
     }

}

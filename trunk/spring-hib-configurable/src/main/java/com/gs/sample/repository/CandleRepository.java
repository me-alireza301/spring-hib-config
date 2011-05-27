package com.gs.sample.repository;

import java.util.List;

import com.gs.sample.domain.Candle;


public interface CandleRepository {

	void save(Candle candle);

	List<Candle> findAll();
}

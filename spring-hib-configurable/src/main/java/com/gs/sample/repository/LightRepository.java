package com.gs.sample.repository;

import java.util.List;

import com.gs.sample.domain.Candle;
import com.gs.sample.domain.other.Light;


public interface LightRepository {

	void save(Light light);

	List<Light> findAll();
}

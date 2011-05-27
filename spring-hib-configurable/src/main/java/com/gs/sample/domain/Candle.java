package com.gs.sample.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import com.gs.sample.repository.CandleRepository;

@Entity
@Table(name = "CANDLE")
public class Candle {

    private Long id;
    private String color;
    
    @Transient @Autowired private CandleRepository candleRepository;

	public void setCandleRepository(CandleRepository candleRepository) {
		System.out.println("SETTING CANDLE REPOSITORY: "+candleRepository);
		this.candleRepository = candleRepository;
	}

	
	@Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
            return id;
    }

    public void setId(Long id) {
            this.id = id;
    }
	
    public String getColor() {
    	return color;
    }
    
    public void setColor(String color) {
    	this.color = color;
    }

	public static Candle createCandle(String color) {
		Candle candle = new Candle();
		candle.setColor(color);
		return candle;
	}

	@Override
	public String toString() {
		return "Candle [id=" + id + ", color=" + color + "]";
	}
    
}

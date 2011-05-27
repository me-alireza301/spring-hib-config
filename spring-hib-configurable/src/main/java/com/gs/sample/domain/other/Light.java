package com.gs.sample.domain.other;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gs.sample.repository.LightRepository;


@Entity
@Table(name="THE_LIGHTS")
@Component
@Scope(value="prototype")
public class Light {
	Integer brightnessLevel;
	String manufacturer;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TABLE_NAME", unique=true, nullable=false, length=30)
	Long id;
	@Transient @Autowired private LightRepository lightRepository;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getBrightnessLevel() {
		return brightnessLevel;
	}

	public void setBrightnessLevel(Integer brightnessLevel) {
		this.brightnessLevel = brightnessLevel;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public static Light createLight(Integer brightness, String mfg) {
		Light light = new Light();
		light.setBrightnessLevel(brightness);
		light.setManufacturer(mfg);
		return light;
	}

	public void setLightRepository(LightRepository lightRepository) {
		this.lightRepository=lightRepository;
	}
	
	public void persist() {
		lightRepository.save(this);
	}
	
}

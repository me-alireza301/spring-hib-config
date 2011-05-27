package com.gs.sample.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.gs.sample.component.LegoService;

//@Configurable(dependencyCheck=true,autowire=Autowire.BY_TYPE) //,preConstruction=true
@Configurable(preConstruction=true,dependencyCheck=true)
//@Scope("prototype")
public class LegoIndianaJonesPojo implements ApplicationContextAware {

	LegoService legoService;
	ApplicationContext applicationContext;
	
	public LegoService getLegoService() {
		return legoService;
	}
	@Autowired @Required 
	public void setLegoService(LegoService _legoService) {
		System.out.println("HOO YAY "+_legoService);
		this.legoService = _legoService;
	}
	public void doYourThingIndi() {
		legoService.whipHorse();
	}
	public void doYourThingIndiInTheBizarre() {
		legoService.whipMerchant();
	}
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext=applicationContext;
		System.out.println("setApplicationContext..."+applicationContext);
		legoService = applicationContext.getBean(LegoService.class);
		
	}
}

package com.gs.sample.component.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component(value="indianaJonesAspect")
public class IndianaJonesAspect {
	@Before(value="execution(* com.gs.sample.component..whip*(..))")
	public void useWhip(JoinPoint jp) {
		String methodName=jp.getSignature().getName();
		System.out.println("WHIP THAT "+methodName.substring("whip".length()));
	}

}

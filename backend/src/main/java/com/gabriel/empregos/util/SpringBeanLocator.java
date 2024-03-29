package com.gabriel.empregos.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanLocator implements ApplicationContextAware {

	private static ApplicationContext context;
  
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		context = applicationContext;
	}
	
	public static <T> T getBean(Class<T> type) {
		return context.getBean(type);
	}
  
}

package com.nowcoder.synergy;

import com.nowcoder.synergy.dao.AlphaDao;
import com.nowcoder.synergy.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = SynergyApplication.class)
class SynergyApplicationTests implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	public SynergyApplicationTests(ApplicationContext applicationContext) {
		this.applicationContext=applicationContext;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

	}
	@Test
	public void testApplicationContext(){
		System.out.println(applicationContext);
		AlphaDao alphaDao=applicationContext.getBean(AlphaDao.class);
		System.out.println(alphaDao.select());

		alphaDao=applicationContext.getBean("alphahibernate",AlphaDao.class);
		System.out.println(alphaDao.select());
	}
	@Test
	public void testBeanManagement(){
		AlphaService alphaService=applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);
		alphaService =applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);
	}
	@Test
	public void testBeanConfig(){
		SimpleDateFormat simpleDateFormat=applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));
	}
	@Autowired
	@Qualifier("alphahibernate")
	private AlphaDao alphaDao;

	@Autowired
	private AlphaService alphaService;

	@Autowired
	private SimpleDateFormat simpleDateFormat;

	@Test
	public void testDI(){
		System.out.println(alphaDao);
		System.out.println(alphaService);
		System.out.println(simpleDateFormat);
	}
}

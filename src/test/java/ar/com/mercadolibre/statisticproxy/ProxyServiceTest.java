package ar.com.mercadolibre.statisticproxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ar.com.mercadolibre.statisticproxy.controller.StatisticsController;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProxyServiceTest {
	
	static final Logger logger = LoggerFactory.getLogger(ProxyServiceTest.class);
	
	@Autowired
	StatisticsController statisticsController;

	@Test
	void contextLoads() {
		
	}

}

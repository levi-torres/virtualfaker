package com.udea.virtualfaker;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class VirtualfakerApplicationTests {

	@Autowired
	DataController dataController;

	@Test
	void health(){
		assertEquals("health check Ok", dataController.healthCheck());
	}

	@Test
	void version(){
		assertEquals("version is 1.0.0", dataController.version());
	}

	@Test
	void nationsLength(){
		Integer nationsLength = dataController.nations().size();
		assertEquals(10, nationsLength);
	}

	@Test
	void currenciesLength(){
		Integer currenciesLength = dataController.getRandomCurrencies().size();
		assertEquals(20, currenciesLength);
	}

	@Test
	void testRandomCurrenciesCodeFormat(){
		DataController dataController = new DataController();
		JsonNode response = dataController.getRandomCurrencies();
		for (int i = 0; i < response.size(); i++) {
			JsonNode currency = response.get(i);
			String code = currency.get("code").asText();
			assertTrue(code.matches("[A-Z]{3}"));
		}
	}

	@Test
	void testRandomNationsPerformance(){
		DataController dataController = new DataController();
		long startTime = System.currentTimeMillis();
		dataController.nations();
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		System.out.println(executionTime);
		assertTrue(executionTime < 2000);
	}

	@Test
	void aviationLength(){
		Integer aviationLength = dataController.getRandomAviation().size();
		assertEquals(20, aviationLength);
	}

}

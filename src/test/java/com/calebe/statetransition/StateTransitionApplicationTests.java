package com.calebe.statetransition;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;

@SpringBootTest
class StateTransitionApplicationTests {
	private static final Logger LOGGER = Logger.getLogger(StateTransitionApplicationTests.class.getName());

	@Autowired
	private ProductService productService;


	@Test
	void testUpdateMerging() {
		LOGGER.info("Decrementing the stock value");
		productService.decrementStock(1);
		LOGGER.info("Loading product again");
		Product productAgain = productService.find(1);
		LOGGER.info("Product stock is " + productAgain.getStock());
	}

	@Test
	void testInsertMerging() {
		productService.create(3, 10);
	}

}

package com.backend.oby.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.backend.oby.entity.Products;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProductsRepositoryTest {

	@Autowired
	ProductsRepository repo;
	Products product = new Products();
	Products product2 = new Products();

	@BeforeAll
	void setUp() {
		product.setName("product1");
        product.setPrice(123);
		repo.save(product);

		product2.setName("product2");
        product2.setPrice(321);
		repo.save(product2);
	}

	@Test
	void testFindByPrice() {
		assertNotNull(product);
		assertEquals(product.getPrice(), this.product.getPrice());
		assertNotEquals(product2.getPrice(), this.product.getPrice());
	}

    @Test
    void testFindByName() {
        assertNotNull(product2);
        assertEquals(product2.getName(), this.product2.getName());
        assertNotEquals(product.getName(), product2.getName());
    }
}
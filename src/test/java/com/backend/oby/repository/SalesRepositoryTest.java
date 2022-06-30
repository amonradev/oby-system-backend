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

import com.backend.oby.entity.Sales;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SalesRepositoryTest {

	@Autowired
	SalesRepository repo;
	Sales sale = new Sales();
	Sales sale2 = new Sales();

	@BeforeAll
	void setUp() {
		sale.setId(1);
		sale.setEmail("123@teste.com");
		repo.save(sale);

		sale2.setId(2);
		sale2.setEmail("teste@123.com");
		repo.save(sale2);
	}

	@Test
	void testFindById() {
		assertNotNull(sale);
		assertEquals(sale.getId(), this.sale.getId());
		assertNotEquals(sale2.getId(), this.sale.getId());
	}

	@Test
	void testFindByEmail() {
		assertNotNull(sale2);
		assertEquals(sale2.getEmail(), this.sale2.getEmail());
		assertNotEquals(sale.getEmail(), sale2.getEmail());
	}
}
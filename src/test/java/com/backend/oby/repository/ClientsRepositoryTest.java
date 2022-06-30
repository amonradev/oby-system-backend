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

import com.backend.oby.entity.Clients;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ClientsRepositoryTest {

	@Autowired
	ClientsRepository repo;
	Clients client = new Clients();
	Clients client2 = new Clients();

	@BeforeAll
	void setUp() {
		client.setId(1);
		client.setName("Client1");
		repo.save(client);

		client2.setId(2);
		client2.setName("Client");
		repo.save(client2);
	}

	@Test
	void testFindById() {
		assertNotNull(client);
		assertEquals(client.getId(), this.client.getId());
		assertNotEquals(client2.getId(), this.client.getId());
	}

	@Test
	void testFindByName() {
		assertNotNull(client2);
		assertEquals(client2.getName(), this.client2.getName());
		assertNotEquals(client.getName(), client2.getName());
	}
}
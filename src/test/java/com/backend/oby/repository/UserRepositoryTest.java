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

import com.backend.oby.entity.User;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserRepositoryTest {

	@Autowired
	UserRepository repo;
	User user = new User();
	User user2 = new User();

	@BeforeAll
	void setUp() {
		user.setFirstName("First");
		user.setLastName("Last");
		user.setEmail("first@email.com");
		repo.save(user);

		user2.setFirstName("FirstTwo");
		user2.setLastName("LastTwo");
		user2.setEmail("two@email.com");
		repo.save(user2);
	}

	@Test
	void testFindById() {
		assertNotNull(user);
		assertEquals(user.getId(), this.user.getId());
		assertNotEquals(user2.getId(), this.user.getId());
	}

    @Test
    void testFindByFirstName() {
        assertNotNull(user2);
        assertEquals(user2.getFirstName(), this.user2.getFirstName());
        assertNotEquals(user.getFirstName(), user2.getFirstName());
    }

    @Test
    void testFindByLastName() {
        assertNotNull(user2);
        assertEquals(user2.getLastName(), this.user2.getLastName());
        assertNotEquals(user.getLastName(), user2.getLastName());
    }

    @Test
    void testFindByEmail() {
        assertNotNull(user2);
        assertEquals(user2.getEmail(), this.user2.getEmail());
        assertNotEquals(user.getEmail(), user2.getEmail());
    }
}
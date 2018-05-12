package com.skilldistillery.beardjpa.test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.skilldistillery.beardjpa.entities.Stroking;

class BeardTest {
	
	private EntityManagerFactory emf;
	private EntityManager em;

	@BeforeEach
	void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("Stroking");
		em = emf.createEntityManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		emf.close();
	}
	@Test
	@DisplayName("Test stroking entity mapping city")
	void test_stroking_entitiy_mapping_city() {
		Stroking stroke = em.find(Stroking.class, 1);
		assertEquals("Denver", stroke.getCity());
		
	}
	
	@Test
	@DisplayName("Test stroking entity mapping name")
	void test_stroking_entitiy_mapping_name() {
		Stroking stroke = em.find(Stroking.class, 2);
		assertEquals("Bob", stroke.getFirstName());
		assertEquals("Dobbs", stroke.getLastName());
		
	}

}

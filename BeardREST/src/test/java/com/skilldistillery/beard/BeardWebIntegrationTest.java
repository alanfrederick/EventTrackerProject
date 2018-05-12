package com.skilldistillery.beard;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class BeardWebIntegrationTest {

	@Test
	public void test_final_all() throws IOException {
		TestRestTemplate restTest = new TestRestTemplate();
		ResponseEntity<String> response = restTest.getForEntity("http://localhost:8080/api/strokes", String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<Stroke> strokes = mapper.readValue(response.getBody(), mapper.getTypeFactory().constructCollectionType(List.class, Stroke.class));

		assertEquals("Alan", strokes.get(0).getFirstName());
	}
	
	@Test
	public void test_find_by_id() throws IOException {
		TestRestTemplate restTest = new TestRestTemplate();
		ResponseEntity<String> response = restTest.getForEntity("http://localhost:8080/api/strokes/1", String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		
		Stroke strokes = mapper.readValue(response.getBody(), Stroke.class);
		
		assertEquals("Alan", strokes.getFirstName());
	}

}

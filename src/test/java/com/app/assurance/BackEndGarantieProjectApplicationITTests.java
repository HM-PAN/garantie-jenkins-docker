package com.app.assurance;

import com.app.assurance.dao.PGarantieRepository;
import com.app.assurance.entities.PGarantie;
import com.app.assurance.services.PGarantieService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import static org.junit.Assert.assertNotNull;
@RunWith(SpringRunner.class)
//@SpringBootTest
@SpringBootTest(classes = BackEndGarantieProjectApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BackEndGarantieProjectApplicationITTests {
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}
	@Test
	public void testGetAllGaranties() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/assurance/pgarantie/GetAll",
				HttpMethod.GET, entity, String.class);
		assertNotNull(response.getBody());
		System.out.println(response.getBody());
	}
	@Test
	public void testGetGarantieById() {
		PGarantie pgarantie = restTemplate.getForObject(getRootUrl() + "/assurance/pgarantie/GetOne/1", PGarantie.class);
		System.out.println(pgarantie.getDescription());
		assertNotNull(pgarantie);
	}

	@Test
	public void testCreateGarantie() {
		PGarantie pgarantie = new PGarantie();
		pgarantie.setIdG("2");
		pgarantie.setLabel("test2");
		pgarantie.setDescription("test2");
		pgarantie.setObligatory(false);
		pgarantie.setBase_price(200.0);
		ResponseEntity<PGarantie> postResponse = restTemplate.postForEntity(getRootUrl() + "/assurance/pgarantie/Add", pgarantie, PGarantie.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}
	@Test
	public void testDeleteGarantie() {
		String idG = "2";
		PGarantie pgarantie = restTemplate.getForObject(getRootUrl() + "/assurance/pgarantie/GetOne/" + idG, PGarantie.class);
		assertNotNull(pgarantie);
		restTemplate.delete(getRootUrl() + "/assurance/pgarantie/Delete/" + idG);
		try {
			pgarantie = restTemplate.getForObject(getRootUrl() + "/employees/" + idG, PGarantie.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}

//	@Autowired
//	private PGarantieService service;
//	@MockBean
//	private PGarantieRepository daoo;
//	@Autowired
//	MockMvc mockMvc;
//@Test
//	public void contextLoads() throws Exception{
//	MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/assurance/pgarantie/GEtAll")
//	.accept(MediaType.APPLICATION_JSON))
//			.andReturn();
//	System.out.println(mvcResult.getResponse());
//	System.out.println(mvcResult.toString());
//}



}

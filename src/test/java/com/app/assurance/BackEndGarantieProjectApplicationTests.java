package com.app.assurance;

import com.app.assurance.dao.PGarantieRepository;
import com.app.assurance.services.PGarantieService;
//import org.junit.jupiter.api.Test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.assurance.entities.PGarantie;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest
//@ContextConfiguration(classes=BackEndGarantieProjectApplication.class)
//@WebMvcTest

public class BackEndGarantieProjectApplicationTests {

	@Autowired
	private PGarantieService service;

	@MockBean
	private PGarantieRepository daoo;

	@Test
	public void getGarantiesTest() throws Exception {
		when(daoo.findAll()).thenReturn(Stream
				.of(new PGarantie("1", "test1","test1",true,100.0), new PGarantie("2", "test2","test2",true,150.0)).collect(Collectors.toList()));
		assertEquals(2, service.findAll().size());
		if (service.findAll().size() == 2){
			System.out.println("The Test Find All is OK");

		}
	}

	@Test
	public void getGarantieByIdTest() {
		PGarantie garantie = new PGarantie("2", "test2","test2",true,200.0);
		when(daoo.findById("2")).thenReturn(Optional.of(garantie));

	}

	@Test
	public void saveGarantieTest() {
		PGarantie garantie = new PGarantie("4", "test4","test4",true,200.0);
		when(daoo.save(garantie)).thenReturn(garantie);
		assertEquals(garantie, service.add(garantie));
		System.out.println("saving is Done !");
	}


	@Test
	public void deleteGarantieTest() {
		PGarantie garantie = new PGarantie("5", "test5","test5",true,200.0);
		String idG = "5";
		service.delete(idG);
		verify(daoo, times(1)).deleteById(idG);
	}
	

	
	
	

}

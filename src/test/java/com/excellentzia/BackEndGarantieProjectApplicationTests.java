package com.excellentzia;

import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.excellentzia.BackEndGarantieProjectApplication;
import com.excellentzia.models.PGarantie;
import com.excellentzia.repository.IPGarantieDao;
import com.excellentzia.services.impl.PGarantieServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
//@RunWith(MockitoJUnitRunner.class)
//@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes = SpringRunner.class)
@RunWith(SpringRunner.class)

@SpringBootTest
//(classes = BackEndGarantieProjectApplication.class)
class BackEndGarantieProjectApplicationTests {
	//@Test
//	void contextLoads() {
	//}
	@Autowired
	private PGarantieServiceImpl service;
	
	@MockBean
	private IPGarantieDao daoo;
	
	@Test
	public void getGarantiesTest() {
		when(daoo.findAll()).thenReturn(Stream
				.of(new PGarantie("1", "test1","test1",true,100.0), new PGarantie("2", "test2","test2",true,150.0)).collect(Collectors.toList()));
		assertEquals(2, service.findAll().size());
	}
	
	/*@Test
	public void getGarantieByIdTest() {
		//PGarantie garantie = new PGarantie("2", "test2","test2",true,200.0);
		String idG = "2";
		when(daoo.findById(idG)).thenReturn(Stream
				.of(new PGarantie("1", "test1","test1",true,100.0)).collect(Collectors.toList()));

	}*/
	
	@Test
	public void saveGarantieTest() {
		PGarantie garantie = new PGarantie("4", "test4","test4",true,200.0);
		when(daoo.save(garantie)).thenReturn(garantie);
		assertEquals(garantie, service.add(garantie));
	}
	
	
	@Test
	public void deleteGarantieTest() {
		PGarantie garantie = new PGarantie("5", "test5","test5",true,200.0);
		String idG = "5";
		service.delete(idG);
		service.delete(idG);
		verify(daoo, times(1)).deleteById(idG);
	}
	
	
	
	
	

}
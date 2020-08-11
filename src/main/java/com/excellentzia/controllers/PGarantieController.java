package com.excellentzia.controllers;

import java.util.List;
import java.util.Optional;

import com.excellentzia.services.PGarantieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.excellentzia.exception.ApiRequestException;
import com.excellentzia.entities.PGarantie;

@RestController
@RequestMapping("assurance/pgarantie/")
@CrossOrigin
public class PGarantieController {
 @Autowired
 private PGarantieService service;
 
 @RequestMapping(value ="/GetAll", method = RequestMethod.GET)
 List<PGarantie> GetAll() {
	 if(service.counter()==0 ) {
		 throw new ApiRequestException("Ops there is no Garanties !!");	 
	 }
	return service.findAll();
	
 }
 @RequestMapping(value = "/Add", method = RequestMethod.POST)
 PGarantie Add(@RequestBody PGarantie t) {
		 return service.add(t);
 }
 
 @RequestMapping(value = "/Update/{id}", method = RequestMethod.PUT)
 PGarantie Update(@RequestBody PGarantie t,@PathVariable String id) {
	 if(!service.exists(id)) {
		 throw new ApiRequestException("Garantie Don't Exists !");
		 
	 }
	 return service.update(t);
	 
	 
 }
 @RequestMapping(value = "/GetOne/{id}", method = RequestMethod.GET)
 Optional<PGarantie> getOne(@PathVariable String id) {
	 if (service.exists(id)) {
		 return service.getOne(id);
	 }
	 throw new ApiRequestException("Garantie Don't Exists !");
	 
	
 }
 @RequestMapping(value = "/Delete/{id}", method = RequestMethod.DELETE)
 void Delete(@PathVariable String id) {
	 if (!service.exists(id)) {
		 throw new ApiRequestException("Garantie Don't Exists !");
		 	 }
	 service.delete(id);
	 throw new ApiRequestException("Garantie Deleted !");
	
	 
 }


	

	
	
	
}

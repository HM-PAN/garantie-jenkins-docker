package com.app.assurance.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;




@ControllerAdvice
public class ApiExceptionHandler {
	@ExceptionHandler(value = {ApiRequestException.class})
	public ResponseEntity<Object> handleApiRequestException(ApiRequestException e ){
		//Payload containing Exception details
		HttpStatus badRequest = HttpStatus.OK;
		ApiException apiException = new ApiException(
			e.getMessage(),
			badRequest,
			ZonedDateTime.now(ZoneId.of("Z"))
				);
		//Return Response Entity
		return new ResponseEntity<>(apiException , badRequest );
	}
}

package com.onursir.rentACar;

import com.onursir.rentACar.Core.utilites.BusinessException;
import com.onursir.rentACar.Core.utilites.ProblemDetails;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@SpringBootApplication
@RestControllerAdvice //hata yakalamak için
public class RentACarApplication   {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException){

		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		return problemDetails;
	}

	@Bean // model mappar IOC'de constructor'a ihtiyac duyar bu yüzden  burda oluşturduk.
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}




}

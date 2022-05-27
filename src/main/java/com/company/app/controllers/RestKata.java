package com.company.app.controllers;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestKata {

	
	@GetMapping("/sums")
	public ResponseEntity<Integer> params(){
		Optional<Integer> max = Stream.of(1,1,3,3,6,-6,-4,-3).filter(e->e>0).reduce(Integer::max);
		Optional<Integer> min = Stream.of(1,1,3,3,6,-8,-4,-3).filter(e->e<0).reduce(Integer::min);
		return new ResponseEntity(max.get().equals(Math.abs(min.get())), HttpStatus.OK);
	}
}

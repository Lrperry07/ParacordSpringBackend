package com.claim.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.claim.entity.User;
import com.claim.repository.UserRepository;


@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value="/submitUserDetails",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.POST)
	
	public void signUp(@RequestBody User user) {
		this.userRepository.save(user);
	}
	//Find user email
	@RequestMapping(value="/findUserById",
			produces=MediaType.APPLICATION_JSON_VALUE,
			method= RequestMethod.GET)                 

	@ResponseBody
	private ResponseEntity<Optional<User>> finduser(String email){
		return new ResponseEntity<>(userRepository.findById(email), HttpStatus.OK);
	}

	//Show List of all users
	@RequestMapping(value="/listuser",
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.GET)

	@ResponseBody
	private ResponseEntity<List<User>> listUser(){

		return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
	}
	//Password Input
	@RequestMapping(value="/loginuser", 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.POST)

	 @ResponseBody
	 private ResponseEntity<Optional<User>>loginuser(@RequestBody User userInput){
		 Optional<User>user =userRepository.findById(userInput.getEmail());
		 if(user.isPresent()) {

			 if(user.get().getPassword().contentEquals(userInput.getPassword())) {
				 return new ResponseEntity<>(user, HttpStatus.OK);
			 }
			 else 
				 return new ResponseEntity<>(user, HttpStatus.UNAUTHORIZED);
		 }
		 else 
			 return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
	 }

	 //user Controller - login

	 @RequestMapping(value ="/login",
			 produces = MediaType.APPLICATION_JSON_VALUE,
			 consumes = MediaType.APPLICATION_JSON_VALUE,
			 method = RequestMethod.POST)

	 @ResponseBody
	 public ResponseEntity<Optional<User>> login(@RequestBody User user) {
		 Optional<User> dbRecord = userRepository.findById(user.getEmail());

		 if(dbRecord.isPresent() && dbRecord.get().getPassword().equals(user.getPassword()) ) 
		 {
			 return new ResponseEntity<>(dbRecord, HttpStatus.OK);
		 }
		 return new ResponseEntity<>( HttpStatus.UNAUTHORIZED);
	 }

	 //user Controller - find all
	 @RequestMapping(value ="/findAll",
			 produces = MediaType.APPLICATION_JSON_VALUE,
			 method = RequestMethod.GET)

	 @ResponseBody
	 public ResponseEntity<List<User>> findAll() {
		 return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
	 }

	 
	 
	

}

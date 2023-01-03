package com.spring.jpa.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.cj.x.protobuf.MysqlxCrud.Update;
import com.spring.jpa.entity.User;
import com.spring.jpa.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService ;
	
	@PostMapping(value = "/create")
	public ResponseEntity<User>createUser(@RequestBody User user){
		
		user.setJoindate(LocalDateTime.now());

		userService.saveUser(user);
		return ResponseEntity.ok(user);
	}
	   @GetMapping(value = "/getall")	
		public List<User> getAllUsers(){
			return userService.getAll();
		}
	  
	   @GetMapping(value = "getById/{id}")
	   public User getById(@PathVariable("id") UUID id){
		   Optional<User> userOptional = userService.getByID(id);
		return userOptional.get();
		   
	   }
	   @PutMapping("/update")
	   public ResponseEntity <User>updateUser(@RequestBody User user ){
		   
		  userService.updateUser(user);
		  return ResponseEntity.ok(user);
		   
	   }
	   
	   @DeleteMapping("/delete/{id}")
	   public ResponseEntity<User>delete(@PathVariable("id") UUID id){
		
			userService.delete(id);
			return ResponseEntity.ok(null);
		}
		   
	   
	   
	   
	   
	   
	   
	   
	   
		
}

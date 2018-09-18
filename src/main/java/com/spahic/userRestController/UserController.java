package com.spahic.userRestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spahic.entity.User;
import com.spahic.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/list")
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@GetMapping("/user/{userId}")
	public User getUser(@PathVariable int userId) {
		
		User theUser = userService.getUser(userId);
		
		if(theUser == null) {
			throw new UserNotFoundException("User id not found" + userId);
		}
		
		return theUser;
	}
	
	@PostMapping("/callForSave")
	public User addUser(@RequestBody User theUser) {
		
		theUser.setUserId(0);
		
		userService.saveUser(theUser);
		
		return theUser;
	}
	
	@PutMapping("/callForUpdate")
	public ResponseEntity<User> updateUser(@RequestBody User theUser) {
		
		User currentUser = userService.getUser(theUser.getUserId());
		
		if (currentUser==null) {
            System.out.println("User with id " + theUser.getUserId() + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
		
		userService.saveUser(theUser);
		
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{userId}")
	public User deleteUser(@PathVariable int userId) {
		
		User theUser = userService.getUser(userId);
		System.out.println(theUser);
		if(theUser == null) {
			throw new UserNotFoundException("User id not found " + userId);
		}
		
		userService.deleteUser(userId);
		
		
		return theUser;
	}

}

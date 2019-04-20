/**
 * 
 */
package com.budgetplanner.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.budgetplanner.domain.UserDomain;
import com.budgetplanner.event.UserDetailsEvent;
import com.budgetplanner.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Pradeep
 *
 */
@Api(value = "Controller")
@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/a")
	public String home() {
		return "Spring REST";
	}

	@ApiOperation(value = "Get list of Users in the System ")
	@GetMapping("/allusers")
	public List<UserDomain> all() {

		List<UserDomain> userDomainList = new ArrayList<UserDomain>();

		for (UserDetailsEvent userDetails : userService.list()) {
			UserDomain userDomain = new UserDomain();
			BeanUtils.copyProperties(userDetails,userDomain );
			userDomainList.add(userDomain);
		}
		
		return userDomainList;
	}

	@ApiOperation(value = "Create Users in the System ")	
	@PostMapping("/user")
	public UserDomain create(@RequestBody UserDomain userDomain) {
		UserDomain userDomainDetails = new UserDomain();
		UserDetailsEvent userDetailsEvent = userService.create(userDomain); 
		BeanUtils.copyProperties(userDetailsEvent ,userDomainDetails);
		return userDomainDetails;
	}

	@ApiOperation(value = "Get User for id in the System ")
	@GetMapping("/user/{id}")
	public UserDomain get(@PathVariable Long id) {
		
		UserDomain userDomain = new UserDomain();
		BeanUtils.copyProperties(userService.get(id), userDomain);
		return userDomain;

	}

	@ApiOperation(value = "Update User for id in the System ")
	@PutMapping("/user/{id}")
	public UserDomain update(@RequestBody UserDomain userDomain, @PathVariable Long id) {
		UserDomain userDomainDetails = new UserDomain();
		UserDetailsEvent userDetailsEvent = userService.update(userDomain, id);
		BeanUtils.copyProperties(userDetailsEvent, userDomainDetails);
		return userDomainDetails;
	}

	
	@ApiOperation(value = "Delete User for given id in the System ")
	@DeleteMapping("/user/{id}")
	public void delete(@PathVariable Long id) {
		userService.delete(id);
	}
	
	@ApiOperation(value = "Login validation for the user")
	@GetMapping("/user/{userName}/{password}")
	//Add exception
	public String userLogIn(@PathVariable String userName, @PathVariable String password ) {
		
		String response = userService.userLogIn(userName,password);
		return response;
		
	}
}

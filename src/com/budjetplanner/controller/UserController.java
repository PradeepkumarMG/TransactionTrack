/**
 * 
 */
package com.budjetplanner.controller;

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

import com.budjetplanner.domain.UserDomain;
import com.budjetplanner.event.UserDetailsEvent;
import com.budjetplanner.service.UserService;

/**
 * @author Pradeep
 *
 */
@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/")
	public String home() {
		return "Spring REST";
	}

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

	@PostMapping("/user")
	public UserDomain create(@RequestBody UserDomain userDomain) {
		UserDomain userDomainDetails = new UserDomain();
		UserDetailsEvent userDetailsEvent = userService.create(userDomain); 
		BeanUtils.copyProperties(userDetailsEvent ,userDomainDetails);
		return userDomainDetails;
	}

	@GetMapping("/user/{id}")
	public UserDomain get(@PathVariable Long id) {
		
		UserDomain userDomain = new UserDomain();
		BeanUtils.copyProperties(userService.get(id), userDomain);
		return userDomain;

	}

	@PutMapping("/user/{id}")
	public UserDomain update(@RequestBody UserDomain userDomain, @PathVariable Long id) {
		UserDomain userDomainDetails = new UserDomain();
		UserDetailsEvent userDetailsEvent = userService.update(userDomain, id);
		BeanUtils.copyProperties(userDetailsEvent, userDomainDetails);
		return userDomainDetails;
	}

	@DeleteMapping("/user/{id}")
	public void delete(@PathVariable Long id) {
		userService.delete(id);
	}
}

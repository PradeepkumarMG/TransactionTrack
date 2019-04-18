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

import com.budjetplanner.entity.UserDetails;
import com.budjetplanner.event.UserDetailsEvent;
import com.budjetplanner.service.UserService;

/**
 * @author Pradeep
 *
 */
@RestController
public class UserController {

	@Autowired
	UserService messageService;

	@Autowired
	UserDetailsEvent userDetailsEvent;

	@GetMapping("/")
	public String home() {
		return "Spring REST";
	}

	@GetMapping("/messages")
	public List<UserDetailsEvent> all() {

		List<UserDetailsEvent> messageEventList = new ArrayList<UserDetailsEvent>();

		for (UserDetails userDetails : messageService.list()) {
			UserDetailsEvent userDetailsEvent = new UserDetailsEvent();
			BeanUtils.copyProperties(userDetails, userDetailsEvent);
			messageEventList.add(userDetailsEvent);
		}
		
		return messageEventList;
	}

	@PostMapping("/message")
	public UserDetailsEvent create(@RequestBody UserDetails userDetails) {

		BeanUtils.copyProperties(messageService.create(userDetails), userDetailsEvent);
		return userDetailsEvent;
	}

	@GetMapping("/message/{id}")
	public UserDetailsEvent get(@PathVariable Long id) {

		BeanUtils.copyProperties(messageService.get(id), userDetailsEvent);
		return userDetailsEvent;

	}

	@PutMapping("/message/{id}")
	public UserDetailsEvent update(@RequestBody UserDetails userDetails, @PathVariable Long id) {

		BeanUtils.copyProperties(messageService.update(userDetails, id), userDetailsEvent);
		return userDetailsEvent;
	}

	@DeleteMapping("/message/{id}")
	public void delete(@PathVariable Long id) {
		messageService.delete(id);
	}
}

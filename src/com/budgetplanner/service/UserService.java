/**
 * 
 */
package com.budgetplanner.service;

import java.util.List;

import com.budgetplanner.domain.UserDomain;
import com.budgetplanner.event.UserDetailsEvent;

/**
 * @author Pradeep
 *
 */
public interface UserService {
	
	public UserDetailsEvent create(UserDomain userDomain);
	public UserDetailsEvent get(Long id);
	public List<UserDetailsEvent> list();
	public UserDetailsEvent update(UserDomain userDomain, Long id);
	public void delete(Long id);
	public String userLogIn(String userName, String password);
}

/**
 * 
 */
package com.budjetplanner.service;

import java.util.List;

import com.budjetplanner.domain.UserDomain;
import com.budjetplanner.event.UserDetailsEvent;

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
}

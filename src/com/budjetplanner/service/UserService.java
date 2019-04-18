/**
 * 
 */
package com.budjetplanner.service;

import java.util.List;

import com.budjetplanner.entity.UserDetails;

/**
 * @author Pradeep
 *
 */
public interface UserService {
	
	UserDetails create(UserDetails userDetails);
	UserDetails get(Long id);
	List<UserDetails> list();
	UserDetails update(UserDetails userDetails, Long id);
	void delete(Long id);
}

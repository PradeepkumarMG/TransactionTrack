/**
 * 
 */
package com.budjetplanner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budjetplanner.entity.UserDetails;
import com.budjetplanner.repository.UserDetailsRepository;

/**
 * @author Pradeep
 *
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDetailsRepository userDetailsRepository;
	

	@Override
	public UserDetails get(Long id) {
		return userDetailsRepository.findOne(id);
	}

	@Override
	public UserDetails update(UserDetails userDetails, Long id) {
		return userDetailsRepository.save(userDetails);
	}

	@Override
	public void delete(Long id) {
		userDetailsRepository.delete(id);
	}

	@Override
	public List<UserDetails> list() {
		return (List<UserDetails>) userDetailsRepository.findAllByOrderByDateDesc();
	}

	@Override
	public UserDetails create(UserDetails userDetails) {
		// TODO Auto-generated method stub
		return null;
	}
}

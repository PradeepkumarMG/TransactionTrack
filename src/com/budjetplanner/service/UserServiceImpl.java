/**
 * 
 */
package com.budjetplanner.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.budjetplanner.domain.UserDomain;
import com.budjetplanner.entity.UserDetails;
import com.budjetplanner.event.UserDetailsEvent;
import com.budjetplanner.repository.UserDetailsRepository;

/**
 * @author Pradeep
 *
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDetailsRepository userRepo;

	@Override
	public UserDetailsEvent create(UserDomain userDomain) {
		UserDetails userEntity = new UserDetails();
		BeanUtils.copyProperties(userDomain, userEntity);
		UserDetailsEvent userDetailsEvent = new UserDetailsEvent();
		if(userRepo.save(userEntity) != null) {
		BeanUtils.copyProperties(userEntity, userDetailsEvent);
		}
		return userDetailsEvent;
	}

	@Override
	public UserDetailsEvent get(Long id) {
		UserDetails userEntity = userRepo.findOne(id);
		UserDetailsEvent userDetailsEvent = new UserDetailsEvent();
		if(userEntity != null) {
		BeanUtils.copyProperties(userEntity, userDetailsEvent);
		}
		return userDetailsEvent;
	}

	@Override
	public List<UserDetailsEvent> list() {
		List<UserDetails> userEntityList = userRepo.findAll();
		List<UserDetailsEvent> userEventList = new ArrayList<>();
		if(!CollectionUtils.isEmpty(userEntityList)) {
		for(UserDetails userDetails : userEntityList) {
			UserDetailsEvent userDetailsEvent = new UserDetailsEvent();
			BeanUtils.copyProperties(userDetails, userDetailsEvent);
			userEventList.add(userDetailsEvent);		
		}
		}
		return userEventList;
		
	}

	@Override
	public UserDetailsEvent update(UserDomain userDomain, Long id) {
		UserDetails userEntity = userRepo.findOne(id);

		UserDetailsEvent userDetailsEvent = new UserDetailsEvent();
		if(userEntity != null) {
			if(userDomain.getPassword()!= null && ! (userDomain.getPassword().equals(userEntity.getPassword()))) {
		BeanUtils.copyProperties(userDomain, userEntity);
		if(userRepo.save(userEntity) != null) {
		BeanUtils.copyProperties(userEntity, userDetailsEvent);
		}}}
		return userDetailsEvent;
	}

	@Override
	public void delete(Long id) {
		userRepo.delete(id);	
	}
}

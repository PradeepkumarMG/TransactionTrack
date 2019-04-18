/**
 * 
 */
package com.budjetplanner.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.budjetplanner.entity.UserDetails;

/**
 * @author Pradeep
 *
 */
public interface UserDetailsRepository extends CrudRepository<UserDetails, Long> {
	
	List<UserDetails> findAllByOrderByDateDesc();

}

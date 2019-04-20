/**
 * 
 */
package com.budgetplanner.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.budgetplanner.entity.UserDetails;

/**
 * @author Pradeep
 *
 */
public interface UserDetailsRepository extends CrudRepository<UserDetails, Long> {
	
	List<UserDetails> findAll();

	UserDetails findByUserName(String userName);

}

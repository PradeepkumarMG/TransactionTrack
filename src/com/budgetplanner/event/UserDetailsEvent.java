/**
 * 
 */
package com.budgetplanner.event;


/**
 * @author Pradeep
 *
 */
public class UserDetailsEvent {

	public Long id;
	public String userName;
	
	
	public UserDetailsEvent() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}

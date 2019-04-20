/**
 * 
 */
package com.budgetplanner.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Pradeep
 *
 */
@Entity
@Table(name = "BDGT_PLAN_DTLS")
public class BudgetPlanDetails {
	
	@Id
	@GeneratedValue
	private int id;
	
	private boolean registration;
	
	private String dailyLimit;
	
	@OneToOne
	@JoinColumn(name="ACCOUNT_ID" , referencedColumnName = "ID")
	private AccountDetails accountDtls;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the registration
	 */
	public boolean isRegistration() {
		return registration;
	}

	/**
	 * @param registration the registration to set
	 */
	public void setRegistration(boolean registration) {
		this.registration = registration;
	}

	/**
	 * @return the dailyLimit
	 */
	public String getDailyLimit() {
		return dailyLimit;
	}

	/**
	 * @param dailyLimit the dailyLimit to set
	 */
	public void setDailyLimit(String dailyLimit) {
		this.dailyLimit = dailyLimit;
	}
	


}

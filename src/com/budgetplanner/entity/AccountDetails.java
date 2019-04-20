/**
 * 
 */
package com.budgetplanner.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Pradeep
 *
 */
@Entity
@Table(name = "ACCT_DTLS")
public class AccountDetails {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String accountNumber;
	private String accountType;
	private String balance;
	
	@ManyToOne
    private UserDetails user;
	
	@OneToOne
	@JoinColumn(name="BUDGET_ID" , referencedColumnName = "ID")
	private BudgetPlanDetails bdgtDtls;
	
	@OneToOne
	@JoinColumn(name="TRANSACTION_ID" , referencedColumnName = "ID")
	private TransactionDetails transactionDtls;

	
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
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}
	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	/**
	 * @return the balance
	 */
	public String getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(String balance) {
		this.balance = balance;
	}
	
	
	
}
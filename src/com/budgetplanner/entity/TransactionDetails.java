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
 * @author Sriram
 *
 */
@Entity
@Table(name = "ACCT_DTLS")
public class TransactionDetails {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String transactionNumber;
	
	private String transferredAmnt;
	
	private String toAccount;
	
	private String transferDate;
	
	private String budgetBalance;
	
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
	 * @return the transactionNumber
	 */
	public String getTransactionNumber() {
		return transactionNumber;
	}

	/**
	 * @param transactionNumber the transactionNumber to set
	 */
	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	/**
	 * @return the transferredAmnt
	 */
	public String getTransferredAmnt() {
		return transferredAmnt;
	}

	/**
	 * @param transferredAmnt the transferredAmnt to set
	 */
	public void setTransferredAmnt(String transferredAmnt) {
		this.transferredAmnt = transferredAmnt;
	}

	/**
	 * @return the toAccount
	 */
	public String getToAccount() {
		return toAccount;
	}

	/**
	 * @param toAccount the toAccount to set
	 */
	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	/**
	 * @return the transferDate
	 */
	public String getTransferDate() {
		return transferDate;
	}

	/**
	 * @param transferDate the transferDate to set
	 */
	public void setTransferDate(String transferDate) {
		this.transferDate = transferDate;
	}

	/**
	 * @return the budgetBalance
	 */
	public String getBudgetBalance() {
		return budgetBalance;
	}

	/**
	 * @param budgetBalance the budgetBalance to set
	 */
	public void setBudgetBalance(String budgetBalance) {
		this.budgetBalance = budgetBalance;
	}
	
	
	
	

}

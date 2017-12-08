package com.shivashankaripearlapt.details.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class MemberPaymentDetails {
	
	@Id
	private String blockNumber;
	private Date paymentDate;
	private String transactionalNumber;
	private long amountPaid;
	private long dueAmount;
	public String getBlockNumber() {
		return blockNumber;
	}
	public void setBlockNumber(String blockNumber) {
		this.blockNumber = blockNumber;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getTransactionalNumber() {
		return transactionalNumber;
	}
	public void setTransactionalNumber(String transactionalNumber) {
		this.transactionalNumber = transactionalNumber;
	}
	public long getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(long amountPaid) {
		this.amountPaid = amountPaid;
	}
	public long getDueAmount() {
		return dueAmount;
	}
	public void setDueAmount(long dueAmount) {
		this.dueAmount = dueAmount;
	}
	
	
	
	

}

package dev.sherpa.entities;

public class Reimbursement {

	private int rId;
	private int amount;
	private String decsription;
	private int requesterId; 
	private String status;
	
	
	
	public Reimbursement() {
		super();
	}



	public Reimbursement(int rId, int amount, String decsription, int requesterId, String status) {
		super();
		this.rId = rId;
		this.amount = amount;
		this.decsription = decsription;
		this.requesterId = requesterId;
		this.status = status;
	}

	

	public int getrId() {
		return rId;
	}



	public void setrId(int rId) {
		this.rId = rId;
	}



	public int getAmount() {
		return amount;
	}



	public void setAmount(int amount) {
		this.amount = amount;
	}



	public String getDecsription() {
		return decsription;
	}



	public void setDecsription(String decsription) {
		this.decsription = decsription;
	}



	public int getRequesterId() {
		return requesterId;
	}



	public void setRequesterId(int requesterId) {
		this.requesterId = requesterId;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "Reimbursement [rId=" + rId + ", amount=" + amount + ", decsription=" + decsription + ", requesterId="
				+ requesterId + ", status=" + status + "]";
	}

}

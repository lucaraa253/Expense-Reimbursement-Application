package com.training.ers.models;

import java.util.Objects;

public class Request {
	private int id;
	private String description;
	private int amount;
	private boolean approved;
	private int reqId;
	
	public Request(int id, String description, int amount, boolean approved, int reqId) {
		super();
		this.id = id;
		this.description = description;
		this.amount = amount;
		this.approved = approved;
		this.reqId = reqId;
	}
	
	public Request(String description, int amount) {
		super();
		this.description = description;
		this.amount = amount;
		
	}
	public Request() {
		super();
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, approved, description, id, reqId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		return amount == other.amount && approved == other.approved && Objects.equals(description, other.description)
				&& id == other.id && reqId == other.reqId;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", description=" + description + ", amount=" + amount + ", approved=" + approved
				+ ", reqId=" + reqId + "]";
	}
	
	
}

package com.revature.model;

import java.sql.Timestamp;
import java.util.Arrays;

public class Reimbursement {
	private String id;
	private double amount;
	private Timestamp submitted;
	private Timestamp resolved;
	private String desc;
	private byte[] recipt;
	private String author;
	private String resolver;
	private double statusId;
	private double typeId;
	private String type;
	private String status;

	public Reimbursement() {
	}

	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted1(Timestamp submitted) {
		this.submitted = submitted;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved1(Timestamp resolved) {
		this.resolved = resolved;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public byte[] getRecipt() {
		return recipt;
	}

	public void setRecipt(byte[] recipt) {
		this.recipt = recipt;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getResolver() {
		return resolver;
	}

	public void setResolver(String resolver) {
		this.resolver = resolver;
	}

	public double getStatusId() {
		return statusId;
	}

	public void setStatusId(double statusId) {
		this.statusId = statusId;
	}

	public double getTypeId() {
		return typeId;
	}

	public void setTypeId(double typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/*
	 * public Reimbursement(String id, double amount, Timestamp submitted, Timestamp
	 * resolved, String desc, byte[] recipt, double author, double resolver, double
	 * statusId, double typeId, String type, String status) { super(); this.id = id;
	 * this.amount = amount; this.submitted = submitted; this.resolved = resolved;
	 * this.desc = desc; this.recipt = recipt; this.author = author; this.resolver =
	 * resolver; this.statusId = statusId; this.typeId = typeId; this.type = type;
	 * this.status = status; }
	 */

	public Reimbursement(String id, double amount, Timestamp submitted, Timestamp resolved, String desc, byte[] recipt,
			String author, String resolver, double statusId, double typeId) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.desc = desc;
		this.recipt = recipt;
		this.author = author;
		this.resolver = resolver;
		this.statusId = statusId;
		this.typeId = typeId;
	}

	public Reimbursement(String id, double amount, Timestamp submitted, Timestamp resolved, String desc, byte[] recipt,
			String author, String resolver, double statusId, double typeId, String type, String status) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.desc = desc;
		this.recipt = recipt;
		this.author = author;
		this.resolver = resolver;
		this.statusId = statusId;
		this.typeId = typeId;
		this.type = type;
		this.status = status;
	}

	public Reimbursement(String id) {
		super();
		this.id = id;
	}

	public Reimbursement(double amount, String desc, String author, double typeId) {
		super();
		this.amount = amount;
		this.desc = desc;
		this.author = author;
		this.typeId = typeId;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", desc=" + desc + ", recipt=" + Arrays.toString(recipt) + ", author=" + author + ", resolver="
				+ resolver + ", statusId=" + statusId + ", typeId=" + typeId + ", type=" + type + ", status=" + status
				+ "]";
	}

}

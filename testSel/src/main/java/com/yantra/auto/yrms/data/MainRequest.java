package com.yantra.auto.yrms.data;

import java.util.ArrayList;

public class MainRequest {
	private MAccountHolder mAccountHolder;

	public MAccountHolder getMAccountHolder() {
		return this.mAccountHolder;
	}

	public void setMAccountHolder(MAccountHolder mAccountHolder) {
		this.mAccountHolder = mAccountHolder;
	}

	private MAccount mAccount;

	public MAccount getMAccount() {
		return this.mAccount;
	}

	public void setMAccount(MAccount mAccount) {
		this.mAccount = mAccount;
	}

	private MachineFingerPrint machineFingerPrint;

	public MachineFingerPrint getMachineFingerPrint() {
		return this.machineFingerPrint;
	}

	public void setMachineFingerPrint(MachineFingerPrint machineFingerPrint) {
		this.machineFingerPrint = machineFingerPrint;
	}

	private String transactionDateTime;

	public String getTransactionDateTime() {
		return this.transactionDateTime;
	}

	public void setTransactionDateTime(String date) {
		this.transactionDateTime = date;
	}

	private String transactionNumber;

	public String getTransactionNumber() {
		return this.transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	private String transactionType;

	public String getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	private String transactionCode;

	public String getTransactionCode() {
		return this.transactionCode;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	private String geoLocation;

	public String getGeoLocation() {
		return this.geoLocation;
	}

	public void setGeoLocation(String geoLocation) {
		this.geoLocation = geoLocation;
	}

	private String terminal;

	public String getTerminal() {
		return this.terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	private ArrayList<ReqList> reqList;

	public ArrayList<ReqList> getReqList() {
		return this.reqList;
	}

	public void setReqList(ArrayList<ReqList> reqList) {
		this.reqList = reqList;
	}
}
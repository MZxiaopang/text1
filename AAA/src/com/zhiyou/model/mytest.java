package com.zhiyou.model;

public class mytest {
	private Integer ID;
	private String SEX;
	private String USERNAME;
	private String PASSWORD;

	@Override
	public String toString() {
		return "mytest [ID=" + ID + ", SEX=" + SEX + ", USERNAME=" + USERNAME + ", PASSWORD=" + PASSWORD + "]";
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getSEX() {
		return SEX;
	}

	public void setSEX(String sEX) {
		SEX = sEX;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public mytest(Integer iD, String sEX, String uSERNAME, String pASSWORD) {
		super();
		ID = iD;
		SEX = sEX;
		USERNAME = uSERNAME;
		PASSWORD = pASSWORD;
	}

	public mytest(String sEX, String uSERNAME, String pASSWORD) {
		super();
		SEX = sEX;
		USERNAME = uSERNAME;
		PASSWORD = pASSWORD;
	}

	public mytest() {
		super();
	}

}

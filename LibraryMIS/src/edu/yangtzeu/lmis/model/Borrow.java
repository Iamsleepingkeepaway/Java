package edu.yangtzeu.lmis.model;

import java.sql.Date;

public class Borrow extends AbstractModel  {
	private long BorrowID;
	private int rdID;
	private int bkID;
	private String bkName;
	private int ldContinueTimes;
	private Date ldDateOut;
	private Date ldDateRetPlan;
	private Date ldDateRetAct;
	private int ldOverDay;
	private float ldOverMoney;
	private float ldPunishMoney;
	private boolean lsHasReturn;
	private String OperatorLend;
	private String OperatorRet;
	public long getBorrowID() {
		return BorrowID;
	}
	public void setBorrowID(long borrowID) {
		BorrowID = borrowID;
	}
	public int getRdID() {
		return rdID;
	}
	public void setRdID(int rdID) {
		this.rdID = rdID;
	}
	public int getBkID() {
		return bkID;
	}
	public void setBkID(int bkID) {
		this.bkID = bkID;
	}
	public String getBkName() {
		return bkName;
	}
	public void setBkName(String bkName) {
		this.bkName = bkName;
	}
	public int getLdContinueTimes() {
		return ldContinueTimes;
	}
	public void setLdContinueTimes(int ldContinueTimes) {
		this.ldContinueTimes = ldContinueTimes;
	}
	public Date getLdDateOut() {
		return ldDateOut;
	}
	public void setLdDateOut(Date ldDateOut) {
		this.ldDateOut = ldDateOut;
	}
	public Date getLdDateRetPlan() {
		return ldDateRetPlan;
	}
	public void setLdDateRetPlan(Date ldDateRetPlan) {
		this.ldDateRetPlan = ldDateRetPlan;
	}
	public Date getLdDateRetAct() {
		return ldDateRetAct;
	}
	public void setLdDateRetAct(Date ldDateRetAct) {
		this.ldDateRetAct = ldDateRetAct;
	}
	public int getLdOverDay() {
		return ldOverDay;
	}
	public void setLdOverDay(int ldOverDay) {
		this.ldOverDay = ldOverDay;
	}
	public float getLdOverMoney() {
		return ldOverMoney;
	}
	public void setLdOverMoney(float ldOverMoney) {
		this.ldOverMoney = ldOverMoney;
	}
	public float getLdPunishMoney() {
		return ldPunishMoney;
	}
	public void setLdPunishMoney(float ldPunishMoney) {
		this.ldPunishMoney = ldPunishMoney;
	}
	public boolean isLsHasReturn() {
		return lsHasReturn;
	}
	public void setLsHasReturn(boolean lsHasReturn) {
		this.lsHasReturn = lsHasReturn;
	}
	public String getOperatorLend() {
		return OperatorLend;
	}
	public void setOperatorLend(String operatorLend) {
		this.OperatorLend = operatorLend;
	}
	public String getOperatorRet() {
		return OperatorRet;
	}
	public void setOperatorRet(String operatorRet) {
		this.OperatorRet = operatorRet;
	}
	public Borrow() {
	}
	public Borrow(Borrow b) {
		setBorrowID(b.getBorrowID());
		setRdID(b.getRdID());
		setBkID(b.getBkID());
		setBkName(b.getBkName());
		setLdContinueTimes(b.getLdContinueTimes( ));
		setLdDateOut(b.getLdDateOut( ));
		setLdDateRetPlan(b.getLdDateRetPlan());
		setLdDateRetAct(b.getLdDateRetAct());
		setLdOverDay(b.getLdOverDay( ));
		setLdPunishMoney(b.getLdPunishMoney());
		setLdOverMoney(b.getLdOverMoney( ));
		setLsHasReturn(b.isLsHasReturn() );
		setOperatorLend(b.getOperatorLend());
		setOperatorRet(b.getOperatorRet());
		}
	
	

}

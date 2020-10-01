package com.telecom.customerdatamanagement.Customer;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.Table;
import javax.validation.constraints.Size;
@Entity
public class Subscriber {
	
	@Size(max=16,message = "Subscriber number should not exceed 16 digits")
	//@Column(name="Subscriber-number")
	private String Number;
	
	@Id
	@Size(max=32,message="IMSI number should not exceed 32 digits")
	//@Column(name="imsi-number")
	private String IMSI;
	
	//@Column(name="plan-id")
	private String PlanId;
	
	//@Column(name="region-code")
	private int RegionCode;
	
	//@Column(name="plan-type")
	private int PlanType;
	
	//@Column(name="subscriber-type")
	private  String Type;
	
	public Subscriber() {};
	public Subscriber(String iMSI, String number, String planId, String regionCode, int planType, int type) 
	{
		super();
		Number = number;
		IMSI = iMSI;
		PlanId = planId;
		RegionCode = Integer.parseInt(regionCode);
		PlanType = planType;
		
		switch(type)
		{
			case 1:	{ Type = "PREPAID"; break;}
			case 2 :{ Type = "POSTPAID";break;}
			default: {System.out.println("Error"); break;}
		}
	}
	
	public void setNumber(String number) {
		Number = number;
	}

	public void setIMSI(String iMSI) {
		IMSI = iMSI;
	}

	public void setPlanId(String planId) {
		PlanId = planId;
	}

	public void setRegionCode(int regionCode) {
		RegionCode = regionCode;
	}

	public void setPlanType(int planType) {
		PlanType = planType;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getNumber() {
		return Number;
	}

	public String getIMSI() {
		return IMSI;
	}

	public String getPlanId() {
		return PlanId;
	}

	public int getRegionCode() {
		return RegionCode;
	}

	public int getPlanType() {
		return PlanType;
	}

	public String getType() {
		return Type;
	}

	@Override
	public String toString() {
		return "Subscriber [Number=" + Number + ", IMSI=" + IMSI + ", PlanId=" + PlanId + ", RegionCode=" + RegionCode
				+ ", PlanType=" + PlanType + ", Type=" + Type + "]";
	}
	
}

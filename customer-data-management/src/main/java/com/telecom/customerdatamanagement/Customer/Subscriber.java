package com.telecom.customerdatamanagement.Customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name="Subscriber")
@Entity
public class Subscriber {
	
	@Size(max=16,message = "Subscriber number should not exceed 16 digits")
	@Column(name="SubscriberNumber")
	private String Number;
	
	@Id
	@Size(max=32,message="IMSI number should not exceed 32 digits")
	@Column(name="IMSInumber")
	private String IMSI;
	
	@Column(name="PlanId")
	private String PlanId;
	
	@Column(name="RegionCode")
	private int RegionCode;
	
	@Column(name="PlanType")
	private int PlanType;
	
	@Column(name="SubscriberType")
	private  String subscriberType;
	
	public Subscriber() {};
	@JsonCreator
	public Subscriber(@JsonProperty("iMSI") String iMSI,@JsonProperty("number") String number,@JsonProperty("planId") String planId
			, @JsonProperty("regionCode") String regionCode, @JsonProperty("planType") int planType, @JsonProperty("type") int type) 
	{
		super();
		Number = number;
		IMSI = iMSI;
		PlanId = planId;
		RegionCode = Integer.parseInt(regionCode);
		PlanType = planType;
		
		switch(type)
		{
			case 1:	{ subscriberType = "PREPAID"; break;}
			case 2 :{ subscriberType = "POSTPAID";break;}
			default: {System.out.println("Error"); break;}
		}
	}
	
	public void setNumber(String number) {
		Number = number;
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
		subscriberType = type;
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
		return subscriberType;
	}

	@Override
	public String toString() {
		return "Subscriber [Number=" + Number + ", IMSI=" + IMSI + ", PlanId=" + PlanId + ", RegionCode=" + RegionCode
				+ ", PlanType=" + PlanType + ", Type=" + subscriberType + "]";
	}
	
}

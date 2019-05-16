package com.sapiens.policy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="POLICY123")
public class Policy {

	 @Id
	 @SequenceGenerator(name = "pol_seq", sequenceName = "p_seq", allocationSize = 1)
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pol_seq")
	 @Column(name="PID")
	private long pid;
	private String riskLocation;
	
	
	
	public Policy() {
		super();
	}
	public Policy(long pid, String riskLocation) {
		super();
		this.pid = pid;
		this.riskLocation = riskLocation;
	}
	
	public long getPid() {
		return pid;
	}
	
	
	public void setPid(long pid) {
		this.pid = pid;
	}
	
	@Column(name = "RISK_LOCATON") 
	public String getRiskLocation() {
		return riskLocation;
	}
	public void setRiskLocation(String riskLocation) {
		this.riskLocation = riskLocation;
	}
	@Override
	public String toString() {
		return "Policy [pid=" + pid + ", riskLocation=" + riskLocation + "]";
	}
	
	
}

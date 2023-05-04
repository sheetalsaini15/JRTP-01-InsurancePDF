package com.example.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="citizen_plan_info")
public class CitizenPlan {
	

	private Integer citizenId;
	private String citizenName;
	private String gender;
	private String planName;
	private String planStatus;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	private Double benefitAmt;
	private String denialReason;
	private LocalDate terminatedDate;
	private String terminationRsn;
	
	@Override
	public String toString() {
		return "CitizenPlan [citizenId=" + citizenId + ", citizenName=" + citizenName + ", gender=" + gender
				+ ", planName=" + planName + ", planStatus=" + planStatus + ", planStartDate=" + planStartDate
				+ ", planEndDate=" + planEndDate + ", benefitAmt=" + benefitAmt + ", denialReason=" + denialReason
				+ ", terminatedDate=" + terminatedDate + ", terminationRsn=" + terminationRsn + "]";
	}
	/**
	 * @return the citizenId
	 */
	public Integer getCitizenId() {
		return citizenId;
	}
	/**
	 * @param citizenId the citizenId to set
	 */
	public void setCitizenId(Integer citizenId) {
		this.citizenId = citizenId;
	}
	/**
	 * @return the citizenName
	 */
	public String getCitizenName() {
		return citizenName;
	}
	/**
	 * @param citizenName the citizenName to set
	 */
	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the planName
	 */
	public String getPlanName() {
		return planName;
	}
	/**
	 * @param planName the planName to set
	 */
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	/**
	 * @return the planStatus
	 */
	public String getPlanStatus() {
		return planStatus;
	}
	/**
	 * @param planStatus the planStatus to set
	 */
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	/**
	 * @return the planStartDate
	 */
	public LocalDate getPlanStartDate() {
		return planStartDate;
	}
	/**
	 * @param planStartDate the planStartDate to set
	 */
	public void setPlanStartDate(LocalDate planStartDate) {
		this.planStartDate = planStartDate;
	}
	/**
	 * @return the planEndDate
	 */
	public LocalDate getPlanEndDate() {
		return planEndDate;
	}
	/**
	 * @param planEndDate the planEndDate to set
	 */
	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}
	/**
	 * @return the benefitAmt
	 */
	public Double getBenefitAmt() {
		return benefitAmt;
	}
	/**
	 * @param benefitAmt the benefitAmt to set
	 */
	public void setBenefitAmt(Double benefitAmt) {
		this.benefitAmt = benefitAmt;
	}
	/**
	 * @return the denialReason
	 */
	public String getDenialReason() {
		return denialReason;
	}
	/**
	 * @param denialReason the denialReason to set
	 */
	public void setDenialReason(String denialReason) {
		this.denialReason = denialReason;
	}
	/**
	 * @return the terminatedDate
	 */
	public LocalDate getTerminatedDate() {
		return terminatedDate;
	}
	/**
	 * @param terminatedDate the terminatedDate to set
	 */
	public void setTerminatedDate(LocalDate terminatedDate) {
		this.terminatedDate = terminatedDate;
	}
	/**
	 * @return the terminationRsn
	 */
	public String getTerminationRsn() {
		return terminationRsn;
	}
	public CitizenPlan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CitizenPlan(Integer citizenId, String citizenName, String gender, String planName, String planStatus,
			LocalDate planStartDate, LocalDate planEndDate, Double benefitAmt, String denialReason,
			LocalDate terminatedDate, String terminationRsn) {
		super();
		this.citizenId = citizenId;
		this.citizenName = citizenName;
		this.gender = gender;
		this.planName = planName;
		this.planStatus = planStatus;
		this.planStartDate = planStartDate;
		this.planEndDate = planEndDate;
		this.benefitAmt = benefitAmt;
		this.denialReason = denialReason;
		this.terminatedDate = terminatedDate;
		this.terminationRsn = terminationRsn;
	}
	/**
	 * @param terminationRsn the terminationRsn to set
	 */
	public void setTerminationRsn(String terminationRsn) {
		this.terminationRsn = terminationRsn;
	}
	

}

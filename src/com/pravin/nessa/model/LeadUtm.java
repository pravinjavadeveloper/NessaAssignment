package com.pravin.nessa.model;

/**
 * 
 * @author Pravin C
 *
 */
public class LeadUtm {

	private String fullName;
	private String email;
	private String phoneNo;
	private String phoneType_N;
	private String country_N = "MY";
	private String status_N = "508f4f0b0788455b9990bf13e3545aa8";
	private String hearingHistory_N = "unsure";
	private String preferredLanguage_N = "english";
	private Integer phoneCountryCode_N = 60;
	private String utmSource_N = "3409ce6753c34436b085d1a2ddf25c8b";
	private String utmName = "MY-WEB-GENERICLP";
	private String utmMedium;
	private String utmTerm;
	private String utmContent;
	private String utmUrl;
	private String notes;

	public LeadUtm(String fullName, String email, String phoneType_N,
			String phoneNo) {
		this.fullName = fullName;
		this.email = email;
		this.phoneType_N = phoneType_N;
		this.phoneNo = phoneNo;
	}
	
	public LeadUtm() {
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPhoneType_N() {
		return phoneType_N;
	}

	public void setPhoneType_N(String phoneType_N) {
		this.phoneType_N = phoneType_N;
	}

	public String getCountry_N() {
		return country_N;
	}

	public void setCountry_N(String country_N) {
		this.country_N = country_N;
	}

	public String getStatus_N() {
		return status_N;
	}

	public void setStatus_N(String status_N) {
		this.status_N = status_N;
	}

	public String getHearingHistory_N() {
		return hearingHistory_N;
	}

	public void setHearingHistory_N(String hearingHistory_N) {
		this.hearingHistory_N = hearingHistory_N;
	}

	public String getPreferredLanguage_N() {
		return preferredLanguage_N;
	}

	public void setPreferredLanguage_N(String preferredLanguage_N) {
		this.preferredLanguage_N = preferredLanguage_N;
	}

	public Integer getPhoneCountryCode_N() {
		return phoneCountryCode_N;
	}

	public void setPhoneCountryCode_N(Integer phoneCountryCode_N) {
		this.phoneCountryCode_N = phoneCountryCode_N;
	}

	public String getUtmSource_N() {
		return utmSource_N;
	}

	public void setUtmSource_N(String utmSource_N) {
		this.utmSource_N = utmSource_N;
	}

	public String getUtmName() {
		return utmName;
	}

	public void setUtmName(String utmName) {
		this.utmName = utmName;
	}

	public String getUtmMedium() {
		return utmMedium;
	}

	public void setUtmMedium(String utmMedium) {
		this.utmMedium = utmMedium;
	}

	public String getUtmTerm() {
		return utmTerm;
	}

	public void setUtmTerm(String utmTerm) {
		this.utmTerm = utmTerm;
	}

	public String getUtmContent() {
		return utmContent;
	}

	public void setUtmContent(String utmContent) {
		this.utmContent = utmContent;
	}

	public String getUtmUrl() {
		return utmUrl;
	}

	public void setUtmUrl(String utmUrl) {
		this.utmUrl = utmUrl;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}

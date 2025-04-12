//package com.mohit_project.Entity;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Lob;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class KycUpdate {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long kycUpdateid;
//	  private String aadharNo;
//
//	    @Lob
//	    @Column(name = "aadhar_doc", columnDefinition="LONGBLOB")
//	    private byte[] aadharDoc;
//
//	    private String panNo;
//
//	    @Lob
//	    @Column(name = "pan_doc", columnDefinition="LONGBLOB")
//	    private byte[] panDoc;
//
//	    private String accountNo;
//	    private String ifsc;
//	    private String bankName;
//	    private String bankAddress;
//
//	    @Lob
//	    @Column(name = "passbook_doc", columnDefinition="LONGBLOB")
//	    private byte[] passbookDoc;
//
//	    private String kycStatus;
//	    
//
//}
package com.mohit_project.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class KycUpdate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kycUpdateid;
    private Long employeeId;
    private String aadharNo;
    private String aadharDocFilename; // Added field for Aadhar document filename
    private String panNo;
    private String panDocFilename;    // Added field for PAN document filename
    private String accountNo;
    private String ifsc;
    private String bankName;
    private String bankAddress;
    private String passbookDocFilename; // Added field for Passbook document filename
    private String kycStatus;

    // Getters and Setters
    public Long getKycUpdateid() { return kycUpdateid; }
    public void setKycUpdateid(Long kycUpdateid) { this.kycUpdateid = kycUpdateid; }
    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }
    public String getAadharNo() { return aadharNo; }
    public void setAadharNo(String aadharNo) { this.aadharNo = aadharNo; }
    public String getAadharDocFilename() { return aadharDocFilename; }
    public void setAadharDocFilename(String aadharDocFilename) { this.aadharDocFilename = aadharDocFilename; }
    public String getPanNo() { return panNo; }
    public void setPanNo(String panNo) { this.panNo = panNo; }
    public String getPanDocFilename() { return panDocFilename; }
    public void setPanDocFilename(String panDocFilename) { this.panDocFilename = panDocFilename; }
    public String getAccountNo() { return accountNo; }
    public void setAccountNo(String accountNo) { this.accountNo = accountNo; }
    public String getIfsc() { return ifsc; }
    public void setIfsc(String ifsc) { this.ifsc = ifsc; }
    public String getBankName() { return bankName; }
    public void setBankName(String bankName) { this.bankName = bankName; }
    public String getBankAddress() { return bankAddress; }
    public void setBankAddress(String bankAddress) { this.bankAddress = bankAddress; }
    public String getPassbookDocFilename() { return passbookDocFilename; }
    public void setPassbookDocFilename(String passbookDocFilename) { this.passbookDocFilename = passbookDocFilename; }
    public String getKycStatus() { return kycStatus; }
    public void setKycStatus(String kycStatus) { this.kycStatus = kycStatus; }
}

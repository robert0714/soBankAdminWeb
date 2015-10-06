package com.iisigroup.product.secure.domain;

import static javax.persistence.GenerationType.*;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 


/**
 * AccountPo entity. 
 */
@Entity
@Table(name="ACCOUNT")

public class AccountPo  implements java.io.Serializable {


    // Fields    

     /**  */
	 private static final long serialVersionUID = 7588731633323663397L;
	 private Long id;
     private String accountName;
     private String userRealName;
     private String encryptPasswd;
     private Boolean activate;
     private Set<RolePo> rolePos = new HashSet<RolePo>(0);


    // Constructors

    /** default constructor */
    public AccountPo() {
    }

    
    /** full constructor */
    public AccountPo(String accountName, String userRealName, String encryptPasswd, Boolean activate, Set<RolePo> rolePos) {
        this.accountName = accountName;
        this.userRealName = userRealName;
        this.encryptPasswd = encryptPasswd;
        this.activate = activate;
        this.rolePos = rolePos;
    }

   
    // Property accessors
//    @GenericGenerator(name="generator", strategy="increment")
    @Id 
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="ID")

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="ACCOUNT_NAME")

    public String getAccountName() {
        return this.accountName;
    }
    
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    
    @Column(name="USER_REAL_NAME")

    public String getUserRealName() {
        return this.userRealName;
    }
    
    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }
    
    @Column(name="ENCRYPT_PASSWD")

    public String getEncryptPasswd() {
        return this.encryptPasswd;
    }
    
    public void setEncryptPasswd(String encryptPasswd) {
        this.encryptPasswd = encryptPasswd;
    }
    
    @Column(name="ACTIVATE")

    public Boolean getActivate() {
        return this.activate;
    }
    
    public void setActivate(Boolean activate) {
        this.activate = activate;
    }
@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="accountPos")

    public Set<RolePo> getRolePos() {
        return this.rolePos;
    }
    
    public void setRolePos(Set<RolePo> rolePos) {
        this.rolePos = rolePos;
    }
   








}
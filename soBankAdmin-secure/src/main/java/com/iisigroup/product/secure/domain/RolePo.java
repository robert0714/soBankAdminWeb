package com.iisigroup.product.secure.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


/**
 * RolePo entity. 
 */
@Entity
@Table(name="ROLE")

public class RolePo  implements java.io.Serializable {


    // Fields    

     /**  */
	 private static final long serialVersionUID = -4418880168927666611L;
	 private Long id;
     private String roleDesc;
     private String roleCode;
     private Set<FuncPo> funcPos = new HashSet<FuncPo>(0);
     private Set<AccountPo> accountPos = new HashSet<AccountPo>(0);


    // Constructors

    /** default constructor */
    public RolePo() {
    }

    
    /** full constructor */
    public RolePo(String roleDesc, String roleCode, Set<FuncPo> funcPos, Set<AccountPo> accountPos) {
        this.roleDesc = roleDesc;
        this.roleCode = roleCode;
        this.funcPos = funcPos;
        this.accountPos = accountPos;
    }

   
    // Property accessors
    @GenericGenerator(name="generator", strategy="increment")@Id @GeneratedValue(generator="generator")
    
    @Column(name="ID", unique=true, nullable=false)

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="ROLE_DESC")

    public String getRoleDesc() {
        return this.roleDesc;
    }
    
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
    
    @Column(name="ROLE_CODE", length=20)

    public String getRoleCode() {
        return this.roleCode;
    }
    
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name="ROLE_FUNC",  joinColumns = { 
        @JoinColumn(name="ROLE_ID", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="FUN_ID", nullable=false, updatable=false) })

    public Set<FuncPo> getFuncPos() {
        return this.funcPos;
    }
    
    public void setFuncPos(Set<FuncPo> funcPos) {
        this.funcPos = funcPos;
    }
@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name="USER_ROLE", schema="PUBLIC", catalog="SEC_DB", joinColumns = { 
        @JoinColumn(name="ROLE_ID", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="USER_ID", nullable=false, updatable=false) })

    public Set<AccountPo> getAccountPos() {
        return this.accountPos;
    }
    
    public void setAccountPos(Set<AccountPo> accountPos) {
        this.accountPos = accountPos;
    }
   








}
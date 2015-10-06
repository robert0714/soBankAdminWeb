package com.iisigroup.product.secure.domain;

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
import org.hibernate.annotations.GenericGenerator;


/**
 * FuncPo entity. 
 */
@Entity
@Table(name="FUNC")

public class FuncPo  implements java.io.Serializable {


    // Fields    

     /**  */
	 private static final long serialVersionUID = 2136499063286713120L;
	 private Long id;
     private String funcCode;
     private String funcName;
     private Integer parentId;
     private Set<RolePo> rolePos = new HashSet<RolePo>(0);


    // Constructors

    /** default constructor */
    public FuncPo() {
    }

    
    /** full constructor */
    public FuncPo(String funcCode, String funcName, Integer parentId, Set<RolePo> rolePos) {
        this.funcCode = funcCode;
        this.funcName = funcName;
        this.parentId = parentId;
        this.rolePos = rolePos;
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
    
    @Column(name="FUNC_CODE")

    public String getFuncCode() {
        return this.funcCode;
    }
    
    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }
    
    @Column(name="FUNC_NAME")

    public String getFuncName() {
        return this.funcName;
    }
    
    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }
    
    @Column(name="PARENT_ID")

    public Integer getParentId() {
        return this.parentId;
    }
    
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="funcPos")

    public Set<RolePo> getRolePos() {
        return this.rolePos;
    }
    
    public void setRolePos(Set<RolePo> rolePos) {
        this.rolePos = rolePos;
    }
   








}
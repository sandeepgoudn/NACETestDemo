package com.accenture.nace.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import java.util.Date;

@Entity
public class NaceOrder {

    @Id
    private Integer orderid;
    @Lob
    private String level;
    @Lob
    private String code;
    @Lob
    private String parent;
    @Lob
    private String description;
    @Lob
    private String thisitemincludes;
    @Lob
    private String thisitemsalsoincludes;
    private String rulings;
    @Lob
    private String excludes;
    private String rev4;
    
    public NaceOrder() {
    	
    }
    
	public NaceOrder(Integer orderid, String level, String code, String parent, String description, String thisitemincludes,
			String thisitemsalsoincludes, String rulings, String excludes, String rev4) {
		super();
		this.orderid = orderid;
		this.level = level;
		this.code = code;
		this.parent = parent;
		this.description = description;
		this.thisitemincludes = thisitemincludes;
		this.thisitemsalsoincludes = thisitemsalsoincludes;
		this.rulings = rulings;
		this.excludes = excludes;
		this.rev4 = rev4;
	}
	@Override
	public String toString() {
		return "User [orderid=" + orderid + ", level=" + level + ", code=" + code + ", parent=" + parent
				+ ", description=" + description + ", thisitemincludes=" + thisitemincludes + ", thisitemsalsoincludes="
				+ thisitemsalsoincludes + ", rulings=" + rulings + ", rev4=" + rev4 + "]";
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getThisitemincludes() {
		return thisitemincludes;
	}
	public void setThisitemincludes(String thisitemincludes) {
		this.thisitemincludes = thisitemincludes;
	}
	public String getThisitemsalsoincludes() {
		return thisitemsalsoincludes;
	}
	public void setThisitemsalsoincludes(String thisitemsalsoincludes) {
		this.thisitemsalsoincludes = thisitemsalsoincludes;
	}
	public String getRulings() {
		return rulings;
	}
	public void setRulings(String rulings) {
		this.rulings = rulings;
	}
	public String getExcludes() {
		return excludes;
	}

	public void setExcludes(String excludes) {
		this.excludes = excludes;
	}

	public String getRev4() {
		return rev4;
	}
	public void setRev4(String rev4) {
		this.rev4 = rev4;
	}
    

    
}
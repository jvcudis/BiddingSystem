package org.bidding.web.forms;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ItemForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private String desc;
	
	private Integer owner;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date dateAdded;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date dateExpiry;
	
	private Double price;

	public ItemForm() { }
	
	public ItemForm(String name, String desc, Integer owner, Date dateAdded, Date dateExpiry, Double price) {
		this.setName(name);
		this.setDesc(desc);
		this.setOwner(owner);
		this.setDateAdded(dateAdded);
		this.setDateExpiry(dateExpiry);
		this.setPrice(price);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getOwner() {
		return owner;
	}

	public void setOwner(Integer owner) {
		this.owner = owner;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Date getDateExpiry() {
		return dateExpiry;
	}

	public void setDateExpiry(Date dateExpiry) {
		this.dateExpiry = dateExpiry;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
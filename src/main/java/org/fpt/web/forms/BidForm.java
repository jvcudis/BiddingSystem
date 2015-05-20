package org.fpt.web.forms;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BidForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer itemId;
	
	private Integer ownerId;
	
	private Double offerPrice;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date offerDate;
	
	public BidForm() { }
	
	public BidForm(Integer itemId, Integer ownerId, Double offerPrice, Date offerDate) {
		this.itemId = itemId;
		this.ownerId = ownerId;
		this.offerPrice = offerPrice;
		this.offerDate = offerDate;
	}
	
	public Integer getItemId() {
		return itemId;
	}
	
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	
	public Integer getOwnerId() {
		return ownerId;
	}
	
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	
	public Double getOfferPrice() {
		return offerPrice;
	}
	
	public void setOfferPrice(Double offerPrice) {
		this.offerPrice = offerPrice;
	}
	
	public Date getOfferDate() {
		return offerDate;
	}
	
	public void setOfferDate(Date offerDate) {
		this.offerDate = offerDate;
	}
}
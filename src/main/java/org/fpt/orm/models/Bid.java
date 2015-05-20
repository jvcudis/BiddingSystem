package org.fpt.orm.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tbl_bids")
public class Bid implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bid_id", unique = true, nullable = false)
	private Integer bidId;
	
	@Column(name = "bid_offer_price", nullable = false)
	private Double bidOfferPrice;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "bid_offer_date", nullable = false)
	private Date bidOfferDate;
	
	@Column(name = "bid_owner", nullable = false)
	private Integer bidOwnerId;
	
	@Column(name = "bid_item", nullable = false)
	private Integer bidItemId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bid_owner", insertable = false, updatable = false)
	@JsonManagedReference("bid-owner")
	private User bidder;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bid_item", insertable = false, updatable = false)
	@JsonManagedReference("bid-item")
	private Item product;
	
	public Bid() { }

	public Integer getBidId() {
		return bidId;
	}

	public Item getProduct() {
		return product;
	}

	public User getBidder() {
		return bidder;
	}

	public Double getBidOfferPrice() {
		return bidOfferPrice;
	}

	public Date getBidOfferDate() {
		return bidOfferDate;
	}
	
	public Integer getBidOwnerId() {
		return bidOwnerId;
	}

	public Integer getBidItemId() {
		return bidItemId;
	}
	
	public void setBidId(Integer bidId) {
		this.bidId = bidId;
	}

	@Transient
	public void setProduct(Item product) {
		this.product = product;
	}

	@Transient
	public void setBidder(User bidder) {
		this.bidder = bidder;
	}
	
	public void setBidOfferPrice(Double bidOfferPrice) {
		this.bidOfferPrice = bidOfferPrice;
	}
	
	public void setBidOfferDate(Date bidOfferDate) {
		this.bidOfferDate = bidOfferDate;
	}

	public void setBidOwnerId(Integer bidOwnerId) {
		this.bidOwnerId = bidOwnerId;
	}

	public void setBidItemId(Integer bidItemId) {
		this.bidItemId = bidItemId;
	}
	
}
package org.fpt.orm.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tbl_items")
public class Item implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id", unique = true, nullable = false)
	private Integer itemId;
	
	@Column(name = "item_name", nullable = false, length = 80)
	private String itemName;
	
	@Column(name = "item_desc", nullable = false, length = 80)
	private String itemDesc;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "item_date_added", nullable = false)
	private Date itemDateAdded;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "item_date_expiry", nullable = false)
	private Date itemDateExpiry;
	
	@Column(name = "item_price", nullable = false)
	private Double itemPrice;
	
	@Column(name = "item_owner", nullable = false)
	private Integer itemOwnerId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "item_owner",  insertable = false, updatable = false)
	@JsonManagedReference("user-item")
	private User owner;
	
	@OneToMany(mappedBy ="product", fetch = FetchType.EAGER)
	@JsonBackReference("bid-item")
	private List<Bid> itemBids;

	public Item() { }

	public Integer getItemId() {
		return itemId;
	}

	public String getItemName() {
		return itemName;
	}
	
	public String getItemDesc() {
		return itemDesc;
	}
	
	public Date getItemDateAdded() {
		return itemDateAdded;
	}

	public Date getItemDateExpiry() {
		return itemDateExpiry;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public Integer getItemOwnerId() {
		return itemOwnerId;
	}
	
	public User getOwner() {
		return owner;
	}
	
	public List<Bid> getItemBids() {
		return itemBids;
	}
	
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	
	@Transient
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	@Transient
	public void setItemBids(List<Bid> itemBids) {
		this.itemBids = itemBids;
	}
	
	public void setItemDateAdded(Date itemDateAdded) {
		this.itemDateAdded = itemDateAdded;
	}
	
	public void setItemDateExpiry(Date itemExpiry) {
		this.itemDateExpiry = itemExpiry;
	}
	
	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public void setItemOwnerId(Integer itemOwnerId) {
		this.itemOwnerId = itemOwnerId;
	}
	
}
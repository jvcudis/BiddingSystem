package org.fpt.orm.models;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tbl_users")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id", unique = true, nullable = false)
	private Integer userId;
	
	@Column(name = "user_username", nullable = false, length = 45)
	private String userUsername;
	
	@Column(name = "user_password", nullable = false, length = 45)
	@JsonIgnore
	private String userPassword;
	
	@Column(name = "user_name", nullable = false, length = 80)
	private String userName;
	
	@Column(name = "user_email", nullable = false, length = 80)
	private String userEmail;
	
	@Column(name = "user_role", nullable = false)
	private Integer userRoleId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_role", insertable = false, updatable = false)
	@JsonManagedReference("user-role")
	private UserRole userRole;
	
	@OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
	@JsonBackReference("user-item")
	private List<Item> userItems;
	
	@OneToMany(mappedBy ="bidder", fetch = FetchType.EAGER)
	@JsonBackReference("bid-owner")
	private List<Bid> userBids;
	
	public User() { }
	
	public Integer getUserId() {
		return userId;
	}

	public String getUserUsername() {
		return userUsername;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	
	public UserRole getUserRole() {
		return userRole;
	}
	
	public Integer getUserRoleId() {
		return userRoleId;
	}
	
	public List<Item> getUserItems() {
		return userItems;
	}
	
	public List<Bid> getUserBids() {
		return userBids;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}
	
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}
	
	@Transient  
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	
	@Transient  
	public void setUserItems(List<Item> userItems) {
		this.userItems = userItems;
	}
	
	@Transient  
	public void setUserBids(List<Bid> userBids) {
		this.userBids = userBids;
	}

}
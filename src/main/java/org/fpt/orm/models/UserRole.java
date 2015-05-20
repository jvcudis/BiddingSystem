package org.fpt.orm.models;

import java.io.Serializable;
//import java.util.List;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_roles")
public class UserRole implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id", unique = true, nullable = false)
	private Integer roleId;
	
	@Column(name = "role_name", nullable = false, length = 25)
	private String roleName;
	
	@Column(name = "role_desc", nullable = true, length = 100)
	@JsonIgnore
	private String roleDesc;
	
	@OneToMany(mappedBy = "userRole", fetch = FetchType.EAGER)
	@JsonBackReference("user-role")
	private List<User> roleUsers;
	
	public UserRole() { }
	
	public Integer getRoleId() {
		return this.roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}
	
	public String getRoleDesc() {
		return this.roleDesc;
	}
	
	public List<User> getRoleUsers() {
		return roleUsers;
	}
	
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	
	@Transient  
	public void setRoleUsers(List<User> roleUsers) {
		this.roleUsers = roleUsers;
	}

}

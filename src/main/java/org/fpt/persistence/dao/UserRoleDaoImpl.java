package org.fpt.persistence.dao;

import java.util.ArrayList;
import java.util.List;

import org.fpt.persistence.model.UserRole;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRoleDaoImpl implements UserRoleDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public String getRoleName(Integer roleId) {
		List<UserRole> userRoles = new ArrayList<UserRole>();
		
		userRoles = sessionFactory.getCurrentSession()
				.createQuery("from UserRole where roleId=?")
				.setParameter(0, roleId)
				.list();
		
		if (userRoles.size() > 0) {
			return userRoles.get(0).getRoleName();
		} else {
			return "";
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserRole> getAllRoles() {
		List<UserRole> userRoles = new ArrayList<UserRole>();
		
		userRoles = sessionFactory.getCurrentSession()
				.createQuery("from UserRole")
				.list();
		
		if (userRoles.size() > 0) {
			return userRoles;
		} else {
			return null;
		}
	}
	
}
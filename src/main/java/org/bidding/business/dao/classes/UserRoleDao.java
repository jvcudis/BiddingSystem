package org.bidding.business.dao.classes;

import java.util.ArrayList;
import java.util.List;

import org.bidding.business.dao.common.GenericDao;
import org.bidding.business.dao.interfaces.IUserRoleDao;
import org.bidding.business.models.UserRole;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRoleDao extends GenericDao<UserRole> implements IUserRoleDao {

	@Autowired
    private SessionFactory sessionFactory;
	
    public UserRoleDao() {
        super();
        setClazz(UserRole.class);
    }

	@Override
	@SuppressWarnings("unchecked")
	public UserRole findRoleByName(String name) {
		List<UserRole> roles = new ArrayList<UserRole>();
		roles = sessionFactory.getCurrentSession()
				.createQuery("from UserRole where roleName=?")
				.setParameter(0, name)
				.list();
			
		if (roles.size() > 0) {
			return roles.get(0);
		} else {
			return null;
		}
	}
}

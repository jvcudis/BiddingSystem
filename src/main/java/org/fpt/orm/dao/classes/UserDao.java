package org.fpt.orm.dao.classes;

import java.util.ArrayList;
import java.util.List;

import org.fpt.orm.dao.common.GenericDao;
import org.fpt.orm.dao.interfaces.IUserDao;
import org.fpt.orm.models.User;
import org.fpt.orm.models.UserRole;
import org.fpt.web.forms.UserForm;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends GenericDao<User> implements IUserDao {

	@Autowired
    private SessionFactory sessionFactory;
	
    public UserDao() {
        super();
        setClazz(User.class);
    }

	@Override
	@SuppressWarnings("unchecked")
	public User findUserByUsername(String username) {
		List<User> users = new ArrayList<User>();
		users = sessionFactory.getCurrentSession()
				.createQuery("from User where userUsername=?")
				.setParameter(0, username)
				.list();
		
		if(users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> findUsersWithRole(Integer roleId) {
		List<User> users = new ArrayList<User>();
		users = sessionFactory.getCurrentSession()
				.createQuery("from User where userRoleId=?")
				.setParameter(0, roleId)
				.list();
		
		if(users.size() > 0) {
			return users;
		} else {
			return null;
		}
	}

	@Override
	public User createUser(UserForm form) {
		Session session = sessionFactory.getCurrentSession();
		User user = new User();
		
		// Set User from UserForm to be processed by UserDao
		user.setUserUsername(form.getUsername());
		user.setUserPassword(form.getPassword());
		user.setUserName(form.getName());
		user.setUserEmail(form.getEmail());
		user.setUserRoleId(form.getRole());
		user.setUserRole((UserRole) session.get(UserRole.class, form.getRole()));
		
		session.saveOrUpdate(user);
		
		return user;
	}

	@Override
	public User updateUser(Integer id, UserForm form) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		
		// Set User from UserForm to be processed by UserDao
		user.setUserUsername(form.getUsername());
		user.setUserPassword(form.getPassword());
		user.setUserName(form.getName());
		user.setUserEmail(form.getEmail());
		user.setUserRoleId(form.getRole());
		user.setUserRole((UserRole) session.get(UserRole.class, form.getRole()));
		
		session.merge(user);
		
		return user;
	}
	
}
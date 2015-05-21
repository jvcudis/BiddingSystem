package org.fpt.orm.services.classes;

import java.util.ArrayList;
import java.util.List;

import org.fpt.aspect.annotations.PerfLog;
import org.fpt.orm.models.User;
import org.fpt.orm.services.common.GenericService;
import org.fpt.orm.dao.common.IOperations;
import org.fpt.orm.dao.interfaces.IUserDao;
import org.fpt.orm.services.interfaces.IUserService;
import org.fpt.web.forms.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericService<User> implements IUserService {

    @Autowired
    private IUserDao dao;

    public UserService() {
        super();
    }

    @Override
    protected IOperations<User> getDao() {
        return dao;
    }

    @Override
    @PerfLog
	public List<User> getAllUsers() {
    	List<User> users = new ArrayList<User>();
		users = getDao().findAll();
		
		// TODO Change to check if returned object is null, 
		// Since null object means that there was no object found on the db
		if(users.isEmpty()) {
			return null;
		} else {
			return users;
		}
	}

	@Override
	@PerfLog
	public User getUserById(Integer id) {
		User user = getDao().findOne(id);
		
		// TODO Change to check if returned object is null, 
		// Since null object means that there was no object found on the db
		return user;
	}

	@Override
	@PerfLog
	public User getUserByUsername(String username) {
		User user = new User();
		user = dao.findUserByUsername(username);
		
		// TODO Change to check if returned object is null, 
		// Since null object means that there was no object found on the db
		if(user.getUserName().isEmpty() || user.getUserName().equals("")) {
			// TODO Return something better instead of null
			return null;
		} else {
			return user;
		}
	}

	@Override
	@PerfLog
	public List<User> getAllUsersWithRole(Integer roleId) {
		List<User> users = new ArrayList<User>();
		users = dao.findUsersWithRole(roleId);

		// TODO Change to check if returned object is null, 
		// Since null object means that there was no object found on the db
		if(users.size() == 0) {
			// TODO Return something better instead of null
			return null;
		} else {
			return users;
		}
	}
	
	@Override
	@PerfLog
	public User createUser(UserForm form) {
		User user = dao.createUser(form);
		
		// TODO Change to check if returned object is null, 
		// Since null object means that there was no object found on the db
		if(user == null) {
			// TODO Return something better instead of null
			return null;
		} else {
			return user;
		}
	}

	@Override
	@PerfLog
	public User updateUser(Integer id, UserForm form) {
		User user = dao.updateUser(id, form);
		
		// TODO Change to check if returned object is null, 
		// Since null object means that there was no object found on the db
		if(user == null) {
			// TODO Return something better instead of null
			return null;
		} else {
			return user;
		}
	}
	
	@Override
	@PerfLog
	public User deleteUserById(Integer id) {
		User user = getDao().findOne(id);
		getDao().deleteById(id);
		return user;
	}
	
}

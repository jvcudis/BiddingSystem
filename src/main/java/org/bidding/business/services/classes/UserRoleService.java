package org.bidding.business.services.classes;

import java.util.ArrayList;
import java.util.List;

import org.bidding.aspect.annotations.PerfLog;
import org.bidding.business.dao.common.IOperations;
import org.bidding.business.dao.interfaces.IUserRoleDao;
import org.bidding.business.models.UserRole;
import org.bidding.business.services.common.GenericService;
import org.bidding.business.services.interfaces.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService extends GenericService<UserRole> implements IUserRoleService {

    @Autowired
    private IUserRoleDao dao;

    public UserRoleService() {
        super();
    }

    @Override
    protected IOperations<UserRole> getDao() {
        return dao;
    }

    @Override
    @PerfLog
	public List<UserRole> getAllRoles() {
		List<UserRole> roles = new ArrayList<UserRole>();
		roles = getDao().findAll();
		
		// TODO Change to check if returned object is null, 
		// Since null object means that there was no object found on the db
		if(roles.isEmpty()) {
			// TODO Return something better instead of null
			return null;
		} else {
			return roles;
		}
	}

	@Override
	@PerfLog
	public UserRole getRoleById(Integer id) {
		UserRole role = getDao().findOne(id);
		
		// TODO Change to check if returned object is null, 
		// Since null object means that there was no object found on the db
		if(role == null) {
			// TODO Return something better instead of null
			return null;
		} else {
			return role;
		}
	}

	@Override
	@PerfLog
	public UserRole getRoleByName(String name) {
		UserRole role = new UserRole();
		role = dao.findRoleByName(name);
		
		// TODO Change to check if returned object is null, 
		// Since null object means that there was no object found on the db
		if(role.getRoleName().isEmpty() || role.getRoleName().equals("")) {
			// TODO Return something better instead of null
			return null;
		} else {
			return role;
		}
	}

}

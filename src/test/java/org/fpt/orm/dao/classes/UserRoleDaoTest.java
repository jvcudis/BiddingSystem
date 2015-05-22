package org.fpt.orm.dao.classes;

import static org.junit.Assert.*;

import org.fpt.orm.models.UserRole;
import org.fpt.orm.services.classes.UserRoleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;


// TODO
// >> Setup Object fixtures for testing
// >> Use actual DB values in testing

@RunWith(MockitoJUnitRunner.class)
public class UserRoleDaoTest {

	@Mock
	private UserRoleDao dao;
	
	@InjectMocks
	private UserRoleService service;
	
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testFindRoleByName() {
		UserRole role = addUserRoleDummy(1, "ROLE1", "role 1 desc");		
		Mockito.when(dao.findRoleByName("ROLE1")).thenReturn(role);
		UserRole userRole = service.getRoleByName("ROLE1");
		
		assertEquals("ROLE1", userRole.getRoleName()); 
	}
    
    private UserRole addUserRoleDummy(Integer id, String name, String desc) {
    	UserRole role = new UserRole();
    	role.setRoleId(id);
    	role.setRoleName(name);
    	role.setRoleDesc(desc);
    	return role;
    }
}
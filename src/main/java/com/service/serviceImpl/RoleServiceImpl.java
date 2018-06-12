package com.service.serviceImpl;

import com.dao.RoleDAO;
import com.model.Role;
import com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public List<Role> findAllRoles() {
        return roleDAO.findAllRoles();
    }

    @Override
    public Role findByRoleName(String roleName) {
        Role role = roleDAO.findByRoleName(roleName);
        return role;
    }

    @Override
    public Role findById(int id) {
        Role role = roleDAO.findById(id);
        return role;
    }

    @Override
    public void saveRole(Role role) {
        roleDAO.save(role);
    }

    @Override
    public void update(Role role) {
//        Role role1 = roleDAO.findById(role.getId_role());
//        if(role1 != null){
//            role1.setUsers(role.getUsers());
//        }
        roleDAO.updateRole(role);
    }

    @Override
    public void delete(String name_role) {
        roleDAO.deleteRole(name_role);
    }
}

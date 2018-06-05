package com.service.serviceImpl;

import com.dao.RoleDAO;
import com.model.Role;
import com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
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
}

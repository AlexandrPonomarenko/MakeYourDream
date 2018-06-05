package com.dao;

import com.model.Role;

import java.util.List;

public interface RoleDAO {
    List<Role> findAllRoles();
    Role findByRoleName(String roleName);
    Role findById(int id);
}

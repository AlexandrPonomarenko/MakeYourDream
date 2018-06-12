package com.dao;

import com.model.Role;

import java.util.List;

public interface RoleDAO {
    List<Role> findAllRoles();
    Role findByRoleName(String roleName);
    Role findById(int id);
    void save(Role role);
    void setFlushEM();
    void updateRole(Role role);
    void deleteRole(String name_role);
}

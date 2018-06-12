package com.service;

import com.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAllRoles();
    Role findByRoleName(String roleName);
    Role findById(int id);
    void saveRole(Role role);
    void update(Role role);
    void delete(String name_role);
}

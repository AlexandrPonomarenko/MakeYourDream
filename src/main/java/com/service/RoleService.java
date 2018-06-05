package com.service;

import com.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAllRoles();
    Role findByRoleName(String roleName);
    Role findById(int id);
}

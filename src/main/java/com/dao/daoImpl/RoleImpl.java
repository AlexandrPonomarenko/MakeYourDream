package com.dao.daoImpl;

import com.dao.AbstractDAO;
import com.dao.RoleDAO;
import com.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository("RoleDAO")
public class RoleImpl extends AbstractDAO<Integer, Role> implements RoleDAO{

    @SuppressWarnings("unchecked")
    @Override
    public List<Role> findAllRoles() {
        List<Role> roles =  getEntityManager()
                .createQuery("SELECT r FROM Role r ORDER BY r.name_role ASC")
                .getResultList();
        return roles;
    }

    @Override
    public Role findByRoleName(String roleName) {
        try {
            Role role = (Role) getEntityManager()
                    .createQuery("SELECT r FROM Role r WHERE r.name_role LIKE :name_role")
                    .setParameter("name_role", roleName)
                    .getSingleResult();
            return role;
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Role findById(int id) {
        return getByKey(id);
    }
}

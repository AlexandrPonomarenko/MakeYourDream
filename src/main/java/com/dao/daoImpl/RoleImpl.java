package com.dao.daoImpl;

import com.dao.AbstractDAO;
import com.dao.RoleDAO;
import com.model.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.Collection;
import java.util.List;

@Repository("roleDAO")
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
            if (role != null){
                initializeCollection(role.getUsers());
            }
            return role;
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Role findById(int id) {
        Role role = getByKey(id);
        if(role != null){
            initializeCollection(role.getUsers());
        }
        return role;

    }

    @Override
    public void save(Role role) {
        persist(role);
    }

    @Override
    public void setFlushEM(){
        getEntityManager().flush();
    }

    @Override
    public void updateRole(Role role) {
        update(role);
    }

    @Override
    public void deleteRole(String name_role) {
        Role entity = (Role) getEntityManager()
                .createQuery("SELECT r FROM Role r WHERE r.name_role LIKE:name_role")
                .setParameter("name_role", name_role)
                .getSingleResult();
        delete(entity);
    }

    protected void initializeCollection(Collection<?> collection) {
        if(collection == null) {
            return;
        }
        collection.iterator().hasNext();
    }
}

package com.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "role", schema = "spring_t", uniqueConstraints = {@UniqueConstraint(columnNames = "id_role")})
public class Role implements Serializable {
    @Id
    @SequenceGenerator(name = "pc_seq_role", sequenceName = "pc_seq_role", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pc_seq_role")
    @Column(name = "id_role")
    private Integer id_role;

    @NotEmpty
    @Size(min = 5, max = 15)
    @Column(name = "name_role", length = 15, unique = false, nullable = false)
    private String name_role;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<User> users = new HashSet<User>();

    public Role() {
    }

    public Integer getId_role() {
        return id_role;
    }


    public void setId_role(Integer id_role) {
        this.id_role = id_role;
    }

    public String getNameRole() {
        return name_role;
    }

    public void setNameRole(String name_role) {
        this.name_role = name_role;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return Objects.equals(id_role, role.id_role) &&
                Objects.equals(getNameRole(), role.getNameRole());
    }

    @Override
    public int hashCode() {

        return Objects.hash(id_role, getNameRole());
    }

    @Override
    public String toString() {
        return "Role{" +
                "id_role=" + id_role +
                ", name_role='" + name_role + '\'' +
                ", users=" + users.size() +
                '}';
    }
}

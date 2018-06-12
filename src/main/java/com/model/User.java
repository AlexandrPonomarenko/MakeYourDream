package com.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users", schema = "spring_t", uniqueConstraints = {@UniqueConstraint(columnNames = "idUser")})
public class User implements Serializable{
    @Id
    @SequenceGenerator(name = "pc_seq_user", sequenceName = "pc_seq_user", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pc_seq_user")
    @Column(name = "idUser")
    private Integer idUser;

    @NotEmpty
    @Size(min = 5, max = 20)
    @Column(name = "name", unique = false, length = 20, nullable = false)
    private String name;

    @NotEmpty
    @Size(min = 5, max = 10)
    @Column(name = "login", unique = true, length = 10, nullable = false)
    private String login;

    @NotEmpty
    @Size(min = 5, max = 25)
    @Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")
    @Column(name = "email", unique = true, length = 25, nullable = false)
    private String email;

    @NotEmpty
    @Size(min = 8, max = 30)
    @Column(name = "password", unique = false, length = 30, nullable = false)
    private String password;

    @NotEmpty
//    @Temporal(TemporalType.DATE)
    @Column(name = "date", unique = false, nullable = false)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "id_role", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "userCard", cascade = CascadeType.ALL)
    private Set<Card> cards = new HashSet<>();

    @OneToMany(mappedBy = "userTheme", cascade = CascadeType.ALL)
    private Set<Theme> themes = new HashSet<>();

    public User() {
    }

    public User(String name, String login, String email, String password, LocalDate date, Role role) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.password = password;
        this.date = date;
        this.role = role;
    }

    public Integer getId() {
        return idUser;
    }

    public void setId(Integer id) {
        this.idUser = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    public Set<Theme> getThemes() {
        return themes;
    }

    public void setThemes(Set<Theme> themes) {
        this.themes = themes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(idUser, user.idUser) &&
                Objects.equals(getLogin(), user.getLogin()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getDate(), user.getDate());
    }

    @Override
    public int hashCode() {

        return Objects.hash(idUser, getLogin(), getEmail(), getDate());
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", date=" + date +
                ", role=" + role.getNameRole() +
                ", cards=" + cards.size() +
                ", themes=" + themes.size() +
                '}';
    }
}

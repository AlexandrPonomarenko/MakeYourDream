package com.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "like", schema = "spring_t", uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class Like implements Serializable {
    @Id
    @SequenceGenerator(name = "pc_seq_like", sequenceName = "pc_seq_like", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pc_seq_like")
    @Column(name = "id")
    private Integer id;

    @NotEmpty
    @Column(name = "count_likes", unique = false, nullable = false)
    private Integer count_likes;

    @Column(name = "login_man", unique = true, nullable = true)
    private String login_man;

    @ManyToOne
    @JoinColumn(name = "idTheme")
    private Theme theme;

    public Like() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount_likes() {
        return count_likes;
    }

    public void setCount_likes(Integer count_likes) {
        this.count_likes = count_likes;
    }

    public String getLogin_man() {
        return login_man;
    }

    public void setLogin_man(String login_man) {
        this.login_man = login_man;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Like)) return false;
        Like like = (Like) o;
        return Objects.equals(id, like.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", count_likes=" + count_likes +
                ", login_man='" + login_man + '\'' +
                ", theme=" + theme +
                '}';
    }
}

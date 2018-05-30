package com.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "video", schema = "spring_t", uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class Video implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private Integer id;

    @NotEmpty
    @Column(name = "path", nullable = true, unique = false)
    private String path;

    @NotEmpty
    @Column(name = "path2", nullable = true, unique = false)
    private String path2;

    @NotEmpty
    @Column(name = "path3", nullable = true, unique = false)
    private String path3;

    @OneToOne(mappedBy = "video", cascade = CascadeType.ALL)
    private Theme theme;

    public Video() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath2() {
        return path2;
    }

    public void setPath2(String path2) {
        this.path2 = path2;
    }

    public String getPath3() {
        return path3;
    }

    public void setPath3(String path3) {
        this.path3 = path3;
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
        if (!(o instanceof Video)) return false;
        Video video = (Video) o;
        return Objects.equals(id, video.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", path2='" + path2 + '\'' +
                ", path3='" + path3 + '\'' +
                ", theme=" + theme +
                '}';
    }
}

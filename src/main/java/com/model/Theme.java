package com.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "theme", schema = "spring_t", uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class Theme implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotEmpty
    @Size(min = 5, max = 50)
    @Column(name = "head", unique = false, length = 50, nullable = false)
    private String head;

    @NotEmpty
//    @Temporal(TemporalType.DATE)
    @Column(name = "date", nullable = false, unique = false)
    private LocalDate date;

    @NotEmpty
//    @Temporal(TemporalType.DATE)
    @Column(name = "end_date", nullable = false, unique = false)
    private LocalDate end_date;

    @NotEmpty
    @Size(min = 25, max = 255)
    @Column(name = "description", length = 255, nullable = false, unique = false)
    private String description;

    @OneToOne
    @JoinColumn(name = "fk_f_id", referencedColumnName = "id")
    private Foto foto;

    @OneToOne
    @JoinColumn(name = "fk_v_id", referencedColumnName = "id")
    private Video video;

    @OneToOne
    @JoinColumn(name = "fk_m_id", referencedColumnName = "id")
    private Money money;

    @OneToMany(mappedBy = "theme", cascade = CascadeType.ALL)
    private Set<Like> likes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private User user;

    public Theme() {
    }

    public Theme(@NotEmpty LocalDate date, @NotEmpty LocalDate end_date, @NotEmpty @Size(min = 25, max = 255) String description, Foto foto, Video video, Money money, Set<Like> likes, User user) {
        this.date = date;
        this.end_date = end_date;
        this.description = description;
        this.foto = foto;
        this.video = video;
        this.money = money;
        this.likes = likes;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public Set<Like> getLikes() {
        return likes;
    }

    public void setLikes(Set<Like> likes) {
        this.likes = likes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Theme)) return false;
        Theme theme = (Theme) o;
        return Objects.equals(getId(), theme.getId()) &&
                Objects.equals(getDate(), theme.getDate()) &&
                Objects.equals(getUser(), theme.getUser());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getDate(), getUser());
    }

    @Override
    public String toString() {
        return "Theme{" +
                "id=" + id +
                ", head='" + head + '\'' +
                ", date=" + date +
                ", end_date=" + end_date +
                ", description='" + description + '\'' +
                ", foto=" + foto +
                ", video=" + video +
                ", money=" + money +
                ", likes=" + likes +
                ", user=" + user +
                '}';
    }
}

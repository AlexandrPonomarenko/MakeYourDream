package com.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "card", schema = "spring_t", uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class Card implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @NotEmpty
    @Size(min = 5, max = 15)
    @Column(name = "name_bank", length = 15, unique = false, nullable = false)
    private String name_bank;

    @NotEmpty
    @Size(min = 15, max = 25)
    @Column(name = "number_card", length = 15, unique = false, nullable = false)
    private Integer number_card;

    @ManyToOne
    @JoinColumn(name = "id", nullable = true)
    private User user;

    public Card() {
    }

    public Card(@NotEmpty @Size(min = 5, max = 15) String name_bank, @NotEmpty @Size(min = 15, max = 25) Integer number_card, User user) {
        this.name_bank = name_bank;
        this.number_card = number_card;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName_bank() {
        return name_bank;
    }

    public void setName_bank(String name_bank) {
        this.name_bank = name_bank;
    }

    public Integer getNumber_card() {
        return number_card;
    }

    public void setNumber_card(Integer number_card) {
        this.number_card = number_card;
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
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return Objects.equals(id, card.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name_bank='" + name_bank + '\'' +
                ", number_card=" + number_card +
                ", user=" + user +
                '}';
    }
}

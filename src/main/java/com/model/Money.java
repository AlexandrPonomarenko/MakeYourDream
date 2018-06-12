package com.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "money", schema = "spring_t", uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class Money implements Serializable {
    @Id
    @SequenceGenerator(name = "pc_seq_money", sequenceName = "pc_seq_money", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pc_seq_money")
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private Integer id;

    @Column(name = "quantity", unique = false, nullable = false)
    private Integer quantity;

    @Column(name = "get_money", nullable = false)
    private Integer get_money;

//    @OneToOne(mappedBy = "money", cascade = CascadeType.ALL)
//    private Theme theme;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTheme", nullable = true)
    private Theme theme;

    public Money() {
    }

    public Money(Integer quantity, Integer get_money, Theme theme) {
        this.quantity = quantity;
        this.get_money = get_money;
        this.theme = theme;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getGet_money() {
        return get_money;
    }

    public void setGet_money(Integer get_money) {
        this.get_money = get_money;
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
        if (!(o instanceof Money)) return false;
        Money money = (Money) o;
        return Objects.equals(getId(), money.getId()) &&
                Objects.equals(getTheme(), money.getTheme());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getTheme());
    }

    @Override
    public String toString() {
        return "Money{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", get_money=" + get_money +
                ", theme=" + theme +
                '}';
    }
}

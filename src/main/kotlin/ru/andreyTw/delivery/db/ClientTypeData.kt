package ru.andreyTw.delivery.db;

import jakarta.persistence.*;

@Entity
@Table(name = "CLIENT_TYPE_DATA")
public class ClientTypeData {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "delivery_cost")
    private Integer deliveryCost;

    @Column(name = "discount_value")
    private Integer discountValue;

    @Column(name = "limit_value")
    private Integer limitValue;

    /**
     * Конструктор.
     */
    public ClientTypeData() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(Integer deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public Integer getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(Integer discountValue) {
        this.discountValue = discountValue;
    }

    public Integer getLimitValue() {
        return limitValue;
    }

    public void setLimitValue(Integer limitValue) {
        this.limitValue = limitValue;
    }

    @Override
    public String toString() {
        return "ClientTypeEntity{" +
                "id=" + id +
                ", client_type_name=" + name +
                ", delivery_cost=" + deliveryCost +
                ", discount_value=" + discountValue +
                ", limit_value=" + limitValue +
                "}";
    }
}

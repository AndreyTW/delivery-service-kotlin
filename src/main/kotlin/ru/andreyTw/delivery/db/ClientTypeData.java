package ru.andreyTw.delivery.db;

import jakarta.persistence.*;

@Entity
@Table(name = "CLIENT_TYPE_DATA")
public class ClientTypeData {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "client_type_name")
    private String clientTypeName;

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

    public String getClientTypeName() {
        return clientTypeName;
    }

    public void setClientTypeName(String clientTypeName) {
        this.clientTypeName = clientTypeName;
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
                ", client_type_name=" + clientTypeName +
                ", delivery_cost=" + deliveryCost +
                ", discount_value=" + discountValue +
                ", limit_value=" + limitValue +
                "}";
    }
}

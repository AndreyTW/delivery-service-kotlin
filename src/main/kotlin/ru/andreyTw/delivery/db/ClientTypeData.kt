package ru.andreyTw.delivery.db

import jakarta.persistence.*

@Entity
@Table(name = "CLIENT_TYPE_DATA")
data class ClientTypeData(

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    var id: Long? = null,

    @Column(name = "name")
    var name: String? = null,

    @Column(name = "delivery_cost")
    var deliveryCost: Int? = null,

    @Column(name = "discount_value")
    var discountValue: Int? = null,

    @Column(name = "limit_value")
    var limitValue: Int? = null
) {

    override fun toString(): String =
        "ClientTypeEntity{" +
                "id=" + id +
                ", client_type_name=" + name +
                ", delivery_cost=" + deliveryCost +
                ", discount_value=" + discountValue +
                ", limit_value=" + limitValue +
                "}"
}

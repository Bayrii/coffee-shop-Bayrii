package com.motycka.edu.order
import kotlinx.serialization.Serializable

@Serializable
data class OrderDTO(
    val id: Long,
    val customerId: Long,
    val status: OrderStatus,
    val totalPrice: Double,
    val isPaid: Boolean,
    val menuItems: List<OrderItem>
)

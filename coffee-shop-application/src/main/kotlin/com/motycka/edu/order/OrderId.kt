package com.motycka.edu.order

import kotlinx.serialization.Serializable

@Serializable
data class MenuItem(
    val id: Long,
    val name: String,
    val description: String,
    val price: Double
)



typealias OrderId = Long

enum class OrderStatus {
    PENDING,
    PAID,
    COMPLETED,
    CANCELLED;

    fun canTransitionTo(newStatus: OrderStatus): Boolean {
        return when (this) {
            PENDING -> newStatus == PAID || newStatus == CANCELLED
            PAID -> newStatus == COMPLETED
            COMPLETED, CANCELLED -> false
        }
    }
}

@Serializable
data class OrderCreateItem(
    val menuItemId: Long,
    val quantity: Int
)

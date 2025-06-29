import com.motycka.edu.menu.MenuItemDTO
import com.motycka.edu.order.OrderItemDTO

object PriceCalculator {
    fun calculatePrice(
        menuItems: List<MenuItemDTO>,
        discountInPercent: Double,
        orderItems: List<OrderItemDTO> = emptyList()
    ): Double {
        val menuItemsById = menuItems.associateBy { it.id }

        val originalPrice = orderItems.sumOf { orderItem ->
            val menuItem = menuItemsById[orderItem.menuItemId]
            if (menuItem != null) {
                menuItem.price * orderItem.quantity
            } else {
                0.0
            }
        }

        val finalPrice = originalPrice * (1 - discountInPercent / 100.0)
        return "%.2f".format(finalPrice).toDouble()
    }
}

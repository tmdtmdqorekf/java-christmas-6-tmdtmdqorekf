package christmas.model;

import java.util.List;

public class Customer {
    public static int calculateUserOrderPrice(List<Order> orderList) {
        int userOrderPrice = 0;

        for (Order order : orderList) {
            Menu userOrder = Menu.getMenu(order.food());
            userOrderPrice += getEachPrice(order, userOrder);
        }
        return userOrderPrice;
    }

    private static int getEachPrice(Order order, Menu userOrder) {
        return userOrder.price * order.quantity();
    }
}

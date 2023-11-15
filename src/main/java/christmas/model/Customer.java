package christmas.model;

import static christmas.model.Menu.getMenu;
import static christmas.view.InputView.askVisitDate;

import java.util.List;

public class Customer {
    public static int getUserOrderPrice(List<Order> orderList) {
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

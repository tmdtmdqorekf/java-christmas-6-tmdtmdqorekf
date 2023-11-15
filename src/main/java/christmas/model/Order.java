package christmas.model;

import java.util.Arrays;
import java.util.List;

public record Order(String food, int quantity) {
    public static List<Order> orderList(String orderStr) {
        List<String> orders = Arrays.asList(orderStr.split(","));

        try {
            return orders.stream()
                    .map(order1 -> order1.split("-"))
                    .map(o -> new Order(o[0], Integer.parseInt(o[1])))
                    .toList();
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR]");
        }
    }
}

package christmas.model;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;

public record Order(String food, int quantity) {
    public static List<Order> orderList(String orderStr) {
        List<String> orders = Arrays.asList(orderStr.split(","));

        return orders.stream()
                .map(order -> order.split("-"))
                .map(o -> new Order(o[0], Integer.parseInt(o[1])))
                .toList();
    }
}

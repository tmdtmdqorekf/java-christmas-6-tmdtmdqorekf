package christmas.controller;

import static christmas.model.Customer.calculateUserOrderPrice;
import static christmas.model.Event.calculateTotalDiscount;
import static christmas.view.InputView.*;
import static christmas.view.OutputView.*;
import static christmas.model.Order.*;

import christmas.model.Order;
import christmas.validator.OrderValidator;
import java.text.NumberFormat;
import java.util.List;

public class EventController {
    final int MONTH = 12;

    public void start() {
        printEventPlanner();

        final int VISITDATE = askVisitDate();

        printIntro(MONTH, VISITDATE);
        List<Order> orderList;

        while (true) {
            try {
                orderList = getOrderList();

                OrderValidator validator = new OrderValidator();
                validator.validate(orderList);

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        printOrder(orderList);

        printTotalPriceBeforeDiscount(orderList);

        printGift(getUserOrderPrice(orderList));

        printDiscountList(MONTH, VISITDATE, orderList, getUserOrderPrice(orderList));

        printTotalDiscount(getUserOrderPrice(orderList), MONTH, VISITDATE, orderList);

        printTotalPriceAfterDiscount(getUserOrderPrice(orderList),
                getTotalDiscount(getUserOrderPrice(orderList), MONTH, VISITDATE, orderList));

        printEventBadge(getTotalDiscount(getUserOrderPrice(orderList), MONTH, VISITDATE, orderList));
    }

    public static String formatting(int price) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        return numberFormat.format(price);
    }

    private static List<Order> getOrderList() {
        final List<Order> orderList;
        orderList = orderList(askOrder());

        OrderValidator validator = new OrderValidator();
        validator.validate(orderList);

        return orderList;
    }

    public static int getUserOrderPrice(List<Order> orderList) {
        final int userOrderPrice;
        userOrderPrice = calculateUserOrderPrice(orderList);
        return userOrderPrice;
    }

    private static int getTotalDiscount(int userOrderPrice, int MONTH, int VISITDATE, List<Order> orderList) {
        final int totalDiscount;
        totalDiscount = calculateTotalDiscount(userOrderPrice, MONTH, VISITDATE, orderList);
        return totalDiscount;
    }
}

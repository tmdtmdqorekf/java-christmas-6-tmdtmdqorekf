package christmas.controller;

import static christmas.model.Customer.calculateUserOrderPrice;
import static christmas.view.InputView.*;
import static christmas.view.OutputView.*;
import static christmas.model.Order.*;

import christmas.model.Order;
import java.text.NumberFormat;
import java.util.List;

public class EventController {
    final int MONTH = 12;

    public void start() {
        printEventPlanner();

        final int VISITDATE = askVisitDate();
        printIntro(MONTH, VISITDATE);

        final List<Order> orderList = getOrderList();

        printOrder(orderList);

        printTotalPriceBeforeDiscount(orderList);

        printGift(getUserOrderPrice(orderList));

        printDiscountList(MONTH, VISITDATE, orderList, getUserOrderPrice(orderList));

        printTotalDiscount(getUserOrderPrice(orderList), MONTH, VISITDATE, orderList);
    }

    private static List<Order> getOrderList() {
        final List<Order> orderList;
        orderList = orderList(askOrder());
        return orderList;
    }

    public static String formatting(int price) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        return numberFormat.format(price);
    }

    public static int getUserOrderPrice(List<Order> orderList) {
        final int userOrderPrice;
        userOrderPrice = calculateUserOrderPrice(orderList);
        return userOrderPrice;
    }
}

package christmas.controller;

import static christmas.view.InputView.*;
import static christmas.view.OutputView.*;
import static christmas.model.Customer.*;
import static christmas.model.Order.*;

import christmas.model.Order;
import java.text.NumberFormat;
import java.util.List;

public class EventController {
    final int MONTH = 12;

    public void start() {
        printEventPlanner();
        printIntro(MONTH, getVisitDate());

        final List<Order> orderList = orderList(askOrder());

        printOrder(orderList);

        formatting(getUserOrderPrice(orderList));

        printGift(getUserOrderPrice(orderList));

        printDiscountList(getVisitDate());
    }

    private static int getUserOrderPrice(List<Order> orderList) {
        final int userOrderPrice;
        userOrderPrice = printTotalPriceBeforeDiscount(orderList);
        return userOrderPrice;
    }
}

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

        final int userOrderPrice = printTotalPriceBeforeDiscount(orderList);

        formatting(userOrderPrice);

        printGift(userOrderPrice);


    }
}

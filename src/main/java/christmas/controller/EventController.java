package christmas.controller;

import static christmas.view.InputView.*;
import static christmas.view.OutputView.*;
import static christmas.model.Customer.*;
import static christmas.model.Order.*;

public class EventController {
    final int MONTH = 12;

    public void start() {
        printEventPlanner();
        printIntro(MONTH, getVisitDate());

        printOrder(orderList(askOrder()));
    }
}

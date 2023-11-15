package christmas.controller;

import static christmas.view.InputView.*;
import static christmas.view.OutputView.*;

public class EventController {
    final int MONTH = 12;

    public void start() {
        printEventPlanner();

        final int VISITDATE = askVisitDate();

        String menuStr = askOrder();

        printIntro(MONTH, VISITDATE);
    }
}

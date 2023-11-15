package christmas.controller;

import static christmas.view.InputView.askVisitDate;
import static christmas.view.OutputView.printEventPlanner;
import static christmas.view.OutputView.printIntro;

public class EventController {
    final int MONTH = 12;

    public void start() {
        printEventPlanner();
        final int VISITDATE = askVisitDate();

        printIntro(MONTH, VISITDATE);
    }
}

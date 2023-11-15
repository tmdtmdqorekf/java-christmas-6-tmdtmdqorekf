package christmas.controller;

import static christmas.view.OutputView.*;
import static christmas.model.Customer.*;

public class EventController {
    final int MONTH = 12;

    public void start() {
        printEventPlanner();
        printIntro(MONTH, getVisitDate());

    }
}

package christmas.model;

import static christmas.view.InputView.askVisitDate;

public class Customer {
    public static int getVisitDate() {
        final int VISITDATE = askVisitDate();
        return VISITDATE;
    }
}

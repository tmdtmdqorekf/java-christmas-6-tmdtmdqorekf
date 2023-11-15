package christmas.model;

import static christmas.view.InputView.askOrder;
import static christmas.view.InputView.askVisitDate;

public class Customer {
    public static void getMenuStr() {
        String menuStr = askOrder();
    }
    public static int getVisitDate() {
        final int VISITDATE = askVisitDate();
        return VISITDATE;
    }
}

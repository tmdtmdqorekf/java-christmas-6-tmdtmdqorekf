package christmas.model;

import static christmas.model.Menu.getMenu;
import static christmas.model.Week.getWeekdayOrWeekend;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class Event {
    public static String getChampaign(int userOrderPrice) {
        if (userOrderPrice >= 120000) {
            champaignDiscount();
            return "샴페인 1개";
        }
        return "없음";
    }

    public static void champaignDiscount() {
        int champaignDiscount = 25000;
    }

    public static int getChristmasDiscount(int VISITDATE) {
        if (VISITDATE <= 25) {
            return calculateChristmasDiscount(VISITDATE, getChristmasStartPrice());
        }
        return 0;
    }

    private static int getChristmasStartPrice() {
        return 1000;
    }

    private static int calculateChristmasDiscount(int VISITDATE, int price) {
        for (int i = 1; i < VISITDATE; i++) {
            price += 100;
        }
        return price;
    }

    public static int getWeekdayDiscount(int MONTH, int VISITDATE, List<Order> orderList) {
        // 평일 할인 (일~목) -> 디저트 2023원 할인
        LocalDate date = LocalDate.of(2023, MONTH, VISITDATE);
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        Week week = getWeekdayOrWeekend(dayOfWeek.name());

        if (week.weekdayOrWeekend.equals("평일")) {
            return calculateIfWeekday(orderList);
        }
        return 0;
    }

    private static int calculateIfWeekday(List<Order> orderList) {
        int weekdayDiscount = 0;
        for (Order order : orderList) {
            Menu userOrder = getMenu(order.food());
            weekdayDiscount += calculateIfDessert(order, userOrder, weekdayDiscount);
        }
        return weekdayDiscount;
    }

    private static int calculateIfDessert(Order order, Menu userOrder, int weekdayDiscount) {
        if ("디저트".equals(userOrder.type)) {
            return 2023 * order.quantity();
        }
        return 0;
    }
}
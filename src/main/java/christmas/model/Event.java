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
        return getDiscount(MONTH, VISITDATE, orderList, "평일", Event::calculateIfDessert);
    }

    public static int getWeekendDiscount(int MONTH, int VISITDATE, List<Order> orderList) {
        return getDiscount(MONTH, VISITDATE, orderList, "주말", Event::calculateIfMain);
    }

    private static int getDiscount(int MONTH, int VISITDATE, List<Order> orderList, String dayType, DiscountCalculator calculator) {
        LocalDate date = LocalDate.of(2023, MONTH, VISITDATE);
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        Week week = getWeekdayOrWeekend(dayOfWeek.name());

        if (week.weekdayOrWeekend.equals(dayType)) {
            int discount = 0;
            for (Order order : orderList) {
                Menu userOrder = getMenu(order.food());
                discount += calculator.calculate(order, userOrder);
            }
            return discount;
        }
        return 0;
    }

    private static int calculateIfDessert(Order order, Menu userOrder) {
        if ("디저트".equals(userOrder.type)) {
            return 2023 * order.quantity();
        }
        return 0;
    }

    private static int calculateIfMain(Order order, Menu userOrder) {
        if ("메인".equals(userOrder.type)) {
            return 2023 * order.quantity();
        }
        return 0;
    }

    @FunctionalInterface
    private interface DiscountCalculator {
        int calculate(Order order, Menu userOrder);
    }

}
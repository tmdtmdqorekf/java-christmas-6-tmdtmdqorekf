package christmas.view;

import static christmas.controller.EventController.formatting;
import static christmas.controller.EventController.getUserOrderPrice;
import static christmas.model.Customer.calculateTotalPriceAfterDiscount;
import static christmas.model.Event.calculateTotalDiscount;
import static christmas.model.Event.getChampaign;
import static christmas.model.Event.getChampaignDiscount;
import static christmas.model.Event.getChristmasDiscount;
import static christmas.model.Event.getSpecialDiscount;
import static christmas.model.Event.getWeekdayDiscount;
import static christmas.model.Event.getWeekendDiscount;

import christmas.model.Order;
import java.util.List;

public class OutputView {
    public static void printEventPlanner() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printIntro(int MONTH, int VISITDATE) {
        System.out.printf("%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n", MONTH, VISITDATE);
    }

    public static void printOrder(List<Order> orderList) {
        System.out.println("\n<주문 메뉴>");
        printEachOrder(orderList);
    }

    private static void printEachOrder(List<Order> orderList) {
        orderList.forEach(order -> System.out.println(order.food() + " " + order.quantity() + "개"));
    }

    public static void printTotalPriceBeforeDiscount(List<Order> orderList) {
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.printf("%s원\n", formatting(getUserOrderPrice(orderList)));
    }

    public static void printGift(int userOrderPrice) {
        System.out.println("\n<증정 메뉴>");
        System.out.println(getChampaign(userOrderPrice));
    }

    public static void printDiscountList(int MONTH, int VISITDATE, List<Order> orderList, int userOrderPrice) {
        System.out.println("\n<혜택 내역>");
        if (isZero(MONTH, VISITDATE, orderList, userOrderPrice)) {
            System.out.println("없음");
        } else if (!isZero(MONTH, VISITDATE, orderList, userOrderPrice)) {
            isNotZero(MONTH, VISITDATE, orderList, userOrderPrice);
        }
    }

    private static void isNotZero(int MONTH, int VISITDATE, List<Order> orderList, int userOrderPrice) {
        if (getChristmasDiscount(VISITDATE) != 0) {
            printChristmasDiscount(VISITDATE);
        }
        if (getWeekdayDiscount(MONTH, VISITDATE, orderList) != 0) {
            printWeekdayDiscount(MONTH, VISITDATE, orderList);
        }
        if (getWeekendDiscount(MONTH, VISITDATE, orderList) != 0) {
            printWeekendDiscount(MONTH, VISITDATE, orderList);
        }
        if (getSpecialDiscount(MONTH, VISITDATE) != 0) {
            printSpecialDiscount(MONTH, VISITDATE);
        }
        if (getChampaignDiscount(userOrderPrice) != 0) {
            printChampaignDiscount(userOrderPrice);
        }
    }

    private static boolean isZero(int MONTH, int VISITDATE, List<Order> orderList, int userOrderPrice) {
        return getChampaign(userOrderPrice).equals("없음")
                && getChristmasDiscount(VISITDATE) == 0
                && getWeekdayDiscount(MONTH, VISITDATE, orderList) == 0
                && getWeekdayDiscount(MONTH, VISITDATE, orderList) == 0
                && getSpecialDiscount(MONTH, VISITDATE) == 0
                && getChampaignDiscount(userOrderPrice) == 0;
    }

    private static void printChristmasDiscount(int VISITDATE) {
        System.out.printf("크리스마스 디데이 할인: -%s원", formatting(getChristmasDiscount(VISITDATE)));
    }

    private static void printWeekdayDiscount(int MONTH, int VISITDATE, List<Order> orderList) {
        System.out.printf("\n평일 할인: -%s원", formatting(getWeekdayDiscount(MONTH, VISITDATE, orderList)));
    }

    private static void printWeekendDiscount(int MONTH, int VISITDATE, List<Order> orderList) {
        System.out.printf("\n주말 할인: -%s원", formatting(getWeekendDiscount(MONTH, VISITDATE, orderList)));
    }

    private static void printSpecialDiscount(int MONTH, int VISITDATE) {
        System.out.printf("\n특별 할인: -%s원", formatting(getSpecialDiscount(MONTH, VISITDATE)));
    }

    private static void printChampaignDiscount(int userOrderPrice) {
        System.out.printf("\n증정 이벤트: -%s원\n", formatting(getChampaignDiscount(userOrderPrice)));
    }

    public static void printTotalDiscount(int userOrderPrice, int MONTH, int VISITDATE, List<Order> orderList) {
        System.out.println("\n<총혜택 금액>");

        if (calculateTotalDiscount(userOrderPrice, MONTH, VISITDATE, orderList) == 0) {
            System.out.printf("%s원\n", formatting(calculateTotalDiscount(userOrderPrice, MONTH, VISITDATE, orderList)));
        }
        else if (calculateTotalDiscount(userOrderPrice, MONTH, VISITDATE, orderList) != 0) {
            System.out.printf("-%s원\n", formatting(calculateTotalDiscount(userOrderPrice, MONTH, VISITDATE, orderList)));
        }
    }

    public static void printTotalPriceAfterDiscount(int userOrderPrice, int totalDiscount) {
        System.out.println("\n<할인 후 예상 결제 금액>");
        System.out.printf("%s원\n", formatting(calculateTotalPriceAfterDiscount(userOrderPrice, totalDiscount)));

    }

    public static void printEventBadge(int totalDiscount) {
        System.out.println("\n<12월 이벤트 배지>");
        if (totalDiscount < 5000) {
            System.out.println("없음");
        } else if (totalDiscount >= 5000 && totalDiscount < 10000) {
            System.out.println("별");
        } else if (totalDiscount >= 10000 && totalDiscount < 20000) {
            System.out.println("트리");
        } else if (totalDiscount >= 20000) {
            System.out.println("산타");
        }
    }
}

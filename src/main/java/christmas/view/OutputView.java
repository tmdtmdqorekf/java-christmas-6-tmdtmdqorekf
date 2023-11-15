package christmas.view;

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

    }

    public static void printGift() {
        System.out.println("\n<증정 메뉴>");
    }

    public static void printDiscountList() {
        System.out.println("\n<혜택 내역>");
    }

    public static void printChristmasDiscount() {
        System.out.println("크리스마스 디데이 할인: ");
    }

    public static void printWeekdayDiscount() {
        System.out.println("평일 할인: ");
    }

    public static void printWeekendDiscount() {
        System.out.println("주말 할인: ");
    }

    public static void printSpecialDiscount() {
        System.out.println("특별 할인: ");
    }

    public static void printGiftDiscount() {
        System.out.println("증정 이벤트: ");
    }

    public static void printTotalDiscount() {
        System.out.println("\n<총혜택 금액>");
    }

    public static void printTotalPriceAfterDiscount() {
        System.out.println("\n<할인 후 예상 결제 금액>");
    }

    public static void printEventBadge() {
        System.out.println("\n<12월 이벤트 배지>");
    }
}

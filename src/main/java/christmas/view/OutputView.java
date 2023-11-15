package christmas.view;

import static christmas.controller.EventController.formatting;
import static christmas.model.Customer.getUserOrderPrice;
import static christmas.model.Event.getChampaign;
import static christmas.model.Event.getChristmasDiscount;
import static christmas.model.Event.getWeekdayDiscount;

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

    public static int printTotalPriceBeforeDiscount(List<Order> orderList) {
        System.out.println("\n<할인 전 총주문 금액>");

        return getUserOrderPrice(orderList);
    }

    public static void printGift(int userOrderPrice) {
        System.out.println("\n<증정 메뉴>");
        System.out.println(getChampaign(userOrderPrice));
    }

    public static void printDiscountList(int MONTH, int VISITDATE, List<Order> orderList) {
        System.out.println("\n<혜택 내역>");
        printChristmasDiscount(VISITDATE);
        printWeekdayDiscount(MONTH, VISITDATE, orderList);
        printWeekendDiscount();
        printSpecialDiscount();
        printGiftDiscount();

    }

    private static void printChristmasDiscount(int VISITDATE) {
        System.out.printf("크리스마스 디데이 할인: -%s원", formatting(getChristmasDiscount(VISITDATE)));
    }

    private static void printWeekdayDiscount(int MONTH, int VISITDATE, List<Order> orderList) {
        System.out.printf("\n평일 할인: -%s원", formatting(getWeekdayDiscount(MONTH, VISITDATE, orderList)));
    }

    private static void printWeekendDiscount() {
        System.out.printf("\n주말 할인: -%s원", );
    }

    private static void printSpecialDiscount() {
        System.out.printf("\n특별 할인: -%s원", );
    }

    private static void printGiftDiscount() {
        System.out.printf("\n증정 이벤트: -%s원", );
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

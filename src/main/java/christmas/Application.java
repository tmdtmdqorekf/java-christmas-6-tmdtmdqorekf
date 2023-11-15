package christmas;

import christmas.controller.EventController;

public class Application {
    public static void main(String[] args) {
//        int totalDiscount = 0;
//
//        System.out.println("\n<혜택 내역>");
//        if (hasChristmasDiscount) {
//            System.out.println("크리스마스 디데이 할인: " + numberFormat.format(-christmasDiscount) + "원");
//            totalDiscount += christmasDiscount;
//        }
//        if (hasWeekdayDiscount) {
//            System.out.println("평일 할인: " + numberFormat.format(-weekdayDiscount) + "원");
//            totalDiscount += weekdayDiscount;
//        }
//        if (hasWeekendDiscount) {
//            System.out.println("주말 할인: " + numberFormat.format(-weekendDiscount) + "원");
//            totalDiscount += weekendDiscount;
//        }
//        if (hasStarDiscount) {
//            System.out.println("특별 할인: " + numberFormat.format(-starDiscount) + "원");
//            totalDiscount += starDiscount;
//        }
//        if (hasChampaignDiscount) {
//            System.out.println("증정 이벤트: " + numberFormat.format(-champaignDiscount) + "원");
//            totalDiscount += champaignDiscount;
//        }
//        if (!hasChristmasDiscount && !hasWeekdayDiscount && !hasWeekendDiscount && !hasStarDiscount
//                && !hasChampaignDiscount) {
//            System.out.println("없음");
//        }
//
//        // TODO: 총혜택 금액 계산 및 출력
//        System.out.println("\n<총혜택 금액>");
//        System.out.println(numberFormat.format(-totalDiscount) + "원");
//
//        // TODO: 할인 후 예상 결제 금액 계산 및 출력
//        System.out.println("\n<할인 후 예상 결제 금액>");
//        System.out.println(numberFormat.format(userOrderPrice) + "원");
//
//        // TODO: 12월 이벤트 배지 계산 및 출력
//        System.out.println("\n<12월 이벤트 배지>");
//        if (totalDiscount >= 5000) {
//            System.out.println("별");
//        }
//        else if (totalDiscount >= 10000) {
//            System.out.println("트리");
//        }
//        else if (totalDiscount >= 20000) {
//            System.out.println("산타");
//        }
//        else {
//            System.out.println("없음");
//        }
    EventController eventController = new EventController();
    eventController.start();
    }
}

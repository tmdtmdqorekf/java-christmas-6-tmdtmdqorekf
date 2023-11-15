package christmas;

import christmas.controller.EventController;

public class Application {
    public static void main(String[] args) {
//        // TODO: 총혜택 금액 계산 및 출력
//        System.out.println("\n<총혜택 금액>");
//        System.out.println(numberFormat.format(-totalDiscount) + "원");

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

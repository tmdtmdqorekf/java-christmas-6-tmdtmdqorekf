package christmas;

import camp.nextstep.edu.missionutils.Console;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    static class Order {
        private String food;
        private int quantity;

        public Order(String food, int quantity) {
            this.food = food;
            this.quantity = quantity;
        }

        public String getFood() {
            return food;
        }

        public int getQuantity() {
            return quantity;
        }
    }

    public enum Menu {
        양송이수프("애피타이저", 6_000),
        타파스("애피타이저", 5_500),
        시저샐러드("애피타이저", 8_000),
        티본스테이크("메인", 55_000),
        바비큐립("메인", 54_000),
        해산물파스타("메인", 35_000),
        크리스마스파스타("메인", 25_000),
        초코케이크("디저트", 15_000),
        아이스크림("디저트", 5_000),
        제로콜라("음료", 3_000),
        레드와인("음료", 60_000),
        샴페인("음료", 25_000);

        private final String type;
        private final int price;

        Menu(String type, int price) {
            this.type = type;
            this.price = price;
        }
    }

    private static Menu getMenu(String menuName) {
        for (Menu menu : Menu.values()) {
            if (menu.name().equals(menuName)) {
                return menu;
            }
        }
        return null;
    }

    public enum Week {
        일요일(1, "평일", true),
        월요일(2, "평일", false),
        화요일(3, "평일", false),
        수요일(4, "평일", false),
        목요일(5, "평일", false),
        금요일(6, "주말", false),
        토요일(7, "주말", false);

        private final int weekNum;
        private final String weekdayOrWeekend;
        private final boolean starDay;

        Week(int weekNum, String weekdayOrWeekend, boolean starDay) {
            this.weekNum = weekNum;
            this.weekdayOrWeekend = weekdayOrWeekend;
            this.starDay = starDay;
        }
    }

    private static Week getWeekdayOrWeekend(String week) {
        for (Week day : Week.values()) {
            if (day.weekdayOrWeekend.equals(week)) {
                return day;
            }
        }
        return null;
    }

    private static Week getStarDay(boolean isStar) {
        for (Week day : Week.values()) {
            if (day.starDay == isStar) {
                return day;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        final int month = 12;

        // TODO: 우테코 식당 소개 출력
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");

        // TODO: 예상 방문 날짜 입력 받기
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String visitDateStr = Console.readLine();
        final int visitDate = Integer.parseInt(visitDateStr);

        // TODO: 주문 메뉴, 메뉴 개수 입력 받기
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1");
        String menuStr = Console.readLine();

        // TODO: 우테코 식당 인트로 출력
        System.out.println(month + "월 " + visitDate + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");

        // TODO: 주문 메뉴 계산 및 출력
        List<String> orders = Arrays.asList(menuStr.split(","));
        List<Order> orderList = orders.stream()
                .map(order -> order.split("-"))
                .map(o -> new Order(o[0], Integer.parseInt(o[1])))
                .collect(Collectors.toList());

        System.out.println("\n<주문 메뉴>");
        orderList.forEach(order -> System.out.println(order.getFood() + " " + order.getQuantity() + "개"));

        // TODO: 할인 전 총주문 금액 계산 및 출력
        int userOrderPrice = 0;
        int eachPrice = 0;

        for (int i = 0; i<orderList.size(); i++) {
            Menu userOrder = getMenu(orderList.get(i).getFood());
            eachPrice = (userOrder.price * orderList.get(i).getQuantity());
            userOrderPrice += eachPrice;
        }

        NumberFormat numberFormat = NumberFormat.getInstance();

        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(numberFormat.format(userOrderPrice) + "원");

        // TODO: 증정 메뉴 계산 및 출력
        System.out.println("\n<증정 메뉴>");

        if (userOrderPrice >= 120000) {
            System.out.println("샴페인 1개");
        }
        else {
            System.out.println("없음");
        }

        // TODO: 혜택 내역 계산 및 출력
        // 크리스마스 디데이 할인 -> 1000원 시작, 25일까지 100원 증가
        int christmasDiscount = 1000;
        boolean hasChristmasDiscount = false;

        if (visitDate <= 25) {
            for (int i = 1; i < visitDate; i++) {
                christmasDiscount += 100;
                hasChristmasDiscount = true;
            }
        }

        // 평일 할인 (일~목) -> 디저트 2023원 할인

        for (int i = 0; i<orderList.size(); i++) {
            Menu userOrder = getMenu(orderList.get(i).getFood());
            userOrderType = userOrder.type;
        }

        // 주말 할인 (금,토) -> 메인 2023원 할인

        // 특별 할인 (일, 25) -> 총주문에서 1000원 할인

        System.out.println("\n<혜택 내역>");
        if (hasChristmasDiscount == true) {
            System.out.println("크리스마스 디데이 할인: -" + numberFormat.format(christmasDiscount) + "원");
        }
        System.out.println("평일 할인: -");
        System.out.println("주말 할인: -");
        System.out.println("증정 이벤트: ");

        // TODO: 총혜택 금액 계산 및 출력

        // TODO: 할인 후 예상 결제 금액 계산 및 출력

        // TODO: 12월 이벤트 배지 계산 및 출력
    }
}

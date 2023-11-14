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

    public static void main(String[] args) {
        final int month = 12;

        // TODO: 우테코 식당 소개 출력
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");

        // TODO: 예상 방문 날짜 입력 받기
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String visitDateStr = Console.readLine();
        int visitDate = Integer.parseInt(visitDateStr);

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

        for (int i = 0; i<orderList.size(); i++) {
            Menu userOrder = getMenu(orderList.get(i).getFood());
            userOrderPrice += userOrder.price;
        }

        NumberFormat numberFormat = NumberFormat.getInstance();

        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(numberFormat.format(userOrderPrice) + "원");

        // TODO: 증정 메뉴 계산 및 출력
        int champaignCount = 0;

        if (userOrderPrice >= 120000) {
            champaignCount++;
        }
        else if (userOrderPrice >= 240000) {
            champaignCount++;
        }
        else if (userOrderPrice >= 360000) {
            champaignCount++;
        }
        else if (userOrderPrice >= 480000) {
            champaignCount++;
        }

        System.out.println("\n<증정 메뉴>");

        if (champaignCount == 0) {
            System.out.println("없음");
        }
        else {
            System.out.println("샴페인 " + champaignCount + "개");
        }

        // TODO: 혜택 내역 계산 및 출력

        // TODO: 총혜택 금액 계산 및 출력

        // TODO: 할인 후 예상 결제 금액 계산 및 출력

        // TODO: 12월 이벤트 배지 계산 및 출력
    }
}

package christmas;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    static class Menu {
        private String food;
        private int quantity;

        public Menu(String food, int quantity) {
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
        List<String> menus = Arrays.asList(menuStr.split(","));
        List<Menu> menuList = menus.stream()
                .map(menu -> menu.split("-"))
                .map(m -> new Menu(m[0], Integer.parseInt(m[1])))
                .collect(Collectors.toList());

        System.out.println("<주문 메뉴>");
        menuList.forEach(menu -> System.out.println(menu.getFood() + " " + menu.getQuantity() + "개"));

        // TODO: 할인 전 총주문 금액 계산 및 출력

        // TODO: 증정 메뉴 계산 및 출력

        // TODO: 혜택 내역 계산 및 출력

        // TODO: 총혜택 금액 계산 및 출력

        // TODO: 할인 후 예상 결제 금액 계산 및 출력

        // TODO: 12월 이벤트 배지 계산 및 출력
    }
}

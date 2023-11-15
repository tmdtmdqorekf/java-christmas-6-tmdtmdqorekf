package christmas.validator;

import christmas.model.Menu;
import christmas.model.Order;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderValidator implements BasicValidator<List<Order>> {
    @Override
    public void validate(List<Order> input) {
        Set<String> sameFoods = new HashSet<>();

        for (Order order : input) {
            isInMenu(order.food());
            isQuantityRangeValid(order.quantity());
            isString(order.food());
            isDuplicated(order.food(), sameFoods);
        }
    }

    public void isInMenu(String food) {
        boolean inMenu = false;

        for (Menu menu : Menu.values()) {
            if (menu.name().equals(food)) {
                inMenu = true;
                break;
            }
        }

        if (!inMenu) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public void isQuantityRangeValid(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public void isString(String food) {
        if (food == null && food.getClass() == String.class) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public void isDuplicated(String food, Set<String> sameFoods) {
        if (!sameFoods.add(food)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}

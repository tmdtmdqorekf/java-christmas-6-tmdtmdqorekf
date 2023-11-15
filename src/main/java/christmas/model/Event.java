package christmas.model;

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
}

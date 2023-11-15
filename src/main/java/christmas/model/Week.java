package christmas.model;

public enum Week {
    일("SUNDAY", "평일", true),
    월("MONDAY", "평일", false),
    화("TUESDAY", "평일", false),
    수("WEDNESDAY", "평일", false),
    목("THURSDAY", "평일", false),
    금("FRIDAY", "주말", false),
    토("SATURDAY", "주말", false);

    private final String weekName;
    final String weekdayOrWeekend;
    private final boolean isStarDay;

    Week(String weekName, String weekdayOrWeekend, boolean isStarDay) {
        this.weekName = weekName;
        this.weekdayOrWeekend = weekdayOrWeekend;
        this.isStarDay = isStarDay;
    }

    static Week getWeekdayOrWeekend(String dayOfWeek) {
        for (Week day : Week.values()) {
            if (day.weekName.equals(dayOfWeek)) {
                return day;
            }
        }
        return null;
    }
}

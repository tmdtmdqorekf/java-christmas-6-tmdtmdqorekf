package christmas.model;

import java.time.DayOfWeek;
import java.time.LocalDate;

public enum Week {
    일("SUNDAY", "평일"),
    월("MONDAY", "평일"),
    화("TUESDAY", "평일"),
    수("WEDNESDAY", "평일"),
    목("THURSDAY", "평일"),
    금("FRIDAY", "주말"),
    토("SATURDAY", "주말");

    final String weekName;
    final String weekdayOrWeekend;

    Week(String weekName, String weekdayOrWeekend) {
        this.weekName = weekName;
        this.weekdayOrWeekend = weekdayOrWeekend;
    }

    static Week getWeekdayOrWeekend(String dayOfWeek) {
        for (Week day : Week.values()) {
            if (day.weekName.equals(dayOfWeek)) {
                return day;
            }
        }
        return null;
    }

    static Week getWeek(int MONTH, int VISITDATE) {
        LocalDate date = LocalDate.of(2023, MONTH, VISITDATE);
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        return getWeekdayOrWeekend(dayOfWeek.name());
    }
}

package neoflex.task.vacation_calculator.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Set;

public class WorkdayUtil {

    public static int countWorkdays(LocalDate startDate, int daysDuration, Set <LocalDate> holidays) {
        LocalDate endDate = startDate.plusDays(daysDuration);
        return (int) startDate
                      .datesUntil(endDate)
                      .filter(date -> isWorkday(date, holidays))
                      .count();
    }

    private static boolean isWorkday(LocalDate date, Set<LocalDate> holidays) {
        DayOfWeek day = date.getDayOfWeek();
        return day != DayOfWeek.SATURDAY &&
               day != DayOfWeek.SUNDAY &&
               !holidays.contains(date);
    }

}

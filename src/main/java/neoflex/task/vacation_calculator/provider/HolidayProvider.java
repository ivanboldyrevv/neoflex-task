package neoflex.task.vacation_calculator.provider;

import java.util.Set;
import java.time.LocalDate;


public interface HolidayProvider {
    Set<LocalDate> getHolidays();
}

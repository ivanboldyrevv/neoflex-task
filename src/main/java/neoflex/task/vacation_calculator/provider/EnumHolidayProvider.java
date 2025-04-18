package neoflex.task.vacation_calculator.provider;

import neoflex.task.vacation_calculator.util.EnumHoliday;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.time.LocalDate;

@Component
public class EnumHolidayProvider implements HolidayProvider {
    
    @Override
    public Set<LocalDate> getHolidays() {
        return EnumHoliday.getAll();
    }
}

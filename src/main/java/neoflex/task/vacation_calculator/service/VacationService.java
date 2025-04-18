package neoflex.task.vacation_calculator.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import neoflex.task.vacation_calculator.provider.HolidayProvider;
import neoflex.task.vacation_calculator.util.WorkdayUtil;

import java.time.LocalDate;
import java.util.Set;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class VacationService {

    private static final BigDecimal DAYS_IN_MONTH = BigDecimal.valueOf(29.3);
    private final Set<LocalDate> productionCalendar;

    @Autowired
    public VacationService(HolidayProvider holidayProvider) {
        this.productionCalendar = holidayProvider.getHolidays();
    }

    public double calculate(double averageSalary, int vacationDays) {
        BigDecimal roundedAverageSalary = roundToScale(averageSalary);
        BigDecimal vacationDaysBigDecimal = BigDecimal.valueOf(vacationDays);
        
        return calculateVacationSalary(roundedAverageSalary, vacationDaysBigDecimal);
    }

    public double calculate(double averageSalary, int vacationDays, LocalDate startDate) {
        BigDecimal roundedAverageSalary = roundToScale(averageSalary);
        BigDecimal workdaysBigDecimal = BigDecimal.valueOf(
            WorkdayUtil.countWorkdays(startDate, vacationDays, productionCalendar));
        
        return calculateVacationSalary(roundedAverageSalary, workdaysBigDecimal);
    }

    private static BigDecimal roundToScale(double salary) {
        return BigDecimal.valueOf(salary)
                         .setScale(2, RoundingMode.HALF_UP);
    }

    private double calculateVacationSalary(BigDecimal salary, BigDecimal vacationDays) {
        return salary.divide(DAYS_IN_MONTH, 4, RoundingMode.HALF_UP)
                     .multiply(vacationDays)
                     .setScale(2, RoundingMode.HALF_UP)
                     .doubleValue();
    }
}

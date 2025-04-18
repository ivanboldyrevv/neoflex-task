package neoflex.task.vacation_calculator.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import neoflex.task.vacation_calculator.provider.HolidayProvider;
import neoflex.task.vacation_calculator.util.WorkdayUtil;

import java.time.LocalDate;
import java.util.Set;


@Service
public class VacationService {
    Set<LocalDate> productionCalendar;

    @Autowired
    public VacationService(HolidayProvider holidayProvider) {
        this.productionCalendar = holidayProvider.getHolidays();
    }

    public double calculate(double averageSalary, int vacationDays) {
        return (averageSalary / 29.3) * vacationDays;
    }

    public double calculate(double averageSalary, int vacationDays, LocalDate startDate) {
        int workdays = (int) WorkdayUtil.countWorkdays(startDate, vacationDays, productionCalendar);
        return (averageSalary / 29.3) * workdays;
    }

}

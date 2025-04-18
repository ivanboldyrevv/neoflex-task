package neoflex.task.vacation_calculator;

import neoflex.task.vacation_calculator.provider.EnumHolidayProvider;
import neoflex.task.vacation_calculator.service.VacationService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

public class VacationServiceIntegrationTests {
    
    VacationService service;

    @BeforeEach
    void SetUp() {
        EnumHolidayProvider holidayProvider = new EnumHolidayProvider();
        service = new VacationService(holidayProvider);
    }

    @Test
    void calculateSalary_withHoliday_returnsExpectedSalary() {
        double averageSalary = 29_300, result;

        result = service.calculate(averageSalary, 8, LocalDate.of(2025, 01, 01));
        assertEquals(0, result, 0.1);

        result = service.calculate(averageSalary, 1, LocalDate.of(2025, 02, 23));
        assertEquals(0, result, 0.1);
    }
}

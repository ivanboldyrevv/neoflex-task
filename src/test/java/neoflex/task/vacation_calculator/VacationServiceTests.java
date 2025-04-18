package neoflex.task.vacation_calculator;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import neoflex.task.vacation_calculator.provider.HolidayProvider;
import neoflex.task.vacation_calculator.service.VacationService;

import org.mockito.Mockito;
import static org.mockito.Mockito.when;

@SpringBootTest
public class VacationServiceTests {

    VacationService service;

    @BeforeEach
    void setUp() {
        HolidayProvider mockProvider = Mockito.mock(HolidayProvider.class);
        Set<LocalDate> mockHolidays = Set.of(LocalDate.of(2025, 4, 24));
        when(mockProvider.getHolidays()).thenReturn(mockHolidays);

        service = new VacationService(mockProvider);
    }

    @Test
    void calculateSalary_noWeekendsAndHolidays_returnsExpectedSalary() {
        double result = service.calculate(29300, 10);
        assertEquals(10_000, result, 0.001);
    }

    @Test
    void calculateSalary_withWeekends_returnsExpectedSalary() {
        LocalDate startDate = LocalDate.of(2025, 04, 14);
        double result = service.calculate(29300, 7, startDate);
        assertEquals(5_000, result, 0.001);
    }

    @Test
    void calculateSalary_withHoliday_returnsExpectedSalary() {
        LocalDate startDate = LocalDate.of(2025, 4, 21);
        double result = service.calculate(29_300, 5, startDate);
        assertEquals(4_000, result, 0.01);
    }

    @Test
    void calculateSalary_withHoliday_withWeekens_returnsExpectedSalary() {        
        LocalDate startDate = LocalDate.of(2025, 4, 21);
        double result = service.calculate(29_300, 7, startDate);
        assertEquals(4_000, result, 0.1);
    }
    
}

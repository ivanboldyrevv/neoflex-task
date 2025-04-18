package neoflex.task.vacation_calculator;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

import java.time.LocalDate;
import neoflex.task.vacation_calculator.util.WorkdayUtil;


@SpringBootTest
public class WorkdayUtilTest {
    Set<LocalDate> mockHolidays;

    @BeforeEach
    public void setUp() {
        mockHolidays = new HashSet<LocalDate>();
    }

    @Test
    void countWorkdays_noWeekends_noHolidays_returnsExpectedCount() {
        int result = WorkdayUtil.countWorkdays(LocalDate.of(2025, 4, 14), 5, mockHolidays);
        assertEquals(5, result);
    }

    @Test
    void countWorkdays_withWeekends_noHolidays_returnsExpectedCount() {
        int result = WorkdayUtil.countWorkdays(LocalDate.of(2025, 04, 14), 7, mockHolidays);
        assertEquals(5, result);
    }

    @Test
    void countWorkdays_noWeekends_withHolidays_returnsExpectedCount() {
        mockHolidays.add(LocalDate.of(2025, 04, 14));
        int result = WorkdayUtil.countWorkdays(LocalDate.of(2025, 04, 14), 5, mockHolidays);
        assertEquals(4, result);
    }

    @Test
    void countWorkdays_withWeekends_withHolidays_returnsExpectedCount() {
        mockHolidays.add(LocalDate.of(2025, 04, 14));
        int result = WorkdayUtil.countWorkdays(LocalDate.of(2025, 04, 14), 7, mockHolidays);
        assertEquals(4, result);
    }

}

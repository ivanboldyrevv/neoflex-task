package neoflex.task.vacation_calculator.util;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public enum EnumHoliday {
    NEW_YEAR(LocalDate.of(2025, 1, 1), LocalDate.of(2025, 1, 8)),
    DEFENDER_DAY(LocalDate.of(2025, 2, 23)),
    WOMEN_DAY(LocalDate.of(2025, 3, 8)),
    LABOR_DAY(LocalDate.of(2025, 5, 1), LocalDate.of(2025, 5, 2)),
    VICTORY_DAY(LocalDate.of(2025, 5, 9)),
    RUSSIA_DAY(LocalDate.of(2025, 6, 12)),
    NATIONAL_UNITY(LocalDate.of(2025, 11, 4));

    private final LocalDate start;
    private final LocalDate end;

    EnumHoliday(LocalDate date) {
        this.start = date;
        this.end = date;
    }

    EnumHoliday(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }

    public Stream<LocalDate> getDates() {
        return start.datesUntil(end.plusDays(1));
    }

    public static Set<LocalDate> getAll() {
        return Stream.of(values())
                .flatMap(EnumHoliday::getDates)
                .collect(Collectors.toSet());
    }
}

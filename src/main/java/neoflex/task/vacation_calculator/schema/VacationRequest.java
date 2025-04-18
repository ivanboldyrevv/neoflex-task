package neoflex.task.vacation_calculator.schema;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


public class VacationRequest {
    private double averageSalary;
    private int vacationDays;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startVacationDate;

    
    public void setAverageSalary(double averageSalary) {
        this.averageSalary = averageSalary;
    }

    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }

    public void setStartVacationDate(LocalDate startVacationDate) {
        this.startVacationDate = startVacationDate;
    }

    public double getAverageSalary() {
        return averageSalary;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    public LocalDate getStartVacation() {
        return startVacationDate;
    }

}

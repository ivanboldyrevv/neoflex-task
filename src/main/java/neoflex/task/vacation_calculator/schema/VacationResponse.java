package neoflex.task.vacation_calculator.schema;

import io.swagger.v3.oas.annotations.media.Schema;

public class VacationResponse {
    @Schema(description="Vacation salary sum", example="14500.00")
    private double vacationSalary;

    public VacationResponse(double vacationSalary) {
        this.vacationSalary = vacationSalary;
    }

    public void setVacationSalary(double vacationSalary) {
        this.vacationSalary = vacationSalary;
    }

    public double getVacationSalary() {
        return vacationSalary;
    }

}

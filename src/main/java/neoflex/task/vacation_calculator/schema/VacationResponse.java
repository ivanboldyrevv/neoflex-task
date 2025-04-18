package neoflex.task.vacation_calculator.schema;


public class VacationResponse {
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

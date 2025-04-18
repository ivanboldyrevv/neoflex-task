package neoflex.task.vacation_calculator.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

import neoflex.task.vacation_calculator.schema.VacationResponse;
import neoflex.task.vacation_calculator.service.VacationService;

@RestController
@RequestMapping("/calculate")
@Validated
public class VacationController {

    private final VacationService service;

    @Autowired
    public VacationController(VacationService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(
        description=("Calculate vacation pay based on average salary, vacation duration and vacation start date.")
    )
    public VacationResponse calculateVacationSalary(
            @Parameter(description="Positive average salary.", example="30000.99")
            @RequestParam
            @Positive(message="averageSalary should be above 0.")
            double averageSalary,

            @Parameter(description="Positive duration in days.", example="10")
            @RequestParam
            @Positive(message="vacationDays should be above 0.")
            int vacationDays,

            @Parameter(description="Start vacation date in ISO format.", example="2025-04-18")
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate startVacation
    ) {
        double vacationSalary = (startVacation != null)
        ? service.calculate(averageSalary, vacationDays, startVacation)
        : service.calculate(averageSalary, vacationDays);

        return new VacationResponse(vacationSalary);
    }

}

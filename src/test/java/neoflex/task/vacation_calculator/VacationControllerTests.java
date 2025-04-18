package neoflex.task.vacation_calculator;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import neoflex.task.vacation_calculator.service.VacationService;
import neoflex.task.vacation_calculator.controller.VacationController;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(VacationController.class)
@Import(TestValidationConfig.class)
public class VacationControllerTests {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VacationService service;

    @Test
    void validRequest_shouldReturnOK() throws Exception {
        when(service.calculate(29_300, 10)).thenAnswer(invocation -> {
            return 10000.0;
        });

        mockMvc.perform(MockMvcRequestBuilders.get("/calculate")
                .param("averageSalary", "29300")
                .param("vacationDays", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.vacationSalary").value(10_000.00));
    }

    @Test
    void validRequest_withStartVacation_shouldReturnOK() throws Exception {
        LocalDate startVacation = LocalDate.of(2025, 4, 14);
        when(service.calculate(29_300, 7, startVacation)).thenAnswer(invocation -> {
            return 5_000.0;
        });

        mockMvc.perform(MockMvcRequestBuilders.get("/calculate")
                .param("averageSalary", "29300")
                .param("vacationDays", "7")
                .param("startVacation", "2025-04-14"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.vacationSalary").value(5_000.00));
    }

    @Test
    void invalidVacationDays_shouldReturnBadRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculate")
                .param("averageSalary", "30000")
                .param("vacationDays", "0"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors").value("vacationDays should be above 0."));
    }

    @Test
    void invalidAverageSalary_shouldReturnBadRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculate")
                .param("averageSalary", "-10")
                .param("vacationDays", "10"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors").value("averageSalary should be above 0."));
    }
}

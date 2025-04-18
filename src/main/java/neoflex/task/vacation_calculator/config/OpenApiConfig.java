package neoflex.task.vacation_calculator.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;;

@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI vacationApi() {
        return new OpenAPI()
            .info(new Info()
                    .title("Vacation Salary Calculator REST API")
                    .description(
                        "This is a task for admission to neoflex-study courses. " +
                        "REST API application that implements the logic of calculating vacation pay")
                    .version("1.0.0"));
    }
}

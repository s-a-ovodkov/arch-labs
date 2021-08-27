package ru.otus.ovodkov.task02.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация OpenAPI v3
 *
 * @author Ovodkov Sergey
 * created on 25.07.2021
 */
@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI customOpenApi() {
    return new OpenAPI()
        .components(new Components())
        .info(new Info()
            .title("TASK#02")
            .version("v1")
            .description("Минимальный сервис для курса")
        );
  }
}

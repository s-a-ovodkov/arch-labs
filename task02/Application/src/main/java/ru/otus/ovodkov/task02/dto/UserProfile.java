package ru.otus.ovodkov.task02.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Модель представления данных пользователя
 *
 * @author Ovodkov Sergey created on 22.07.2021
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserProfile {

  @Schema(description = "Идентификатор пользователя", example = "327")
  private Long id;

  @Schema(description = "Логин пользователя", example = "velzepup")
  private String username;

  @Schema(description = "Имя пользователя", example = "Иван")
  private String firstName;

  @Schema(description = "Фамилия пользователя", example = "Сидоров")
  private String lastName;

  @Schema(description = "Email пользователя", example = "test@mail.qa")
  private String email;

  @Schema(description = "Телефон пользователя", example = "+79001112233")
  private String phone;
}

package ru.otus.ovodkov.task02.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.otus.ovodkov.task02.dto.UserProfile;
import ru.otus.ovodkov.task02.models.User;
import ru.otus.ovodkov.task02.services.UserService;

/**
 * Контроллер API для работы с пользователями
 *
 * @author Ovodkov Sergey created on 25.07.2021
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("user")
@Tag(name = "user", description = "Набор методов для работы с пользователями")
public class UserController {

  private final UserService service;

  @Operation(
      summary = "Создание нового пользователя",
      description = "Создание нового пользователя, в ответ приходит ID нового пользователя")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "ID пользователя", content = @Content)
      })
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Long> createUser(
      @Parameter(description = "Данные добавляемого пользователя") @RequestBody
          UserProfile userProfile) {
    return ResponseEntity.ok(service.createUser(userProfile));
  }

  @Operation(
      summary = "Получить данные пользователя",
      description = "Получить данные пользователя с указанным ID")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Данные пользователя",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = UserProfile.class))
            }),
        @ApiResponse(
            responseCode = "404",
            description = "Пользователь с указанным ID не найден",
            content = @Content)
      })
  @GetMapping("/{userId}")
  public ResponseEntity<UserProfile> getUser(
      @Parameter(description = "ID пользователя") @PathVariable("userId") Long userId) {
    return ResponseEntity.ok(service.getUser(userId));
  }

  @Operation(
      summary = "Удалить пользователя",
      description = "Удалить пользователя с указанным идентификатором")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Пользователь успешно удален",
            content = @Content),
        @ApiResponse(
            responseCode = "404",
            description = "Пользователь с указанным ID не найден",
            content = @Content)
      })
  @DeleteMapping("/{userId}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteUSer(
      @Parameter(description = "ID пользователя") @PathVariable("userId") Long userId) {
    service.deleteUser(userId);
  }

  @Operation(
      summary = "Обновить данные пользователя",
      description = "Обновить данные указанного пользователя")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Данные успешно обновлены",
            content = @Content),
        @ApiResponse(
            responseCode = "404",
            description = "Пользователь с указанным ID не найден",
            content = @Content)
      })
  @PutMapping("/{userId}")
  @ResponseStatus(HttpStatus.OK)
  public void updateUser(
      @Parameter(description = "ID пользователя") @PathVariable("userId") Long userId,
      @Parameter(description = "Данные пользователя") @RequestBody UserProfile userProfile) {
    userProfile.setId(userId);
    service.updateUser(userProfile);
  }
}

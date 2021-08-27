package ru.otus.ovodkov.task02.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.ovodkov.task02.datahelper.UserDataHelper;
import ru.otus.ovodkov.task02.dto.UserProfile;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/** @author Ovodkov Sergey created on 26.07.2021 */
@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Проверка API профиля пользователя")
class UserControllerTest {

  @Autowired private MockMvc mockMvc;

  @Autowired private UserDataHelper dataHelper;

  @AfterEach
  void deleteUsers() {
    dataHelper.deleteUsers();
  }

  @Test
  @SneakyThrows
  @DisplayName("Получения данных пользователя по идентификатору")
  void getUserProfile_isOk() {
    Long id = dataHelper.createAndSave();

    mockMvc
        .perform(get("/user/" + id).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.username").value(UserDataHelper.USERNAME))
        .andExpect(jsonPath("$.firstName").value(UserDataHelper.FIRSTNAME))
        .andExpect(jsonPath("$.lastName").value(UserDataHelper.LASTNAME))
        .andExpect(jsonPath("$.email").value(UserDataHelper.EMAIL))
        .andExpect(jsonPath("$.phone").value(UserDataHelper.PHONE));
  }

  @Test
  @SneakyThrows
  @DisplayName("Создание профиля пользователя")
  void saveUserProfile_isOk() {
    UserProfile user = dataHelper.createUserProfile();

    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    ObjectWriter writer = mapper.writer().withDefaultPrettyPrinter();
    String requestJson = writer.writeValueAsString(user);

    mockMvc.perform(
            post("/user/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)
                .accept(MediaType.APPLICATION_JSON)
    )
        .andExpect(status().isOk());
  }

  @Test
  @SneakyThrows
  @DisplayName("Удаление пользователя по идентификатору")
  void deleteUserProfile_isOk() {
    Long id = dataHelper.createAndSave();

    mockMvc
        .perform(delete("/user/" + id).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }
}

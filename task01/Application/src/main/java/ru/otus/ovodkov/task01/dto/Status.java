package ru.otus.ovodkov.task01.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.otus.ovodkov.task01.enums.StatusCode;

/**
 * Статус работы приложения
 *
 * @author Ovodkov Sergey created on 18.07.2021
 */
@Getter
@AllArgsConstructor
public class Status {
  private final StatusCode status;
}

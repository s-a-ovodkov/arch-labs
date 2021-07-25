package ru.otus.ovodkov.task02.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Доменное исключение для случая если искомая сущность не найдена
 *
 * @author Ovodkov Sergey created on 22.07.2021
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoEntityException extends RuntimeException {
  private final String entityName;
  private final String key;
  private final String keyValue;

  public NoEntityException(String entityName, String key, String keyValue) {
    this.entityName = entityName;
    this.key = key;
    this.keyValue = keyValue;
  }

  @Override
  public String toString() {
    return "'" + entityName + "' entity by key '" + key + " = " + keyValue + "' not found.";
  }
}

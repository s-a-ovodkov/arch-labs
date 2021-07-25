package ru.otus.ovodkov.task02.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Глобальный обработчик доменных исключений
 *
 * @author Ovodkov Sergey created on 25.07.2021
 */
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(NoEntityException.class)
  protected ResponseEntity<String> handleNoEntityException(NoEntityException exc) {
    log.warn(exc.toString());
    return new ResponseEntity<>(exc.toString(), HttpStatus.NOT_FOUND);
  }
}

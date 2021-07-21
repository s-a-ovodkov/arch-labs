package ru.otus.ovodkov.task01.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.ovodkov.task01.dto.Status;
import ru.otus.ovodkov.task01.enums.StatusCode;

/** @author Ovodkov Sergey created on 18.07.2021 */
@RestController
@RequestMapping("health")
public class HealthController {

  @GetMapping
  public ResponseEntity<Status> getStatus() {
    return ResponseEntity.ok(new Status(StatusCode.OK));
  }
}

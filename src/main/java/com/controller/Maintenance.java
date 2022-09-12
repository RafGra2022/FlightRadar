package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/maintenance")
public class Maintenance {

  @GetMapping(path = "/ping")
  public String ping() {
    return "pong";
  }
}

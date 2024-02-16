package com.pratica12.pilotos.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PilotoController {
  
  @RequestMapping("/hello") 
  public String getHello() {
    return "Hello, Piloto!";
  }
}
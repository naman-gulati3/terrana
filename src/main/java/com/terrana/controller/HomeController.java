package com.terrana.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class HomeController {

  @GetMapping("/")
  public RedirectView directToCollections() {
    return new RedirectView("/collections/shop_all");
  }
}

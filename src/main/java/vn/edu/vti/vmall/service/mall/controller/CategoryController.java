package vn.edu.vti.vmall.service.mall.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "/api/v1/categories")
public class CategoryController {
  @GetMapping
  public ResponseEntity<String> getCategories(){
    log.info("(getCategories)Getting all categories: [{}]", SecurityContextHolder.getContext().getAuthentication().getName());
    return ResponseEntity.ok("Categories");
  }
}

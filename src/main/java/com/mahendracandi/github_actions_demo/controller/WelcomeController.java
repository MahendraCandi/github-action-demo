package com.mahendracandi.github_actions_demo.controller;

import com.mahendracandi.github_actions_demo.dtos.ResultDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping(value = "/welcome", produces = "application/json")
    public ResponseEntity<ResultDto> welcome() {
        ResultDto result = new ResultDto();
        result.setMessage("Welcome to Github Actions Demo!");
        return ResponseEntity.ok(result);
    }
}

package com.mahendracandi.github_actions_demo.controller;

import com.mahendracandi.github_actions_demo.dtos.ResultDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

    @GetMapping(value = "/welcome", produces = "application/json")
    public ResponseEntity<ResultDto> welcome(@RequestParam(value = "name", required = false) String name) {
        ResultDto result = new ResultDto();

        if (StringUtils.hasLength(name)) {
            result.setMessage("Welcome to Github Actions Demo, " + name + "!");
        } else {
            result.setMessage("Welcome to Github Actions Demo!");
        }
        return ResponseEntity.ok(result);
    }
}

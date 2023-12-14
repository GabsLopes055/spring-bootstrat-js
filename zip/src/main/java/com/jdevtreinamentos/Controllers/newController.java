package com.jdevtreinamentos.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class newController {

    @GetMapping
    @RequestMapping("/{name}")
    public ResponseEntity<String> newController(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body("Projeto Criado por: " + name);
    }

}

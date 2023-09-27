package com.example.demo.controllers;

import com.example.demo.models.Robot;
import com.example.demo.services.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/robot")
public class RobotController {
    private final RobotService service;

    @Autowired
    public RobotController(final RobotService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Robot> findAll() {
        return service.findAll();
    }

    @GetMapping("/search-with-sort") // /robot/search-with-sort?sort=132
    public Iterable<Robot> findAllWithSort(@RequestParam(required = false) String sort) {
        System.out.println(sort);
        return service.findAllWithSort();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody Robot robot) {
        if (robot.getName() == null) {
            robot.setName("Default name");
        }
        return service.save(robot);
    }

    @PutMapping
    public String updateGreeter(@RequestBody Robot robot) {
        if (robot.getId() == null) {
            throw new IllegalArgumentException();
        }
        return service.update(robot);
    }

    @DeleteMapping("/{id}") // /robot/{id}
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}

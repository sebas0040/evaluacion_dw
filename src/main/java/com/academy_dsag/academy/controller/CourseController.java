package com.academy_dsag.academy.controller;

import com.academy_dsag.academy.dto.CourseResponse;
import com.academy_dsag.academy.dto.CreateCourseRequest;
import com.academy_dsag.academy.service.CourseService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseResponse create(@Valid @RequestBody CreateCourseRequest request) {
        return service.create(request);
    }

    // LIST
    @GetMapping
    public List<CourseResponse> list() {
        return service.list();
    }
}
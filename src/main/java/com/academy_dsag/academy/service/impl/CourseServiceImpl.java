package com.academy_dsag.academy.service.impl;

import com.academy_dsag.academy.dto.CreateCourseRequest;
import com.academy_dsag.academy.dto.CourseResponse;
import com.academy_dsag.academy.entity.course;
import com.academy_dsag.academy.repository.courseRepository;
import com.academy_dsag.academy.service.CourseService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final courseRepository repository;

    public CourseServiceImpl(courseRepository repository) {
        this.repository = repository;
    }

    @Override
    public CourseResponse create(CreateCourseRequest request) {

        // DTO → Entity
        course course = new course();
        course.setName(request.getName());
        course.setDescription(request.getDescription());
        course.setPrice(request.getPrice());

        // Guardar en BD
        course saved = repository.save(course);

        // Entity → Response
        return toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseResponse> list() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // Mapper
    private CourseResponse toResponse(course c) {
        CourseResponse r = new CourseResponse();
        r.setId(c.getId());
        r.setName(c.getName());
        r.setDescription(c.getDescription());
        r.setPrice(c.getPrice());
        r.setCreatedAt(c.getCreatedAt());
        r.setUpdatedAt(c.getUpdatedAt());
        return r;
    }
}
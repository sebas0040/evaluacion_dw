package com.academy_dsag.academy.service;

import com.academy_dsag.academy.dto.CreateCourseRequest;
import com.academy_dsag.academy.dto.CourseResponse;
import java.util.List;

public interface CourseService {

    CourseResponse create(CreateCourseRequest request);

    List<CourseResponse> list();
}
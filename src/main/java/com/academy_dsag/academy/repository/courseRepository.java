package com.academy_dsag.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.academy_dsag.academy.entity.course;

public interface courseRepository extends JpaRepository<course, Long> {
}
package com.springdemo.n09springdatajpa.repository;

import com.springdemo.n09springdatajpa.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

  Page<Course> findByTitleContaining(String title, Pageable pageRequest);

}

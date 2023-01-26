package com.springdemo.n04springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

  @GetMapping("/courses")
  public List<Course> retrieveAllCourses() {
    return Arrays.asList(
            new Course(1, "Learn Spring", "Rod Johnson"),
            new Course(2, "The DevOps Handbook", "Gene Kim"),
            new Course(3, "aaaa", "ffff"),
            new Course(3, "aaaa", "fffft444"),
            new Course(3, "aaaa", "ffff55555")
    );
  }
}

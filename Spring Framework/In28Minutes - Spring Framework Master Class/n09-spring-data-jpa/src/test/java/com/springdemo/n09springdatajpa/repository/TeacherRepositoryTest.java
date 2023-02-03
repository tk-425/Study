package com.springdemo.n09springdatajpa.repository;

import com.springdemo.n09springdatajpa.entity.Course;
import com.springdemo.n09springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeacherRepositoryTest {

  @Autowired
  private TeacherRepository teacherRepository;

  @Autowired
  private CourseRepository courseRepository;

  @Test
  public void saveTeachers() {
    Teacher teacher = Teacher.builder()
            .firstName("Ryan")
            .lastName("Thompson")
//            .courses(List.of(getCourses().get(0)))
            .build();

    teacherRepository.save(teacher);
  }

  /* ---- Helper Method ---- */
  private List<Course> getCourses() {
    return courseRepository.findAll();
  }







}
package com.springdemo.n09springdatajpa.repository;

import com.springdemo.n09springdatajpa.entity.Course;
import com.springdemo.n09springdatajpa.entity.Student;
import com.springdemo.n09springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

  @Autowired
  private CourseRepository courseRepository;

  @Test
  public void printCourses() {
    List<Course> courses = courseRepository.findAll();

    printCourses(courses, "courses =");
    System.out.println();
  }

  @Test
  public void saveCourseWithTeacher() {
    Teacher teacher = Teacher.builder()
            .firstName("Dustin")
            .lastName("Johnson")
            .build();

    Course course = Course.builder()
            .title("Swift")
            .credit(3)
            .teacher(teacher)
            .build();

    courseRepository.save(course);
  }

  @Test
  public void findAllPagination() {
    /*--- 1st Page of 3 courses --- */
    Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);

    List<Course> coursesFirstPage = courseRepository.findAll(firstPageWithThreeRecords).getContent();

    long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
    long totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();

    System.out.println("\ntotalElements = " + totalElements);
    System.out.println("totalPages = " + totalPages);
    printCourses(coursesFirstPage, "Find All - 1st page, 3 course:");


    /*--- 2nd Page of 2 courses --- */
    Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

    List<Course> coursesSecondPage = courseRepository.findAll(secondPageWithTwoRecords).getContent();

    totalElements = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();
    totalPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();

    System.out.println("\ntotalElements = " + totalElements);
    System.out.println("totalPages = " + totalPages);
    printCourses(coursesSecondPage, "Find All - 2nd page, 2 courses:");
  }

  @Test
  public void findAllSorting() {
    Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));

    Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());

    Pageable sortByTitleAndCreditDesc =
            PageRequest.of(
                    0,
                    2,
                    Sort.by("title")
                    .descending()
                    .and(Sort.by("credit"))
            );

    List<Course> coursesSortByTitle = courseRepository.findAll(sortByTitle).getContent();
    List<Course> coursesSortByCreditDesc = courseRepository.findAll(sortByCreditDesc).getContent();
    List<Course> coursesSortByTitleAndCreditDesc = courseRepository.findAll(sortByTitleAndCreditDesc).getContent();


    printCourses(coursesSortByTitle, "Find All - Sort by Title:");
    printCourses(coursesSortByCreditDesc, "Find All - Sort by Credit Descending:");
    printCourses(coursesSortByTitleAndCreditDesc, "Find All - Sort by Title Descending Order and Credit:");
  }

  @Test
  public void findByTitleContainingTest() {
    Pageable firstPageTenRecords = PageRequest.of(0, 10);

    List<Course> course = courseRepository.findByTitleContaining("a", firstPageTenRecords).getContent();

    printCourses(course, "Find All - By Title containing a letter 'a'");
  }

  @Test
  public void saveCourseWithStudentAndTeacher() {
    Teacher teacher = Teacher.builder()
            .firstName("Linda")
            .lastName("Johnson")
            .build();

    Course course = Course.builder()
            .title("AI")
            .credit(6)
            .teacher(teacher)
            .build();

    Student student = Student.builder()
            .firstName("Jason")
            .lastName("Kidd")
            .emailId("jk@mail.com")
            .build();

    course.addStudents(student);

    courseRepository.save(course);
  }

  /* ---- Helper Methods ---- */
  private void printCourses(List<Course> courses, String text) {
    System.out.println("\n" + text);
    for (Course course : courses) {
      System.out.println(course);
    }
    System.out.println();
  }
}
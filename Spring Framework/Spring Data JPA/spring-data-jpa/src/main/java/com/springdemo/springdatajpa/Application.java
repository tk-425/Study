package com.springdemo.springdatajpa;

import com.github.javafaker.Faker;
import com.springdemo.springdatajpa.entity.*;
import com.springdemo.springdatajpa.repository.StudentIdCardRepository;
import com.springdemo.springdatajpa.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }


  @Bean
  CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
    return args -> {

      Student student = new Student(
          "Tiger",
          "Woods",
          "tk@mail.com",
          28);

      Book cleanCode = new Book(
          "Clean Code",
          LocalDateTime.now().minusDays(4));

      Book javaCookbook = new Book(
          "Java Cookbook",
          LocalDateTime.now().minusDays(5));

      Book springDataJPA = new Book(
          "Spring Data JPA",
          LocalDateTime.now().minusDays(10));

      // add books to student
      student.addBook(cleanCode);
      student.addBook(javaCookbook);
      student.addBook(springDataJPA);

      StudentIdCard studentIdCard = new StudentIdCard(
          "tw0011",
          student);

      // set student id card to the student
      student.setStudentIdCard(studentIdCard);

      // add courses
      student.addEnrollment(new Enrollment(
          new EnrollmentId(student.getId(), 1L),
          student,
          new Course("CS101", "IT")));

      student.addEnrollment(new Enrollment(
          new EnrollmentId(student.getId(), 2L),
          student,
          new Course("STAT400", "MATH")));

      // save enrollment to the student
      studentRepository.save(student);

      // get all students and print their name and courses
      List<Student> allStudents = studentRepository.findAll();
      allStudents.forEach(s -> {
        System.out.println("--- Name: " + s.getFirstName());
        System.out.println("--- Courses: " + s.getEnrollments());});

      /* Getting Books */
      // option 1 - fetch type = LAZY
      studentRepository.findById(1L)
          .ifPresent(s -> {
            System.out.println("fetch book lazy...");
            List<Book> books = student.getBooks();
            books.forEach(book -> {
              System.out.println(s.getFirstName() + " borrowed " + book.getBookName());
            });
          });

      // option 2 - fetch type = EAGER
      Student studentId1L = studentRepository.findByIdAndJoinBookColumn(1L);
      System.out.println("Found a student with ID 1: " + studentId1L);

      // get the list of books from the fetched student object
      List<Book> studentBooks = studentId1L.getBooks();
      studentBooks.forEach(book -> {
        System.out.println(studentId1L.getFirstName() +
            " borrowed " + book.getBookName());});
    };
  }

  private void generateStudents(StudentRepository studentRepository) {
    Faker faker = new Faker();
    for (int i = 0; i < 20; i++) {
      String firstName = faker.name().firstName();
      String lastName = faker.name().lastName();
      String email = String.format("%s%s@mail.com", firstName, lastName);

      Student student = new Student(
          firstName,
          lastName,
          email,
          faker.number().numberBetween(18, 58));

      studentRepository.save(student);
    }
  }

  private void findAndDeleteById(StudentRepository studentRepository,
                                 StudentIdCardRepository studentIdCardRepository) {

    studentRepository.findById(1L).ifPresent(System.out::println);

    studentIdCardRepository.findById(1L).ifPresent(System.out::println);

    System.out.println("---- Deleting ID 1 ----");
    studentRepository.deleteById(1L);
  }

}

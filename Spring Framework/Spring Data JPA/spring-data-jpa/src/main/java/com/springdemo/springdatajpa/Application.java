package com.springdemo.springdatajpa;

import com.github.javafaker.Faker;
import com.springdemo.springdatajpa.entity.Book;
import com.springdemo.springdatajpa.entity.Course;
import com.springdemo.springdatajpa.entity.Student;
import com.springdemo.springdatajpa.entity.StudentIdCard;
import com.springdemo.springdatajpa.repository.StudentIdCardRepository;
import com.springdemo.springdatajpa.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }


  @Bean
  CommandLineRunner commandLineRunner(
          StudentRepository studentRepository) {
    return args -> {

      Student student = new Student(
              "Tiger",
              "Woods",
              "tk@mail.com",
              28
      );

      Book cleanCode = new Book(
              "Clean Code",
              LocalDateTime.now().minusDays(4)
      );

      Book javaCookbook = new Book(
              "Java Cookbook",
              LocalDateTime.now().minusDays(5)
      );

      Book springDataJPA = new Book(
              "Spring Data JPA",
              LocalDateTime.now().minusDays(10)
      );

      student.addBook(cleanCode);
      student.addBook(javaCookbook);
      student.addBook(springDataJPA);

      StudentIdCard studentIdCard = new StudentIdCard(
              "tw0011",
              student
      );

      student.setStudentIdCard(studentIdCard);

      student.enrollToCourse(new Course("CS101", "IT"));
      student.enrollToCourse(new Course("STAT400", "MATH"));

      studentRepository.save(student);


      studentRepository.findById(1L).ifPresent(System.out::println);

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
      Student student1L = studentRepository.findByIdAndJoinBookColumn(1L);
      System.out.println("Found a student with ID 1: " + student1L);

      List<Book> studentBooks = student1L.getBooks();
      studentBooks.forEach(book -> {
        System.out.println(student1L.getFirstName() + " borrowed " + book.getBookName());
      });


    };
  }

  private void generateStudents(StudentRepository studentRepository) {
    Faker faker = new Faker();
    for (int i = 0; i < 20 ; i++) {
      String firstName = faker.name().firstName();
      String lastName = faker.name().lastName();
      String email = String.format("%s%s@mail.com", firstName, lastName);

      Student student = new Student(
              firstName,
              lastName,
              email,
              faker.number().numberBetween(18, 58)
      );

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

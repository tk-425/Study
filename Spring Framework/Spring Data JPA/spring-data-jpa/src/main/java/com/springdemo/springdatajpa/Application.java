package com.springdemo.springdatajpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }


  @Bean
  CommandLineRunner commandLineRunner(StudentRepository repository) {
    return args -> {
      repository.saveAll(getStudents());

      String email = "tw@mail.com";

      repository.findStudentByEmail(email)
              .ifPresentOrElse(
                      student -> {
                        System.out.println("--- Student found: " + student);
                      },
                      () -> {
                        System.out.println("--- Student with " + email + " not found.");
                      });


      System.out.println("--- Find student whose first name is Dustin and 38 years old: ");
      repository.findStudentByFirstNameEqualsAndAgeEquals("Dustin", 38)
              .forEach(System.out::println);

      System.out.println("---- Find student whose first name is Tom and 20 years old: ");
      repository.findStudentByFirstNameEqualsAndAgeEquals("Tom", 20)
              .forEach(System.out::println);

      System.out.println("---- Find student whose first name is Tom and age is greater than 18 years old: ");
      repository.findStudentByFirstNameEqualsAndAgeIsGreaterThan("Tom", 18)
              .forEach(System.out::println);
    };
  }

  private List<Student> getStudents() {
    Student tomK = Student.builder()
            .firstName("Tom")
            .lastName("Kim")
            .email("tk@mail.com")
            .age(20)
            .build();

    Student tigerW = Student.builder()
            .firstName("Tiger")
            .lastName("Woods")
            .email("tw@mail.com")
            .age(47)
            .build();

    Student dustinJ = Student.builder()
            .firstName("Dustin")
            .lastName("Johnson")
            .email("dj@mail.com")
            .age(38)
            .build();

    Student tomH = Student.builder()
            .firstName("Tom")
            .lastName("Hoge")
            .email("th@mail.com")
            .age(33)
            .build();

    return List.of(tomK, tigerW, dustinJ, tomH);
  }

  private void basicQuery(StudentRepository repository) {
    System.out.println("--- Adding 3 Students ---");
    repository.saveAll(getStudents());

    countAll(repository);

    System.out.println("---- Find Students ----");
    repository.findById(2L)
            .ifPresentOrElse(student -> {
              System.out.println("Student with ID 2: " + student);
            }, () -> {
              System.out.println("Student with ID 2 not found");
            });

    repository.findById(4L)
            .ifPresentOrElse(student -> {
              System.out.println("Student ID 4: " + student);
            }, () -> {
              System.out.println("Student with ID 4 not found");
            });

    printAll(repository);

    System.out.println("---- Delete Student with ID 1 ---");
    repository.deleteById(1L);

    countAll(repository);

    printAll(repository);
  }

  private void countAll(StudentRepository repository) {
    System.out.println("*** Student Count: " + repository.count());
  }

  private void printAll(StudentRepository repository) {
    System.out.println("---- Select All Students ----");
    List<Student> students = repository.findAll();
    students.forEach(System.out::println);

  }
}

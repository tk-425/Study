package com.springdemo.springdatajpa;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }


  @Bean
  CommandLineRunner commandLineRunner(StudentRepository repository) {
    return args -> {
      generateStudents(repository);
      paging(repository);
    };
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

  private void customQuery(StudentRepository repository) {
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

    System.out.println("---- Native Query - " +
            "Find student whose first name is Tom and age is greater than 18 years old:");
    repository.findStudentByFirstNameEqualsAndAgeIsGreaterThanNative("Tom", 18)
            .forEach(System.out::println);

    System.out.println("---- Delete Student Id 4");
    System.out.println("# of Rows Affected: " + repository.deleteStudentById(4L));
  }

  private void generateStudents(StudentRepository repository) {
    Faker faker = new Faker();
    for (int i = 0; i < 20 ; i++) {
      String firstName = faker.name().firstName();
      String lastName = faker.name().lastName();
      String email = String.format("%s%s@mail.com", firstName, lastName);

      Student student = Student.builder()
              .firstName(firstName)
              .lastName(lastName)
              .email(email)
              .age(faker.number().numberBetween(18, 58))
              .build();

      repository.save(student);
    }
  }

  // Sorting
  private void sortByFirstNameAsc(StudentRepository repository) {
    System.out.println("---- Sort by First Name Ascending ----");

    Sort sort = Sort.by(Sort.Direction.ASC, "firstName");
    repository.findAll(sort)
            .forEach(student -> System.out.println(student.getFirstName()));
  }

  private void sortByFirstNameAscAndAgeDesc(StudentRepository repository) {
    System.out.println("---- Sort by First Name Ascending & Age Descending ----");

    Sort sort = Sort.by("firstName").ascending()
            .and(Sort.by("age").descending());

    repository.findAll(sort)
            .forEach(student -> System.out.println(student.getFirstName() + " " + student.getAge()));
  }

  // Pagination
  private void paging(StudentRepository repository) {
    PageRequest pageRequest = PageRequest.of(0, 5, Sort.by("firstName").ascending());

    Page<Student> page = repository.findAll(pageRequest);

    System.out.println("---- Total # of Students ----");
    System.out.println(repository.count());

    System.out.println("*** First Page with 5 Students ***");
    page.forEach(System.out::println);
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

  private void countAll(StudentRepository repository) {
    System.out.println("*** Student Count: " + repository.count());
  }

  private void printAll(StudentRepository repository) {
    System.out.println("---- Select All Students ----");
    List<Student> students = repository.findAll();
    students.forEach(System.out::println);

  }
}

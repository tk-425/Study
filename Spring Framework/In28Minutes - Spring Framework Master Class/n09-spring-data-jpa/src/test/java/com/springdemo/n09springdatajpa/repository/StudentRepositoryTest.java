package com.springdemo.n09springdatajpa.repository;

import com.springdemo.n09springdatajpa.entity.Guardian;
import com.springdemo.n09springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.util.Streamable;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

  @Autowired
  private StudentRepository studentRepository;

  @Test
  public void saveStudent() {
    Student student = Student.builder()
            .firstName("John")
            .lastName("Lee")
            .emailId("johnlee@mail.com")
            .build();

    studentRepository.save(student);
  }

  @Test
  public void saveStudentWithGuardian() {
    Guardian guardian = Guardian.builder()
            .name("Tammy")
            .email("tammy@mail.com")
            .mobile("100-200-3000")
            .build();

    Student student = Student.builder()
            .firstName("George")
            .lastName("Mason")
            .emailId("gmason@mail.com")
            .guardian(guardian)
            .build();

    studentRepository.save(student);
  }

  @Test
  public void saveStudentWithoutLastName() {
    Student student = Student.builder()
            .firstName("Tiger")
            .emailId("tigerwood@mail.com")
            .build();

    studentRepository.save(student);
  }

  @Test
  public void printAllStudents() {
    List<Student> list = studentRepository.findAll();

    System.out.println("\nAll StudentList:");
    printList(list);
  }

  @Test
  public void printStudentByFirstName() {
    List<Student> list = studentRepository.findByFirstName("John");

    System.out.println("\nFind by first name with 'John':\n");
    printList(list);
  }

  @Test
  public void printStudentByFirstNameContaining() {
    Streamable<Student> list = studentRepository.findByFirstNameContaining("oh");

    System.out.println("\nStudent name that contains 'oh':");
    printStreamable(list);
  }

  @Test
  public void printStudentByFirstAndLastNameContaining() {
    Streamable<Student> list = studentRepository.findByFirstNameContaining("oh")
            .and(studentRepository.findByLastNameContaining("son"));

    System.out.println("\nStudent name that contains 'oh' from first name" +
            " and 'son' from last name:");
    printStreamable(list);
  }

  @Test
  public void printStudentByLastNameNotNull() {
    Streamable<Student> list = studentRepository.findByLastNameNotNull();

    System.out.println("\nStudent List with Last Name:");
    printStreamable(list);
  }

  @Test
  public void printStudentByGuardianName() {
    Streamable<Student> list = studentRepository.findByGuardianName("Tammy");

    System.out.println("\nStudent List with 'Tammy' as a Guardian:");
    printStreamable(list);
  }

  // JPQL Test
  @Test
  public void printGetStudentByEmailAddress() {
    Student student = studentRepository.getStudentByEmailAddress("johnlee@mail.com");

    System.out.println("\nStudent with 'johnlee@mail.com' email:");
    System.out.println(student.toString() + "\n");
  }

  @Test
  public void printFirstNameByEmailAddress() {
    String firstName = studentRepository.getStudentFirstNameByEmailAddress("tigerwood@mail.com");

    System.out.println("\nStudent's first name: " + firstName + "\n");
  }

  // Native Query Test
  @Test
  public void printGetStudentByEmailAddressNative() {
    Student student = studentRepository.getStudentsByEmailAddressNative("tigerwood@mail.com");

    System.out.println("\nStudent with 'tigerwood@mail.com' email:");
    System.out.println(student.toString() + "\n");
  }

  @Test
  public void printGetStudentByEmailAddressNativeNamed() {
    Student student = studentRepository.getStudentsByEmailAddressNative("johnlee@mail.com");

    System.out.println("\nStudent with 'johnlee@mail.com' email:");
    System.out.println(student.toString() + "\n");
  }

  // Modifying
  @Test
  public void updateStudentNameByEmailIdTest() {
    int update = studentRepository.updateStudentNameByEmailId("Johnny", "johnlee@mail.com");
    System.out.println("\nNumber of updated row: " + update + "\n");
  }

  @Test
  public void updateStudentNameByEmailIdTestNative() {
    int update = studentRepository.updateStudentNameByEmailIdNative("Joe", "johnlee@mail.com");
    System.out.println("\nNumber of updated row: " + update + "\n");
  }


  /* ---- Helper Methods ---- */
  private void printList(List<Student> list) {
    for (Student student: list) {
      System.out.println(student);
    }
    System.out.println();
  }

  private void printStreamable(Streamable<Student> list) {
    for (Student student: list) {
      System.out.println(student);
    }
    System.out.println();
  }
}
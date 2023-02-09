package com.springdemo.springdatajpa.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "Student")
@Table(
        name = "student",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "student_email_unique",
                        columnNames = "email"
                )
        }
)
public class Student {

  @Id
  @SequenceGenerator(
          name = "student_sequence",
          sequenceName = "student_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = SEQUENCE,
          generator = "student_sequence"
  )
  @Column(
          name = "id",
          updatable = false
  )
  private Long id;

  @Column(
          name = "first_name",
          nullable = false,
          columnDefinition = "TEXT"
  )
  private String firstName;

  @Column(
          name = "last_name",
          nullable = false,
          columnDefinition = "TEXT"
  )
  private String lastName;

  @Column(
          name = "email",
          nullable = false,
          columnDefinition = "TEXT"
  )
  private String email;

  @Column(
          name = "age",
          nullable = false
  )
  private Integer age;

  // Bidirectional relationship
  // StudentIdCard is the owning entity
  @OneToOne(
          mappedBy = "student",
          orphanRemoval = true,
          cascade = {
                  CascadeType.PERSIST, CascadeType.REMOVE
          }
  )
  private StudentIdCard studentIdCard;

  @OneToMany(
          mappedBy = "student",
          orphanRemoval = true,
          cascade = {
                  CascadeType.PERSIST, CascadeType.REMOVE
          },
          fetch = FetchType.LAZY
  )
  private List<Book> books = new ArrayList<>();

  @ManyToMany(
          cascade = {
                  CascadeType.PERSIST, CascadeType.REMOVE
          }
  )
  @JoinTable(
          name = "enrollment",
          joinColumns = @JoinColumn(
                  name = "student_id",
                  foreignKey = @ForeignKey(
                          name = "enrollment_student_id_fk"
                  )
          ),
          inverseJoinColumns = @JoinColumn(
                  name = "course_id",
                  foreignKey = @ForeignKey(
                          name = "enrollment_course_id_fk"
                  )
          )
  )
  private List<Course> courses = new ArrayList<>();

  public Student() {}

  public Student(String firstName, String lastName, String email, Integer age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.age = age;
  }

  public void addBook(Book book) {
    if (!books.contains(book)) {
      books.add(book);
      book.setStudent(this);
    }
  }

  public void removeBook(Book book) {
    if (books.contains(book)) {
      books.remove(book);
      book.setStudent(null);
    }
  }

  public void enrollToCourse(Course course) {
    if (!courses.contains(course)) {
      courses.add(course);
      course.getStudents().add(this);
    }
  }

  public void unEnrollToCourse(Course course) {
    if (courses.contains(course)) {
      courses.remove(course);
      course.getStudents().remove(null);
    }
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public StudentIdCard getStudentIdCard() {
    return studentIdCard;
  }

  public void setStudentIdCard(StudentIdCard studentIdCard) {
    this.studentIdCard = studentIdCard;
  }

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }

  public List<Course> getCourses() {
    return courses;
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }

  @Override
  public String toString() {
    return "Student{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", age=" + age +
            '}';
  }
}

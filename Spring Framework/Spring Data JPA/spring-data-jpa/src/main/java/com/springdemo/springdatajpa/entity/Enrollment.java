package com.springdemo.springdatajpa.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "Enrollment")
@Table(name = "enrollment")
public class Enrollment {

  @EmbeddedId
  private EnrollmentId id;

  @ManyToOne
  @MapsId("studentId")
  @JoinColumn(name = "student_id")
  private Student student;

  @ManyToOne
  @MapsId("courseId")
  @JoinColumn(name = "course_id")
  private Course course;

  @Column(
      name = "created_at",
      nullable = false,
      columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
  )
  private LocalDateTime createdAt;

  public Enrollment() {
  }

  public Enrollment(Student student, Course course) {
    this.student = student;
    this.course = course;
    createdAt = LocalDateTime.now();
  }

  public Enrollment(EnrollmentId id, Student student, Course course) {
    this.id = id;
    this.student = student;
    this.course = course;
    createdAt = LocalDateTime.now();
  }

  /* Getters & Setters */
  public EnrollmentId getId() {
    return id;
  }

  public void setId(EnrollmentId id) {
    this.id = id;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public String toString() {
    return "Enrollment{" +
        "id=" + id +
        ", student=" + student +
        ", course=" + course +
        ", createdAt=" + createdAt +
        '}';
  }
}

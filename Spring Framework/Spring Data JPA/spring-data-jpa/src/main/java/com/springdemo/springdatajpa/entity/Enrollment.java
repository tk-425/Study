package com.springdemo.springdatajpa.entity;

import jakarta.persistence.*;

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

  public Enrollment() {}

  public Enrollment(Student student, Course course) {
    this.student = student;
    this.course = course;
  }

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

  @Override
  public String toString() {
    return "Enrollment{" +
            "id=" + id +
            ", student=" + student +
            ", course=" + course +
            '}';
  }
}

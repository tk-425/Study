package com.springdemo.springdatajpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

@Embeddable
public class EnrollmentId implements Serializable {

  @Column(name = "student_id")
  private Long studentId;

  @Column(name = "course_id")
  private Long courseId;

  public EnrollmentId() {};

  public EnrollmentId(Long studentId, Long courseId) {
    this.studentId = studentId;
    this.courseId = courseId;
  }

  public Long getStudentId() {
    return studentId;
  }

  public void setStudentId(Long studentId) {
    this.studentId = studentId;
  }

  public Long getCourseId() {
    return courseId;
  }

  public void setCourseId(Long courseId) {
    this.courseId = courseId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    EnrollmentId that = (EnrollmentId) o;

    return new EqualsBuilder().append(studentId, that.studentId).append(courseId, that.courseId).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37).append(studentId).append(courseId).toHashCode();
  }

  @Override
  public String toString() {
    return "EnrollmentId{" +
            "studentId=" + studentId +
            ", courseId=" + courseId +
            '}';
  }
}

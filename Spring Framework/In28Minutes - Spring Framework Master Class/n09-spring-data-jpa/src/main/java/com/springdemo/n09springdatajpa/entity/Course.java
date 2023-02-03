package com.springdemo.n09springdatajpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Course {

  @Id
  @SequenceGenerator(
          name = "course_sequence",
          sequenceName = "course_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "course_sequence"
  )
  private Long courseId;

  private String title;
  private Integer credit;

  @OneToOne(
          mappedBy = "course"
  )
  private CourseMaterial courseMaterial;

  @ManyToOne(
          cascade = CascadeType.ALL
  )
  @JoinColumn(
          name = "teacher_id",
          referencedColumnName = "teacherId"
  )
  private Teacher teacher;

  @ManyToMany(
          cascade = CascadeType.ALL
  )
  @JoinTable(
          name = "student_course_map",
          joinColumns = @JoinColumn(
                  name = "course_id",
                  referencedColumnName = "courseId"
          ),
          inverseJoinColumns = @JoinColumn(
                  name = "student_id",
                  referencedColumnName = "studentId"
          )
  )
  private List<Student> students;

  public void addStudents(Student student) {
    if (students == null) {
      students = new ArrayList<>();
    } else {
      students.add(student);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Course course = (Course) o;

    if (!Objects.equals(courseId, course.courseId)) return false;
    if (!Objects.equals(title, course.title)) return false;
    if (!Objects.equals(credit, course.credit)) return false;
    return Objects.equals(courseMaterial, course.courseMaterial);
  }

  @Override
  public int hashCode() {
    int result = courseId != null ? courseId.hashCode() : 0;
    result = 31 * result + (title != null ? title.hashCode() : 0);
    result = 31 * result + (credit != null ? credit.hashCode() : 0);
    result = 31 * result + (courseMaterial != null ? courseMaterial.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Course{" +
            "courseId=" + courseId +
            ", title='" + title + '\'' +
            ", credit=" + credit +
            ", courseMaterial=" + courseMaterial +
            '}';
  }
}

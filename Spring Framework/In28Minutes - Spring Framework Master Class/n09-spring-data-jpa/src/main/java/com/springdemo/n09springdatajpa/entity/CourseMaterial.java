package com.springdemo.n09springdatajpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CourseMaterial {

  @Id
  @SequenceGenerator(
          name = "course_material_sequence",
          sequenceName = "course_material_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "course_material_sequence"
  )
  private Long courseMaterialId;

  private String url;

  @OneToOne(
          cascade = CascadeType.ALL,
          fetch = FetchType.LAZY,
          optional = false
  )
  @JoinColumn(
          name = "course_id",
          referencedColumnName = "courseId"
  )
  private Course course;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    CourseMaterial that = (CourseMaterial) o;

    if (!Objects.equals(courseMaterialId, that.courseMaterialId))
      return false;
    if (!Objects.equals(url, that.url)) return false;
    return Objects.equals(course, that.course);
  }

  @Override
  public int hashCode() {
    int result = courseMaterialId != null ? courseMaterialId.hashCode() : 0;
    result = 31 * result + (url != null ? url.hashCode() : 0);
    result = 31 * result + (course != null ? course.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "CourseMaterial{" +
            "courseMaterialId=" + courseMaterialId +
            ", url='" + url + '\'' +
            '}';
  }
}

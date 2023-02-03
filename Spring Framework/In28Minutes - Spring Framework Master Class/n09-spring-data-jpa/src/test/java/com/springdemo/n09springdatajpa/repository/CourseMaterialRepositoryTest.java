package com.springdemo.n09springdatajpa.repository;

import com.springdemo.n09springdatajpa.entity.Course;
import com.springdemo.n09springdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {

  @Autowired
  private CourseMaterialRepository courseMaterialRepository;

  @Test
  public void saveCourseMaterial() {
    CourseMaterial courseMaterial =
            CourseMaterial.builder()
                    .url("www.spring.com")
                    .course(getCourses().get(0))
                    .build();


    courseMaterialRepository.save(courseMaterial);

    courseMaterial =
            CourseMaterial.builder()
                    .url("www.java.com")
                    .course(getCourses().get(1))
                    .build();


    courseMaterialRepository.save(courseMaterial);

    courseMaterial =
            CourseMaterial.builder()
                    .url("www.hibernate.com")
                    .course(getCourses().get(2))
                    .build();


    courseMaterialRepository.save(courseMaterial);
  }

  @Test
  public void printAllCourseMaterials() {
    List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();

    System.out.println("\nlist =");
    printCourseMaterials(courseMaterials);
    System.out.println();
  }


  /* ---- Helper Methods ---- */
  private void printCourseMaterials(List<CourseMaterial> courseMaterials) {
    for (CourseMaterial material : courseMaterials) {
      System.out.println(material);
    }
  }

  private List<Course> getCourses() {
    Course spring = Course.builder()
            .title("Spring")
            .credit(4)
            .build();

    Course java = Course.builder()
            .title("Java")
            .credit(3)
            .build();

    Course hibernate = Course.builder()
            .title("Hibernate")
            .credit(2)
            .build();

    return List.of(spring, java, hibernate);
  }
}
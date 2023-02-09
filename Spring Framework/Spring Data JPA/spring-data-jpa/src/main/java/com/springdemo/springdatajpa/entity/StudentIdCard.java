package com.springdemo.springdatajpa.entity;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "StudentIdCard")
@Table(
        name = "student_id_card",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "student_id_card_number_unique",
                        columnNames = "card_number"
                )
        }
)
public class StudentIdCard {

  @Id
  @SequenceGenerator(
          name = "student_id_card_sequence",
          sequenceName = "student_id_card_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = SEQUENCE,
          generator = "student_id_card_sequence"
  )
  @Column(
          name = "id",
          updatable = false
  )
  private Long id;

  @Column(
          name = "card_number",
          nullable = false,
          length = 15,
          columnDefinition = "TEXT"
  )
  private String cardNumber;

  @OneToOne(
          cascade = CascadeType.ALL,
          fetch = FetchType.EAGER
  )
  @JoinColumn(
          name = "student_id",
          referencedColumnName = "id",
          foreignKey = @ForeignKey(
                  name = "student_id_card_student_id_fk"
          )
  )
  private Student student;

  public StudentIdCard() {}

  public StudentIdCard(String cardNumber, Student student) {
    this.cardNumber = cardNumber;
    this.student = student;
  }

  @Override
  public String toString() {
    return "StudentIdCard{" +
            "id=" + id +
            ", cardNumber='" + cardNumber + '\'' +
            ", student=" + student +
            '}';
  }
}

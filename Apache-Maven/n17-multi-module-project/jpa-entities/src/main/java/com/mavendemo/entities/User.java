package com.mavendemo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Data, AllArgs, NoArgs, Builder from Lombok,
// Entity & Id from Hibernate
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {

  @Id
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
}

package com.springdemo.example.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "TEAM")
public class Team {

  @Id
  @SequenceGenerator(
          name = "team_sequence",
          sequenceName = "team_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = SEQUENCE,
          generator = "team_sequence"
  )
  @Column(name = "TEAM_ID")
  private Long id;

  private String name;

  @OneToMany(mappedBy = "team")
  private List<Member> members = new ArrayList<>();

//  @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
//  private List<Member> members = new ArrayList<>();


  /* --- Getters & Setters --- */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Member> getMembers() {
    return members;
  }

  public void setMembers(List<Member> members) {
    this.members = members;
  }

  /* ---- toString() --- */
  @Override
  public String toString() {
    return "Team{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
  }
}

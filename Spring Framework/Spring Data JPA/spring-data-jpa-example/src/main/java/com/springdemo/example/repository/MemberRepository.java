package com.springdemo.example.repository;

import com.springdemo.example.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
  @Query("SELECT m FROM Member  m JOIN FETCH m.team WHERE m.team.name = :name")
  List<Member> findByTeamName(@Param("name") String name);
}

package com.springdemo.n08database.jdbc;

import com.springdemo.n08database.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonJdbcDAO {

  // database connection
  JdbcTemplate jdbcTemplate;

  private final String FIND_ALL = "select * from person";
  private final String FIND_BY_ID = "select * from person where id=?";
  private final String FIND_BY_NAME = "select * from person where name=?";
  private final String FIND_BY_LOCATION = "select * from person where location=?";
  private final String DELETE_BY_ID = "delete from person where id=?";
  private final String INSERT = "insert into person (id, name, location, birth_date) values (?,  ?, ?, ?)";
  private final String UPDATE = "update person set name=?, location=?, birth_date = ? where id=?";



  @Autowired
  public PersonJdbcDAO(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  // select * from person
  public List<Person> findAll() {
    return jdbcTemplate.query(FIND_ALL,
            new BeanPropertyRowMapper<>(Person.class));
  }

  public Person findById(int id) {
    return jdbcTemplate.queryForObject(FIND_BY_ID,
            new BeanPropertyRowMapper<>(Person.class), id);
  }

  public List<Person> findByName(String name) {
    return jdbcTemplate.query(FIND_BY_NAME,
            new BeanPropertyRowMapper<>(Person.class), name);
  }

  public List<Person> findByLocation(String location) {
    return jdbcTemplate.query(FIND_BY_LOCATION,
            new BeanPropertyRowMapper<>(Person.class), location);
  }

  public int deleteById(int id) {
    return jdbcTemplate.update(DELETE_BY_ID, id);
  }

  public int insert(Person person) {
    return jdbcTemplate.update(INSERT, person.getId(), person.getName(), person.getLocation(), person.getBirthDate());
  }

  public int update(Person person) {
    return jdbcTemplate.update(UPDATE, person.getName(), person.getLocation(), person.getBirthDate(), person.getId());
  }
}

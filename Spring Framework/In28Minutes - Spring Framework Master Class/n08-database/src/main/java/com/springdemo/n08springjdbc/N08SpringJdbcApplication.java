package com.springdemo.n08springjdbc;

import com.springdemo.n08springjdbc.entity.Person;
import com.springdemo.n08springjdbc.jdbc.PersonJdbcDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class N08SpringJdbcApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private final PersonJdbcDAO personJdbcDAO;

	@Autowired
	public N08SpringJdbcApplication(PersonJdbcDAO personJdbcDAO) {
		this.personJdbcDAO = personJdbcDAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(N08SpringJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// fire query
		logger.info("All Users -> {}", personJdbcDAO.findAll());
		logger.info("User ID 1004 -> {}", personJdbcDAO.findById(1004));
		logger.info("User Name James -> {}", personJdbcDAO.findByName("James"));
		logger.info("User Location -> {}", personJdbcDAO.findByLocation("MA"));
		logger.info("Delete User 1006");
		logger.info("Number of Row Deleted -> {}", personJdbcDAO.deleteById(1006));
		logger.info("All Users -> {}", personJdbcDAO.findAll());
		logger.info("Insert New User -> {}",
						personJdbcDAO.insert(new Person(1010, "Jake", "MD", convertStringToDate("1982-05-05"))));
		logger.info("Insert New User -> {}",
						personJdbcDAO.insert(new Person(1011, "Kris", "WA", convertStringToDate("1988-09-23"))));
		logger.info("All Users -> {}", personJdbcDAO.findAll());
		logger.info("Update ID 1011's Information -> {}",
						personJdbcDAO.update(new Person(1011, "Joy", "WA", convertStringToDate("1999-09-09"))));
		logger.info("All Users using PersonRowMapper -> {}", personJdbcDAO.findAllPersonRowMapper());
	}

	private Date convertStringToDate(String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		long epoch = format.parse(date).getTime();
		return new Date(epoch);
	}
}

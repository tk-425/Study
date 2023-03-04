package com.springdemo.example;

import com.github.javafaker.Faker;
import com.springdemo.example.entity.Locker;
import com.springdemo.example.entity.Member;
import com.springdemo.example.entity.Product;
import com.springdemo.example.entity.Team;
import com.springdemo.example.repository.MemberRepository;
import com.springdemo.example.repository.ProductRepository;
import com.springdemo.example.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import util.Printer;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class SpringDataJpaExampleApplicationTests {

  @Autowired
  MemberRepository memberRepository;

  @Autowired
  TeamRepository teamRepository;

  @Autowired
  private ProductRepository productRepository;

  private final Faker faker = new Faker();
  private final Printer<Member> memberPrinter = new Printer<>();
  private final Printer<Product> productPrinter = new Printer<>();


  @Test
  void entityTest() {
    Member member1 = new Member();
    member1.setUserName(faker.name().firstName());
    member1.setAge(faker.number().numberBetween(18, 49));

    Member member2 = new Member();
    member2.setUserName(faker.name().firstName());
    member2.setAge(faker.number().numberBetween(18, 49));

    // save
    memberRepository.saveAll(List.of(member1, member2));

    // change age
    System.out.println("\n*** Change Member 1's Age to 35 *** \n");
    member1.setAge(35);
    memberRepository.save(member1);

    // find
    Optional<Member> foundMember = memberRepository.findById(1L);
    foundMember.ifPresent(m -> {
      System.out.println("\n*** Member Found ***");
      System.out.println("Member with ID 1:\n\tName: " + m.getUserName() + "\n\tAge: " + m.getAge() + "\n");
    });

    // get all data
    List<Member> memberList = memberRepository.findAll();
    memberPrinter.printList(memberList);
  }

  @Test
  void manyToOneTest() {
    Team team1 = new Team();
    team1.setName("TEAM #" + faker.number().numberBetween(1, 10));

    Team team2 = new Team();
    team2.setName("TEAM #" + faker.number().numberBetween(1, 10));

    // save teams
    teamRepository.saveAll(List.of(team1, team2));

    Member member1 = new Member();
    member1.setUserName(faker.name().firstName());
    member1.setAge(faker.number().numberBetween(18, 49));
    // assign team
    member1.setTeam(team1);

    Member member2 = new Member();
    member2.setUserName(faker.name().firstName());
    member2.setAge(faker.number().numberBetween(18, 49));
    // assign team
    member2.setTeam(team1);

    Member member3 = new Member();
    member3.setUserName(faker.name().firstName());
    member3.setAge(faker.number().numberBetween(18, 49));
    // assign team
    member3.setTeam(team2);

    // save all members
    memberRepository.saveAll(List.of(member1, member2, member3));

    // display the team name for member id 3
    Optional<Member> id3Member = memberRepository.findById(3L);
    id3Member.ifPresent(m -> {
      System.out.println("Member ID 3's Team: " + m.getTeam());
    });
  }

  @Test
  void oneToManyFetchTest() {
    // fetch type = eager
//    Optional<Team> team3 = teamRepository.findById(1L);
//    team3.ifPresent(team -> {
//      printList(team.getMembers());
//    });

    // fetch type = lazy
    List<Member> memberList = memberRepository.findByTeamName("TEAM #3");
    memberList.forEach(member -> {
      System.out.println("\nName: " + member.getUserName() + " - " + member.getTeam().getName());
      member.setAge(99);
      System.out.println(member.getAge());
      memberRepository.save(member);
    });
  }

  @Test
  void manToOneBiDirectionalTest() {
    // save team
    Team team1 = new Team();
    team1.setName("TEAM #1");
    teamRepository.save(team1);

    // member 1 save
    Member member1 = new Member();
    member1.setUserName(faker.name().firstName());
    member1.setTeam(team1);
    memberRepository.save(member1);

    // member 2 save
    Member member2 = new Member();
    member2.setUserName(faker.name().firstName());
    member2.setTeam(team1);
    memberRepository.save(member2);

    // will be ignored
    team1.getMembers().add(member1);
    team1.getMembers().add(member2);

    System.out.println("Member1 : " + member1.toString());
    System.out.println("\tTeam: " + member1.getTeam().toString());
    System.out.println("Member2 : " + member2.toString());
    System.out.println("\tTeam: " + member2.getTeam().toString());

  }

  @Test
  void manyToManyTest() {
    Member member1 = new Member();
    member1.setUserName(faker.name().firstName());

    Product product1 = new Product();
    product1.setName("Product #1");

    // product to member
    member1.getProducts().add(product1);

    // save product and member to the database
    productRepository.save(product1);
    memberRepository.save(member1);

    System.out.println("\nName: " + member1.getUserName());
    productPrinter.printList(member1.getProducts());
  }

  @Test
  void manyToManyBiDirectionalTest() {
    Member member1 = new Member();
    member1.setUserName(faker.name().firstName());

    Member member2 = new Member();
    member2.setUserName(faker.name().firstName());

    Product product = new Product();
    product.setName("Product #3");

    member1.addProduct(product);
    member2.addProduct(product);

    productRepository.save(product);
    memberRepository.saveAll(List.of(member1, member2));

    memberPrinter.printList(product.getMembers());

    Optional<Member> memberId40 = memberRepository.findById(43L);
    memberId40.ifPresent(member -> {
      System.out.println("Member ID 43's Products:");
      productPrinter.printList(member.getProducts());
    });

  }
}

package com.lankydan;

import com.lankydan.cassandra.Person;
import com.lankydan.cassandra.PersonKey;
import com.lankydan.cassandra.keyspace.a.KeyspaceAPersonRepository;
import com.lankydan.cassandra.keyspace.b.KeyspaceBPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
public class Application implements CommandLineRunner {

//  @Autowired private PersonRepository personRepository;

  @Autowired
  private KeyspaceAPersonRepository keyspaceAPersonRepository;

  @Autowired
  private KeyspaceBPersonRepository keyspaceBPersonRepository;

  public static void main(final String args[]) {
    SpringApplication.run(Application.class);
  }

  @Override
  public void run(String... args) throws Exception {
    final PersonKey key = new PersonKey("John", LocalDateTime.now(), UUID.randomUUID());
    final Person p = new Person(key, "Doe", 1000);
    keyspaceAPersonRepository.insert(p);
    System.out.println("find by first name");
    keyspaceAPersonRepository.findByKeyFirstName("John").forEach(System.out::println);

    final PersonKey key1 = new PersonKey("Bob", LocalDateTime.now(), UUID.randomUUID());
    final Person p1 = new Person(key1, "Bob", 1000);
    keyspaceBPersonRepository.insert(p1);
    System.out.println("find by first name");
    keyspaceBPersonRepository.findByKeyFirstName("Bob").forEach(System.out::println);
  }
}

package com.lankydan.cassandra.keyspace.a;

import com.lankydan.cassandra.AbstractKeyspaceCassandraRepository;
import com.lankydan.cassandra.Person;
import com.lankydan.cassandra.PersonKey;
import org.springframework.data.cassandra.core.CassandraAdminOperations;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.repository.query.CassandraEntityInformation;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

//@Repository
public class KeyspaceAPersonRepositoryImpl
    extends AbstractKeyspaceCassandraRepository<Person, PersonKey>
    implements KeyspaceAPersonRepository {

  public KeyspaceAPersonRepositoryImpl(
      final CassandraOperations cassandraTemplate,
      final CassandraEntityInformation entityInformation,
      final String keyspace) {
    super(cassandraTemplate, entityInformation, keyspace);
  }

  @Override
  public List<Person> findByKeyFirstName(String firstName) {
    return null;
  }

  @Override
  public List<Person> findByKeyFirstNameAndKeyDateOfBirthGreaterThan(
      String firstName, LocalDateTime dateOfBirth) {
    return null;
  }

  @Override
  public List<Person> findByLastName(String lastName) {
    return null;
  }
}

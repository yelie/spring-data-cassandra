package com.lankydan.cassandra.keyspace.a;

import com.lankydan.cassandra.PersonRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
public interface KeyspaceAPersonRepository extends PersonRepository {}

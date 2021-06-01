package com.example.pgpointjpademo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TestObjectRepository extends JpaRepository<TestObject, UUID> {

}

package com.anthony4834.driverslicense.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anthony4834.driverslicense.models.Person;

@Repository
public interface PersonRepo extends CrudRepository<Person, Long> {
	List<Person> findAll();
}

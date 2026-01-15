package com.wykmmam.rest_spring_java.services;

import com.wykmmam.rest_spring_java.exception.ResourceNotFoundException;
import com.wykmmam.rest_spring_java.model.Person;
import com.wykmmam.rest_spring_java.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final Logger logger =
            Logger.getLogger(PersonService.class.getName());

    final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person findById(Long id) {
        logger.info("Finding one person");
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "No records found for this id"));
    }

    public List<Person> findAll() {
        logger.info("Finding all people");
        return repository.findAll();
    }

    public Person create(Person person) {
        logger.info("Creating one person!");
        return repository.save(person);
    }


    public Person update(Person person) {
        logger.info("Updating one person!");
        Person entity = findById(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        return repository.save(entity);
    }


    public void delete(Long id) {
        logger.info("Deleting one person!");
        Person entity = findById(id);
        repository.delete(entity);
    }

}

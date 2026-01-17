package com.wykmmam.rest_spring_java.services;

import com.wykmmam.rest_spring_java.data.dto.PersonDTO;
import com.wykmmam.rest_spring_java.exception.ResourceNotFoundException;
import com.wykmmam.rest_spring_java.model.Person;
import com.wykmmam.rest_spring_java.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.wykmmam.rest_spring_java.mapper.ObjectMapper.parseListObjects;
import static com.wykmmam.rest_spring_java.mapper.ObjectMapper.parseObject;


@Service
public class PersonService {
    private final Logger logger =
            LoggerFactory.getLogger(PersonService.class.getName());

    final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public PersonDTO findById(Long id) {
        logger.info("Finding one person");
        Person entity =
                repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                        "No records found for this id"));

        return parseObject(entity, PersonDTO.class);
    }

    public List<PersonDTO> findAll() {
        logger.info("Finding all people");
        return parseListObjects(repository.findAll(), PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person) {
        logger.info("Creating one person!");
        Person entity = parseObject(person, Person.class);
        return parseObject(repository.save(entity), PersonDTO.class);
    }


    public PersonDTO update(PersonDTO person) {
        logger.info("Updating one PersonDTO!");
        Person entity = parseObject(findById(person.getId()), Person.class);
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        return parseObject(repository.save(entity), PersonDTO.class);
    }


    public void delete(Long id) {
        logger.info("Deleting one person!");
        Person entity = parseObject(findById(id), Person.class);
        repository.delete(entity);
    }

}

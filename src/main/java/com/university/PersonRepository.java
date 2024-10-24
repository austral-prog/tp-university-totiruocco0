package com.university;

import java.util.HashMap;
import java.util.Map;

public class PersonRepository implements CRUDRepository<Person> {
    private Map<Integer, Person> personMap = new HashMap<>();
    private int currentId = 1; // Auto-increment ID for each new person

    @Override
    public void create(Person person) {
        person.setId(currentId++);
        personMap.put(person.getId(), person);
        System.out.println("Created: " + person);
    }

    @Override
    public Person read(int id) {
        Person person = personMap.get(id);
        if (person != null) {
            System.out.println("Read: " + person);
        } else {
            System.out.println("Person with ID " + id + " not found.");
        }
        return person;
    }

    @Override
    public void update(int id, Person updatedPerson) {
        Person person = personMap.get(id);
        if (person != null) {
            updatedPerson.setId(id); // Ensure the ID remains the same
            personMap.put(id, updatedPerson);
            System.out.println("Updated: " + updatedPerson);
        } else {
            System.out.println("Person with ID " + id + " not found.");
        }
    }

    @Override
    public void delete(int id) {
        if (personMap.remove(id) != null) {
            System.out.println("Deleted person with ID: " + id);
        } else {
            System.out.println("Person with ID " + id + " not found.");
        }
    }

    @Override
    public String getIdentifier() {
        return "Person";
    }

    @Override
    public Class<Person> getEntityClass() {
        return Person.class;
    }
}
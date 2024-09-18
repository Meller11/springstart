package kea.springstart.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Model {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int id;
    String name;
    int age;
}

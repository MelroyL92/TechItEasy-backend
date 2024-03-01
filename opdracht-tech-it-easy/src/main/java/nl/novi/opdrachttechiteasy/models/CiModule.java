package nl.novi.opdrachttechiteasy.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CiModule {

    @GeneratedValue
    @Id
    private Long id;
    private String type;
    private String name;
    private Double price;

}

package nl.novi.opdrachttechiteasy.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class WallBracket {

    @GeneratedValue
    @Id
    private Long id;
    private String name;
    private Boolean adjustable;
    private Double price;
}

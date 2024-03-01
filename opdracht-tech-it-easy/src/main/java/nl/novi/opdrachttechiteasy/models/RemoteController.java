package nl.novi.opdrachttechiteasy.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class RemoteController {

    @GeneratedValue
    @Id
    private Long id;
    private String compatibleWith;
    private String batteryType;
    private String name;
    private Double price;
    private Integer originalStock;

}

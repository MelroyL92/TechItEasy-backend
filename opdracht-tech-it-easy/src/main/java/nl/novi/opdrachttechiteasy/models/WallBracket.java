package nl.novi.opdrachttechiteasy.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class WallBracket {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private Boolean adjustable;
    private Double price;

    public Long getId() {
        return id;
    }

    @ManyToMany
    @JoinTable(
            name = "wall_bracket_television",
            joinColumns = @JoinColumn(name = "wall_bracket_id"),
            inverseJoinColumns = @JoinColumn(name = "television_id")
    )
    private Set<Television> television = new HashSet<>();

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAdjustable() {
        return adjustable;
    }

    public void setAdjustable(Boolean adjustable) {
        this.adjustable = adjustable;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

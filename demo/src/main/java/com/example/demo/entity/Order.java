package com.example.demo.entity;

//import javax.validation.constraints.Digits;
//import javax.validation.constraints.Pattern;
//import org.hibernate.validator.constraints.CreditCardNumber;
//import org.hibernate.validator.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name="Taco_Order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Date placedAt;
...
    @ManyToMany(targetEntity=Taco.class)
    private List<Taco> tacos = new ArrayList<>();
    public void addDesign(Taco design){this.tacos.add(design);}
    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }
}
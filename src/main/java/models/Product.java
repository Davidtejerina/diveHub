package models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class Product {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id2;
    private String name;
    private String description;
    private Double startingPrice;
    private Double finalPrice;
    private String image;
}

package models;


import jakarta.persistence.*;
import
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Activity extends Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double starting_price;
    private Double final_price;
    private String image;
    private Category category;
}

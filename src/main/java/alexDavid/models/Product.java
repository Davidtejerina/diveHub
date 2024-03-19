package alexDavid.models;


import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Product {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double starting_price;
    private Double final_price;
    private String image;
    private Category category;
    private String tag;
}

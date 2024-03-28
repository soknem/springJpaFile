package app.springJPA.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="product-tbl")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private float price;

}

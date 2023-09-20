package com.sberbank.models;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author Anna Ermachenkova
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "product", schema = "public")
public class Product {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String weight;
    @Column
    private String description;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "list_of_product_id")
    private ListOfProducts listOfProducts;
}

package com.stamacake.spring.boot.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name= "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private Integer price;

}

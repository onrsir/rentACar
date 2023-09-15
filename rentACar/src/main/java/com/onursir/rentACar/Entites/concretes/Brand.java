package com.onursir.rentACar.Entites.concretes;

import jakarta.persistence.*;
import lombok.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "brands")
@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name ="name")
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Model> models;

}

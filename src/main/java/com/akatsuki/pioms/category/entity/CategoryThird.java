package com.akatsuki.pioms.category.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="category_third")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CategoryThird {

    @Id
    @Column(name = "category_third_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_third_code;

    @Column(name = "category_third_name")
    private String category_third_name;

    @ManyToOne
    @JoinColumn(name="category_second_code")
    private CategorySecond category_second_code;
}

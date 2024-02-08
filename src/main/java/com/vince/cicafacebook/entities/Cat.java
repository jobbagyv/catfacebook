package com.vince.cicafacebook.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String imageUrl = "no-image.png";
    private String name = "No name given";
    private String description = "No description given";
    private Integer age = -1;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "cat"
    )
    @ToString.Exclude
    @Builder.Default
    private List<Rating> ratings = new ArrayList<>();
}

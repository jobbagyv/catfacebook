package com.vince.cicafacebook.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cat_rating")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    protected User user;
    @ManyToOne
    @JoinColumn(name = "cat_id")
    protected Cat cat;
    protected int value;
    protected String comment;
}

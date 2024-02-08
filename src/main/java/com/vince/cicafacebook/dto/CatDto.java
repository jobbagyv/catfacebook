package com.vince.cicafacebook.dto;

import com.vince.cicafacebook.entities.Rating;
import com.vince.cicafacebook.entities.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CatDto {
    private Long id;
    private String imageUrl;
    private String name;
    private String description;
    private Integer age = -1;
    private Long userId;
    private Double averageRating;
    @Builder.Default
    private List<RatingDto> ratings = new ArrayList<>();
}

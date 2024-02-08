package com.vince.cicafacebook.dto;

import com.vince.cicafacebook.entities.Cat;
import com.vince.cicafacebook.entities.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RatingDto {
    protected Long userId;
    protected Long catId;
    protected int value;
    protected String comment;
}

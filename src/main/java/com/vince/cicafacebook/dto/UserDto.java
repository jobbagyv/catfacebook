package com.vince.cicafacebook.dto;

import com.vince.cicafacebook.entities.Cat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class UserDto {
    private Long id;
    private String userName;
    @Builder.Default
    private List<CatDto> cats = new ArrayList<>();
}

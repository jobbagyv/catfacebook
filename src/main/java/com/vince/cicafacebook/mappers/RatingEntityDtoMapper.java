package com.vince.cicafacebook.mappers;

import com.vince.cicafacebook.dto.CatDto;
import com.vince.cicafacebook.dto.RatingDto;
import com.vince.cicafacebook.entities.Cat;
import com.vince.cicafacebook.entities.Rating;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RatingEntityDtoMapper {
    public Rating dtoToEntity(RatingDto dto);
    @Mapping(target = "userId", source="entity.user.id")
    @Mapping(target = "catId", source="entity.cat.id")
    public RatingDto entityToDto(Rating entity);
}

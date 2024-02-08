package com.vince.cicafacebook.mappers;

import com.vince.cicafacebook.dto.CatDto;
import com.vince.cicafacebook.dto.UserDto;
import com.vince.cicafacebook.entities.Cat;
import com.vince.cicafacebook.entities.Rating;
import com.vince.cicafacebook.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {HibernateCollectionUtils.class, RatingEntityDtoMapper.class})
public interface CatEntityDtoMapper {
    public Cat dtoToEntity(CatDto dto);
    @Mapping(source="ratings", target = "averageRating", qualifiedByName = "averageRatings")
    @Mapping(target = "userId", source="entity.user.id")
    public CatDto entityToDto(Cat entity);

    @Named("averageRatings")
    public default Double averageRatings(List<Rating> toAverage){
        return toAverage.stream().map(r-> (double) r.getValue()).reduce((n, c)-> c+n).get()/toAverage.size();
    }
}

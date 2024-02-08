package com.vince.cicafacebook.mappers;

import com.vince.cicafacebook.dto.UserDto;
import com.vince.cicafacebook.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {HibernateCollectionUtils.class, CatEntityDtoMapper.class})
public interface UserEntityDtoMapper {
    @Mapping(target = "authUserName", ignore = true)
    public User dtoToEntity(UserDto dto);
    public UserDto entityToDto(User entity);
}

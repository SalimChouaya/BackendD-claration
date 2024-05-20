package com.PrixDeTransfert.Backend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;



import com.PrixDeTransfert.Backend.dto.SignUpDto;
import com.PrixDeTransfert.Backend.dto.UserDto;
import com.PrixDeTransfert.Backend.models.User;
 
@Mapper(componentModel = "spring")

public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);
}

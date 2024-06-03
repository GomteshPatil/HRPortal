package com.hrportal.mappers;
import org.mapstruct.Mapper;

import com.hrportal.dto.UserPojo;
import com.hrportal.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
	UserPojo toUserPojo(UserEntity entity);
}

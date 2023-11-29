package com.postgres2.demo.mapping;



import com.postgres2.demo.dto.DogDTO;
import com.postgres2.demo.entity.Dog;
import com.postgres2.demo.entity.User;
import com.postgres2.demo.repository.JpaRepositoryUser;
import com.postgres2.demo.server.UserService;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;

@Mapper(componentModel = "spring", uses = {UUID.class},
        injectionStrategy = CONSTRUCTOR, imports = {UserService.class,DogDTO.class})

public interface DogMapping {

    @Mapping(source = "userId", qualifiedByName = "getUserIdFromDog", target = "userId")
    DogDTO mapToDogDTO(Dog dog);

    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "dogName", target = "dogName")
//    @Mapping(expression = "java(UserService.getUserById(userId))", target = "userId")
//    @Mapping(source = "userId", qualifiedByName = "getUserIdFromDogDTO", target = "userId")
    @Mapping(source = "userId", target = "userId.userId")
//    @Mapping(expression = "java(UserService.getUserById(dogDTO.getUserId()))", target = "userId.userId")


    Dog mapToDog(DogDTO dogDTO);

    @Named("getUserIdFromDog")
    default UUID getUserIdFromDog(User user) {
        return user.getUserId();
    }





}

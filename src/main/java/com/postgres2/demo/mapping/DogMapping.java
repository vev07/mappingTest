package com.postgres2.demo.mapping;



import com.postgres2.demo.dto.DogDTO;
import com.postgres2.demo.entity.Dog;
import com.postgres2.demo.entity.User;
import com.postgres2.demo.repository.JpaRepositoryUser;
import com.postgres2.demo.server.UserService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;



@Mapper(componentModel = "spring", uses = {UUID.class}
//        ,
//        injectionStrategy = CONSTRUCTOR,
//        imports = {UserService.class,DogDTO.class}
)
public abstract class DogMapping {
    @Autowired
    protected UserService userService;


    @Mapping(source = "userId", qualifiedByName = "getUserIdFromDog", target = "userId")
    public abstract DogDTO mapToDogDTO(Dog dog);


    @Mapping(source = "dogName", target = "dogName")
    @Mapping(expression = "java(userService.getUserById(dogDTO.getUserId()).get())", target = "userId")
    public abstract Dog mapToDog(DogDTO dogDTO);

    @Named("getUserIdFromDog")
    public UUID getUserIdFromDog(User user) {
        return user.getUserId();
    }





}

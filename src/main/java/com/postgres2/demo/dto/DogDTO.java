package com.postgres2.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
public class DogDTO {
    String dogId;
    String dogName;
    String userId;
}

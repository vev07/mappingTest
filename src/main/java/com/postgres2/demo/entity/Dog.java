package com.postgres2.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "dogs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "dog_id")
    private UUID dogId;
    @Column(name = "dog_name")
    private String dogName;

    @ManyToOne(cascade = {MERGE, PERSIST, REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", referencedColumnName = "user_id")
    private User userId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(dogId, dog.dogId) && Objects.equals(dogName, dog.dogName) && Objects.equals(userId, dog.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dogId, dogName, userId);
    }

    @Override
    public String toString() {
        return "DogDTO{" +
                "dogId=" + dogId +
                ", dogName='" + dogName + '\'' +
                ", userId=" + userId +
                '}';
    }
}

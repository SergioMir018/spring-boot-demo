package com.example.demo.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Data
public class Person {
    private final UUID id;

    @NotBlank(message = "The name cannot be empty")
    private final String name;
}

package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class Person {
    private final UUID id;
    private final String name;
}

package com.example.demo.adoptions;

import org.springframework.modulith.events.Externalized;

@Externalized(target = "messageChannel")
public record DogAdoptionEvent(int dogId) {
}

package com.example.demo.vet;

import com.example.demo.adoptions.DogAdoptionEvent;
import com.example.demo.adoptions.Validation;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Service
class Dogtor {

    private final Validation validation;

    Dogtor(Validation validation) {
        this.validation = validation;
    }

    @ApplicationModuleListener
    void checkup(DogAdoptionEvent dogId) throws Exception {
        Thread.sleep(5_000);
        System.out.println("checking up on " + dogId);
    }
}

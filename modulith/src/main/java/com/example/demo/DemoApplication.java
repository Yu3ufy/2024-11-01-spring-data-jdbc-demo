package com.example.demo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.modulith.events.IncompleteEventPublications;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}




class ReplayMessagesListenerThing
        implements ApplicationRunner {
    
    private final IncompleteEventPublications publications;

    //1 Spring Tips: Distributed Job Scheduling with Jobrunr
    
    //2 
    //todo look for Spring Integration distributed locks
    // LockRegistry 
    // registry.executeLocked(lockName, Duration.ofMillis(timeoutInMilliseconds == -1 ? 1_000 : timeoutInMilliseconds), () -> {
    //            super.process();
    //            return null;
    //        });
    
    ReplayMessagesListenerThing(IncompleteEventPublications publications) {
        this.publications = publications;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.publications.resubmitIncompletePublications(eventPublication -> Math.random() < 0.5);
    }
}


// DATA ORIENTED PROGRAMMING
// - sealed types
// - pattern matching
// - smart switch
// - records
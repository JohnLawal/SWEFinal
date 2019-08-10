package com.jlawal.finalexam.mainpackage;

import com.jlawal.finalexam.mainpackage.model.Citizen;
import com.jlawal.finalexam.mainpackage.model.State;
import com.jlawal.finalexam.mainpackage.serviceimplementation.ConcreteCitizenService;
import com.jlawal.finalexam.mainpackage.serviceimplementation.ConcreteStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class FinalexamApplication implements CommandLineRunner {
    @Autowired
    ConcreteCitizenService concreteCitizenService;
    @Autowired
    ConcreteStateService concreteStateService;

    public static void main(String[] args) {
        SpringApplication.run(FinalexamApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Inserts the default records into the database if they dont exist

        if (!concreteCitizenService.hasDefaultRecords() || !concreteStateService.hasDefaultRecords()) {
            Citizen citizen1 = new Citizen("123-45-6789", "Anna", "H.", "Smith", LocalDate.of(1959, 5, 21), 155250.00);
            Citizen citizen2 = new Citizen("123-45-6780", "John", "Andrew", "Biggs", LocalDate.of(1949, 12, 3), 48900.95);
            Citizen citizen3 = new Citizen("123-45-6779", "Diego", "", "Ortiz", LocalDate.of(1971, 11, 27), 457879.23);

            //
            State state1 = new State("KAL", "Kalakuta");
            State state2 = new State("ANT", "Antananarivo");
            State state3 = new State("ALA", "Alabama");

            citizen1.setState(state1);
            citizen2.setState(state1);
            citizen3.setState(state2);

//
            state1.addCitizen(citizen1);
            state1.addCitizen(citizen2);
            state2.addCitizen(citizen3);

            concreteStateService.createState(state1);
            concreteStateService.createState(state2);
            concreteStateService.createState(state3);

        }
    }
}

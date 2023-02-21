package dev.manyroads.reactive.controller;

import dev.manyroads.reactive.model.EmpRecord;
import dev.manyroads.reactive.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class EmpController {

    @Autowired
    EmpRepository repo;

    @GetMapping("/all")
    public Flux<EmpRecord> getAll() {

        System.out.println("Route: getAll");

        return repo.findAll();
    }
}

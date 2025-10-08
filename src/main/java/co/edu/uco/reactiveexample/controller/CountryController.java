package co.edu.uco.reactiveexample.controller;

import co.edu.uco.reactiveexample.entity.CountryEntity;
import co.edu.uco.reactiveexample.service.CountryService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {

    private final CountryService service;

    public CountryController(final CountryService service) {
        this.service = service;
    }

    @PostMapping
    public Mono<CountryEntity> create(@RequestBody final CountryEntity country) {
        return service.create(country);
    }

    @GetMapping
    public Flux<CountryEntity> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<CountryEntity> findById(@PathVariable final int id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Mono<CountryEntity> update(@PathVariable final int id, @RequestBody final CountryEntity country) {
        return service.update(id, country);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable final int id) {
        return service.delete(id);
    }
}

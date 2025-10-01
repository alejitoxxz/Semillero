package co.edu.uco.reactiveexample.controller;

import co.edu.uco.reactiveexample.entity.CountryEntity;
import co.edu.uco.reactiveexample.repository.CountryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/countries")
public class PaisController {

    private final CountryRepository repository;

    // Constructor con inyección de dependencias
    public PaisController(final CountryRepository repository) {
        this.repository = repository;
    }

    // GET /api/v1/countries -> devuelve todos los países desde la BD
    @GetMapping
    public Flux<CountryEntity> getAllCountries() {
        return repository.findAll();
    }
}

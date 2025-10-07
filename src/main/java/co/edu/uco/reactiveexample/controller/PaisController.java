package co.edu.uco.reactiveexample.controller;

import co.edu.uco.reactiveexample.entity.CountryEntity;
import co.edu.uco.reactiveexample.repository.CountryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    @PostMapping
    public Mono<ResponseEntity<CountryEntity>> createCountry(@RequestBody final CountryEntity country) {
        country.setId(null);
        return repository.save(country)
                .map(savedCountry -> ResponseEntity.status(HttpStatus.CREATED).body(savedCountry));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<CountryEntity>> updateCountry(@PathVariable final Integer id,
                                                             @RequestBody final CountryEntity country) {
        return repository.findById(id)
                .flatMap(existingCountry -> {
                    existingCountry.setName(country.getName());
                    existingCountry.setDialingCountryCode(country.getDialingCountryCode());
                    existingCountry.setIsoCountryCode(country.getIsoCountryCode());
                    existingCountry.setEnabled(country.getEnabled());
                    return repository.save(existingCountry);
                })
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteCountry(@PathVariable final Integer id) {
        return repository.findById(id)
                .flatMap(existingCountry -> repository.delete(existingCountry)
                        .then(Mono.just(ResponseEntity.noContent().build())))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}

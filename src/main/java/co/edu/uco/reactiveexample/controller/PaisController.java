package co.edu.uco.reactiveexample.controller;

import co.edu.uco.reactiveexample.entity.CountryEntity;
import co.edu.uco.reactiveexample.service.CountryService;
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

    private final CountryService countryService;

    public PaisController(final CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public Flux<CountryEntity> getAllCountries() {
        return countryService.getAllCountries();
    }

    @PostMapping
    public Mono<ResponseEntity<CountryEntity>> createCountry(@RequestBody final CountryEntity country) {
        return countryService.createCountry(country)
                .map(savedCountry -> ResponseEntity.status(HttpStatus.CREATED).body(savedCountry));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<CountryEntity>> updateCountry(@PathVariable final Integer id,
                                                             @RequestBody final CountryEntity country) {
        return countryService.updateCountry(id, country)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Object>> deleteCountry(@PathVariable final Integer id) {
        return countryService.deleteCountry(id)
                .map(deleted -> deleted
                        ? ResponseEntity.noContent().build()
                        : ResponseEntity.notFound().build());
    }
}

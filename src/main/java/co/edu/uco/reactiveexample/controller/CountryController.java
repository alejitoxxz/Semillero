package co.edu.uco.reactiveexample.controller;

import co.edu.uco.reactiveexample.entity.CountryEntity;
import co.edu.uco.reactiveexample.publisher.CountryPublisher;
import co.edu.uco.reactiveexample.publisher.event.CountryEvent;
import co.edu.uco.reactiveexample.service.CountryService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {

    private final CountryService service;
    private CountryPublisher publisher;

    public CountryController(final CountryService service, final CountryPublisher publisher) {
        this.service = service;
        this.publisher = publisher;
    }
    
    @GetMapping(path = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<CountryEvent> publishEvents() {
		return publisher.getStream();
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
    public Mono<CountryEntity> delete(@PathVariable final int id) {
        return service.delete(id);
    }
}

package co.edu.uco.reactiveexample.service;

import co.edu.uco.reactiveexample.entity.CountryEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CountryService {

    Flux<CountryEntity> findAll();

    Mono<CountryEntity> findById(Integer id);

    Mono<CountryEntity> create(CountryEntity country);

    Mono<CountryEntity> update(Integer id, CountryEntity country);

    Mono<Void> delete(Integer id);

    Mono<CountryEntity> findByName(String name);
}

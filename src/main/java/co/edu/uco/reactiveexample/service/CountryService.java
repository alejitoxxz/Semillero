package co.edu.uco.reactiveexample.service;

import co.edu.uco.reactiveexample.entity.CountryEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CountryService {

    Flux<CountryEntity> getAllCountries();

    Mono<CountryEntity> createCountry(CountryEntity country);

    Mono<CountryEntity> updateCountry(Integer id, CountryEntity country);

    Mono<Boolean> deleteCountry(Integer id);
    
    Mono<CountryEntity> findByName(String name);
    
    Mono<CountryEntity> findAll();
}

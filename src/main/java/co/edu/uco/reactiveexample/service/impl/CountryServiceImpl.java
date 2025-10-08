package co.edu.uco.reactiveexample.service.impl;

import co.edu.uco.reactiveexample.entity.CountryEntity;
import co.edu.uco.reactiveexample.repository.CountryRepository;
import co.edu.uco.reactiveexample.service.CountryService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository repository;

    public CountryServiceImpl(final CountryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<CountryEntity> getAllCountries() {
        return repository.findAll();
    }

    @Override
    public Mono<CountryEntity> createCountry(final CountryEntity country) {
        country.setId(null); // asegurar insert
        return repository.save(country);
    }

    @Override
    public Mono<CountryEntity> updateCountry(final Integer id, final CountryEntity country) {
        return repository.findById(id)
                .flatMap(existingCountry -> {
                    existingCountry.setName(country.getName());
                    existingCountry.setDialingCountryCode(country.getDialingCountryCode());
                    existingCountry.setIsoCountryCode(country.getIsoCountryCode());
                    existingCountry.setEnabled(country.getEnabled());
                    return repository.save(existingCountry);
                });
    }

    @Override
    public Mono<Boolean> deleteCountry(final Integer id) {
        return repository.findById(id)
                .flatMap(existingCountry ->
                        repository.delete(existingCountry).then(Mono.just(true)))
                .defaultIfEmpty(false);
    }

    @Override
    public Mono<CountryEntity> findByName(final String name) {
        // Opción A (si existe en tu repositorio): Mono<CountryEntity> findByName(String name);
        return repository.findByName(name);

        // Opción B (si NO tienes el método anterior en el repo):
        // return repository.findAll()
        //         .filter(c -> c.getName() != null && c.getName().equalsIgnoreCase(name))
        //         .next();
    }

    @Override
    public Flux<CountryEntity> findAll() {
        return repository.findAll();
    }
}

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
        country.setId(null);
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
                .flatMap(existingCountry -> repository.delete(existingCountry).thenReturn(true))
                .defaultIfEmpty(false);
    }
}

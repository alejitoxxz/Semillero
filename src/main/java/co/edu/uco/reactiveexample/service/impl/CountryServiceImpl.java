package co.edu.uco.reactiveexample.service.impl;

import co.edu.uco.reactiveexample.entity.CountryEntity;
import co.edu.uco.reactiveexample.publisher.CountryPublisher;
import co.edu.uco.reactiveexample.repository.CountryRepository;
import co.edu.uco.reactiveexample.service.CountryService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository repository;
    private final CountryPublisher publisher;

    public CountryServiceImpl(final CountryRepository repository, final CountryPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    @Override
    public Flux<CountryEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<CountryEntity> findById(final Integer id) {
        return repository.findById(id);
    }

    @Override
    public Mono<CountryEntity> create(final CountryEntity country) {
        return repository.save(country)
                .doOnSuccess(publisher::sendCreateEvent);
    }

    @Override
    public Mono<CountryEntity> update(final Integer id, final CountryEntity country) {
        return repository.findById(id)
                .flatMap(existingCountry -> {
                    existingCountry.setName(country.getName());
                    existingCountry.setDialingCountryCode(country.getDialingCountryCode());
                    existingCountry.setIsoCountryCode(country.getIsoCountryCode());
                    existingCountry.setEnabled(country.getEnabled());
                    return repository.save(existingCountry)
                            .doOnSuccess(publisher::sendUpdateEvent);
                });
    }

    @Override
    public Mono<Void> delete(final Integer id) {
        return repository.findById(id)
                .flatMap(existingCountry -> repository.deleteById(id)
                        .then(Mono.fromRunnable(() -> publisher.sendDeleteEvent(existingCountry))));
    }

    @Override
    public Mono<CountryEntity> findByName(final String name) {
        return repository.findByName(name);
    }
}

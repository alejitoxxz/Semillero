package co.edu.uco.reactiveexample.service.impl;

import co.edu.uco.reactiveexample.entity.CountryEntity;
<<<<<<< HEAD
import co.edu.uco.reactiveexample.service.CustomerService;
import reactor.core.publisher.Mono;

public class CountryServiceImpl implements CustomerService{

	@Override
	public Mono<CountryEntity> create(CountryEntity conuntry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<CountryEntity> update(int id, CountryEntity conuntry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<CountryEntity> delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<CountryEntity> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<CountryEntity> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<CountryEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	
=======
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
>>>>>>> branch 'master' of https://github.com/alejitoxxz/Semillero.git
}

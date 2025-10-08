package co.edu.uco.reactiveexample.service;

import co.edu.uco.reactiveexample.entity.CountryEntity;
import reactor.core.publisher.Mono;

public interface CustomerService {

	Mono<CountryEntity> create(CountryEntity conuntry);
		
	Mono<CountryEntity> update(int id,CountryEntity conuntry);
	
	Mono<CountryEntity> delete(int id);
	
	Mono<CountryEntity> findById(int id);
	
	Mono<CountryEntity> findByName(String name);
	
	Mono<CountryEntity> findAll();
}

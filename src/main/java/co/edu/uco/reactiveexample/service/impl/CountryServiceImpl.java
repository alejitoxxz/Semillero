package co.edu.uco.reactiveexample.service.impl;

import co.edu.uco.reactiveexample.entity.CountryEntity;
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

	
}

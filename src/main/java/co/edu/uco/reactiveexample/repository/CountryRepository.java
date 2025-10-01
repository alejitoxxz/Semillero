package co.edu.uco.reactiveexample.repository;

import co.edu.uco.reactiveexample.entity.CountryEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface CountryRepository extends ReactiveCrudRepository<CountryEntity, Integer> {

    // Método para buscar un país por nombre (devuelve un único resultado)
    Mono<CountryEntity> findByName(String name);
}

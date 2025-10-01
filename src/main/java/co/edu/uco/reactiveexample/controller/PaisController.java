package co.edu.uco.reactiveexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/countries")
public class PaisController {

    @GetMapping
    public Flux<String> getAllCountries() {
        return Flux.just("Hola", " ", "validando", "...");
    }
}

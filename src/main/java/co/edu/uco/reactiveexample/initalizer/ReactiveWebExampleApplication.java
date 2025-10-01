package co.edu.uco.reactiveexample.initalizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "co.edu.uco.reactiveexample")
public class ReactiveWebExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveWebExampleApplication.class, args);
    }
}

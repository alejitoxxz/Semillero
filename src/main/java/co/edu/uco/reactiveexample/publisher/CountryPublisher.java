package co.edu.uco.reactiveexample.publisher;

import co.edu.uco.reactiveexample.entity.CountryEntity;
import co.edu.uco.reactiveexample.publisher.event.CountryEvent;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Component
public class CountryPublisher {

    private final Sinks.Many<CountryEvent> sink = Sinks.many().multicast().onBackpressureBuffer();

    public void sendCreateEvent(final CountryEntity country) {
        sink.tryEmitNext(new CountryEvent(country, CountryEvent.EventType.CREATED));
    }

    public void sendUpdateEvent(final CountryEntity country) {
        sink.tryEmitNext(new CountryEvent(country, CountryEvent.EventType.UPDATED));
    }

    public void sendDeleteEvent(final CountryEntity country) {
        sink.tryEmitNext(new CountryEvent(country, CountryEvent.EventType.DELETED));
    }

    public Flux<CountryEvent> getEvents() {
        return sink.asFlux();
    }
    
    public Flux<CountryEvent> getStream() {
    			return sink.asFlux();
    }
}

package co.edu.uco.reactiveexample.publisher;
import co.edu.uco.reactiveexample.entity.CountryEntity;
import co.edu.uco.reactiveexample.publisher.event.CountryEvent;
import reactor.core.publisher.Sinks;

public class CountryPublisher {
	
	private final Sinks.Many<CountryEvent> sink= Sinks.many().multicast().onBackpressureBuffer();
	
	public void sendCreateEvent(final CountryEntity country) {
		sink.tryEmitNext(new CountryEvent(country, CountryEvent.EventType.CREATED));
	}
	
	public void sendCreateEvent(final CountryEntity country) {
		sink.tryEmitNext(new CountryEvent(country, CountryEvent.EventType.UPDATED));
	}
	
	public void sendCreateEvent(final CountryEntity country) {
		sink.tryEmitNext(new CountryEvent(country, CountryEvent.EventType.DELETED));
	}

}

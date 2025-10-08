package co.edu.uco.reactiveexample.publisher.event;

import co.edu.uco.reactiveexample.entity.CountryEntity;

public class CountryEvent {
    private CountryEntity countryEntity;
    private EventType event;
    
    public enum EventType {
        CREATED,
        UPDATED,
        DELETED
    }
    
    public CountryEvent(final CountryEntity countryEntity, final EventType event) {
        super();
        setCountryEntity(countryEntity);
        setEvent(event);
    }

    public CountryEntity getCountryEntity() {
        return countryEntity;
    }

    public void setCountryEntity(CountryEntity countryEntity) {
        this.countryEntity = countryEntity;
    }

    public EventType getEvent() {
        return event;
    }

    public void setEvent(EventType event) {
        this.event = event;
    }
}

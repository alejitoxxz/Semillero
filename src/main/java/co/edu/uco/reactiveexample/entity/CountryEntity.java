package co.edu.uco.reactiveexample.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table(name = "Country")
public final class CountryEntity {

    @Id
    private int id;

    @Column(value = "name")
    private String name;

    @Column(value = "dialingCountryCode")
    private String dialingCountryCode;

    @Column(value = "isoCountryCode")
    private String isoCountryCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = Objects.requireNonNullElse(name, "").trim();
    }

    public String getDialingCountryCode() {
        return dialingCountryCode;
    }

    public void setDialingCountryCode(String dialingCountryCode) {
        this.dialingCountryCode = Objects.requireNonNullElse(dialingCountryCode, "").trim();
    }

    public String getIsoCountryCode() {
        return isoCountryCode;
    }

    public void setIsoCountryCode(String isoCountryCode) {
        this.isoCountryCode = Objects.requireNonNullElse(isoCountryCode, "").trim();
    }
}

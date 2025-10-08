package co.edu.uco.reactiveexample.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table("country")
public final class CountryEntity {

    @Id
    private Integer id;

    @Column("name")
    private String name;

    @Column("dialing_country_code")
    private String dialingCountryCode;

    @Column("iso_country_code")
    private String isoCountryCode;

    @Column("enabled")
    private Boolean enabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}

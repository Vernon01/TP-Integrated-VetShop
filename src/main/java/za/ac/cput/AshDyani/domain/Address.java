package za.ac.cput.AshDyani.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ashdyani on 2015/04/19.
 */
@Embeddable
public class Address implements Serializable{

    private String street;
    private String town;
    private String code;

    private Address()
    {}

    public Address(Builder builder)
    {
        street = builder.street;
        town = builder.town;
      code = builder.code;
    }


    public String getStreet() {
        return street;
    }

    public String getTown() {
        return town;
    }

    public String getCode() {
        return code;
    }

    public static class Builder
    {
        private String street;
        private String town;
        private String code;

        public Builder(String code) {
            this.code = code;
        }

        public Builder street(String value)
        {
            this.street = value;
            return this;
        }

        public Builder town(String value)
        {
            this.town = value;
            return this;
        }

        public Builder copy(Address address)
        {
            street = address.street;
            town = address.town;
            code = address.code;
            return this;
        }

        public Address build()
        {
            return new Address(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (!street.equals(address.street)) return false;
        if (!town.equals(address.town)) return false;
        return code.equals(address.code);

    }

    @Override
    public int hashCode() {
        int result = street.hashCode();
        result = 31 * result + town.hashCode();
        result = 31 * result + code.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", town='" + town + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}

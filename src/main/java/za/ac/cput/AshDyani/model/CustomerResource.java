package za.ac.cput.AshDyani.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.AshDyani.domain.Address;
import za.ac.cput.AshDyani.domain.Pet;

import java.util.List;

/**
 * Created by ashdyani on 2015/08/15.
 */
public class CustomerResource extends ResourceSupport {

    private Integer cust_id;
    private String cust_name;
    private String cust_lname;
    private List<Pet> pet;
    private Address address;

    private CustomerResource() {
    }

    public CustomerResource(Builder builder) {
        cust_id = builder.cust_id;
        cust_name = builder.cust_name;
        cust_lname = builder.cust_lname;
        pet = builder.pet;
        address = builder.address;
    }

    public Integer getCust_id() {
        return cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public String getCust_lname() {
        return cust_lname;
    }

    public Address getAddress() {
        return address;
    }

    public static class Builder {
        private Integer cust_id;
        private String cust_name;
        private String cust_lname;
        private List<Pet> pet;
        private Address address;

        public Builder(String cust_name, String cust_lname) {
            this.cust_name = cust_name;
            this.cust_lname = cust_lname;
        }

        public Builder custId(Integer cust_id)
        {
            this.cust_id = cust_id;
            return this;
        }

        public Builder pets(List<Pet> value) {
            pet = value;
            return this;
        }

        public Builder address(Address value)
        {
            address = value;
            return this;
        }

        public Builder copy(CustomerResource cust) {
            cust_id = cust.cust_id;
            cust_name = cust.cust_name;
            cust_lname = cust.cust_lname;
            pet = cust.pet;
            address = cust.address;

            return this;
        }

        public CustomerResource build()
        {
            return new CustomerResource(this);
        }
    }

}

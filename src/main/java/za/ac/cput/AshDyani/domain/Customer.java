package za.ac.cput.AshDyani.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by ashdyani on 2015/04/19.
 */
@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cust_id;
    private String cust_name;
    private String cust_lname;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "cust_id")
    private List<Pet> pet;
    @Embedded
    private Address address;

    private Customer() {
    }

    public Customer(Builder builder) {
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

    public List<Pet> getPet() {
        return pet;
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

        public Builder copy(Customer cust) {
            cust_id = cust.cust_id;
            cust_name = cust.cust_name;
            cust_lname = cust.cust_lname;
            pet = cust.pet;
            address = cust.address;

            return this;
        }

        public Customer build()
        {
            return new Customer(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (!cust_id.equals(customer.cust_id)) return false;
        if (!cust_name.equals(customer.cust_name)) return false;
        if (!cust_lname.equals(customer.cust_lname)) return false;
        if (!pet.equals(customer.pet)) return false;
        return address.equals(customer.address);

    }

    @Override
    public int hashCode() {
        int result = cust_id.hashCode();
        result = 31 * result + cust_name.hashCode();
        result = 31 * result + cust_lname.hashCode();
        result = 31 * result + pet.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cust_id=" + cust_id +
                ", cust_name='" + cust_name + '\'' +
                ", cust_lname='" + cust_lname + '\'' +
                ", pet=" + pet +
                ", address=" + address +
                '}';
    }
}
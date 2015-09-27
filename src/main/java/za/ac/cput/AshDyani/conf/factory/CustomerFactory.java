package za.ac.cput.AshDyani.conf.factory;

import za.ac.cput.AshDyani.domain.Address;
import za.ac.cput.AshDyani.domain.Customer;
import za.ac.cput.AshDyani.domain.Pet;

import java.util.List;
import java.util.Map;

/**
 * Created by ashdyani on 2015/04/24.
 */
public class CustomerFactory {

    public static Customer createCustomer(String cust_name, String cust_lname, Address address, List<Pet> pets)
    {
        Customer customer = new Customer
                .Builder(cust_name, cust_lname)
                .address(address)
                .pets(pets)
                .build();

        return customer;
    }
}

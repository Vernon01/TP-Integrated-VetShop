package za.ac.cput.AshDyani.services;

import za.ac.cput.AshDyani.domain.Customer;
import za.ac.cput.AshDyani.domain.Pet;

import java.util.List;

/**
 * Created by ashdyani on 2015/05/18.
 */
public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer getCustomer(Integer cust_id);

    List<Pet> getPets(Integer pet_id);
}

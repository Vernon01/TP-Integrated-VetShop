package za.ac.cput.AshDyani.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.AshDyani.domain.Customer;
import za.ac.cput.AshDyani.domain.Pet;
import za.ac.cput.AshDyani.repository.CustomerRepository;
import za.ac.cput.AshDyani.services.CustomerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashdyani on 2015/05/18.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers()
    {
        List<Customer> customers = new ArrayList<>();
        Iterable<Customer> values = customerRepository.findAll();
        for (Customer value : values)
        {
            customers.add(value);
        }

        return customers;
    }

    @Override
    public Customer getCustomer(Integer cust_id)
    {
        return customerRepository.findOne(cust_id);
    }

    @Override
    public List<Pet> getPets(Integer pet_id)
    {
        return customerRepository.findOne(pet_id).getPet();
    }

}


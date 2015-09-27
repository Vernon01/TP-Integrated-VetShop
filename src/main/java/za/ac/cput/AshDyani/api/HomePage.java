package za.ac.cput.AshDyani.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.AshDyani.domain.Address;
import za.ac.cput.AshDyani.domain.Customer;
import za.ac.cput.AshDyani.services.CustomerService;

import java.util.List;

/**
 * Created by ashdyani on 2015/05/20.
 */
@RestController
@RequestMapping("/api/**")
public class HomePage
{
    Address address;
    @Autowired
    CustomerService customerService;
    @RequestMapping(value = "home", method = RequestMethod.GET)

    public String index()
    {
        return "WELCOME TO THIS HOMEPAGE";
    }
    @RequestMapping(value = "/customer",method = RequestMethod.GET)
    public Customer getCustomer()
    {
        Customer customer = new Customer.Builder("Asiphe", "Dyani")
                .address(address)
                .build();

        return customer;
    }
    @RequestMapping(value = "/customers",method = RequestMethod.GET)
    public List<Customer> getCustomers()
    {
        return customerService.getAllCustomers();

    }
}
package za.ac.cput.AshDyani.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.AshDyani.domain.Booking;
import za.ac.cput.AshDyani.domain.Customer;
import za.ac.cput.AshDyani.model.BookingResource;
import za.ac.cput.AshDyani.model.CustomerResource;
import za.ac.cput.AshDyani.services.BookingService;
import za.ac.cput.AshDyani.services.CustomerService;

/**
 * Created by ashdyani on 2015/08/15.
 */

@RestController
@RequestMapping("api/customer/**")
public class CustomerPage {

    @Autowired
    private CustomerService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String Index()
    {
        return "customer details";
    }

    @RequestMapping(value = "/{cust_id}", method = RequestMethod.GET)
    public CustomerResource getCustomer(@PathVariable Integer cust_id) {
        CustomerResource hateoas;
        Customer customer = service.getCustomer(cust_id);

        CustomerResource res = new CustomerResource
                .Builder(customer.getCust_name(), customer.getCust_lname())
                .address(customer.getAddress())
                .pets(customer.getPet())
                .build();

        Link customerDetails = new
                Link("http://localhost:8080/api/customer/" + res.getCust_id().toString())
                .withRel("customers");

        res.add(customerDetails);
        hateoas = res;

        return hateoas;
    }
}


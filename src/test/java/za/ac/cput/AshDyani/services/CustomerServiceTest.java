package za.ac.cput.AshDyani.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.AshDyani.App;
import za.ac.cput.AshDyani.conf.factory.AddressFactory;
import za.ac.cput.AshDyani.conf.factory.CustomerFactory;
import za.ac.cput.AshDyani.conf.factory.PetFactory;
import za.ac.cput.AshDyani.domain.Address;
import za.ac.cput.AshDyani.domain.Customer;
import za.ac.cput.AshDyani.domain.Pet;
import za.ac.cput.AshDyani.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ashdyani on 2015/05/19.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class CustomerServiceTest extends AbstractTestNGSpringContextTests{

    @Autowired
    CustomerService customerService;

    private Integer cust_id;
    private Integer pet_id;

    @Autowired
    private CustomerRepository customerRepository;

    List<Pet> pets = new ArrayList<>();

    @Test
    public void create() throws Exception
    {

        Map<String,String> values = new HashMap<String,String>();
        values.put("street","Jikeleza");
        values.put("town", "Hermanus");

        Address custAddress = AddressFactory.createAddress(values, "7200");

        Pet pet = PetFactory
                .createPet("Spotty", "Dog");

        pets.add(pet);


        Customer customer = CustomerFactory
                .createCustomer("Asiphe", "Dyani", custAddress, pets);

        customerRepository.save(customer);
        cust_id = customer.getCust_id();
        Assert.assertNotNull(customer.getCust_id());

    }

    @Test
    public void testGetPets() throws Exception
    {
        pets = customerService.getPets(cust_id);
        Assert.assertEquals(1, pets.size());
    }
}

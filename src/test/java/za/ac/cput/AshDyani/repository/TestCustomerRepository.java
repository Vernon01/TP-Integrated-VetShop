package za.ac.cput.AshDyani.repository;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ashdyani on 2015/04/30.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCustomerRepository extends AbstractTestNGSpringContextTests {

    private Integer cust_id;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testCreate() throws Exception
    {

        Map<String,String> values = new HashMap<String,String>();
        values.put("street","Jikeleza");
        values.put("town", "Hermanus");

        Address custAddress = AddressFactory.createAddress(values, "7200");

        List<Pet> pets = new ArrayList<Pet>();

        Pet pet = PetFactory
                .createPet("Spotty", "Dog");

        pets.add(pet);

        Customer customer = CustomerFactory
                .createCustomer("Asiphe", "Dyani", custAddress, pets);

        customerRepository.save(customer);
        cust_id = customer.getCust_id();
        Assert.assertNotNull(customer.getCust_id());

    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception
    {
        Customer customer = customerRepository.findOne(cust_id);

        Assert.assertNotNull(customer);
    }

  @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception
    {
        Customer customer = customerRepository.findOne(cust_id);

        Customer newCustomer = new Customer
                .Builder(customer.getCust_name(), customer.getCust_lname())
                .copy(customer)
                .address(customer.getAddress())
                .build();

        customerRepository.save(newCustomer);

        Customer updatedCustomer = customerRepository.findOne(cust_id);
        Assert.assertEquals(updatedCustomer.getAddress(), customer.getAddress());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception
    {
        Customer customer = customerRepository.findOne(cust_id);
        customerRepository.delete(customer);
        Customer deletedCustomer = customerRepository.findOne(cust_id);
        Assert.assertNull(deletedCustomer);

    }
}

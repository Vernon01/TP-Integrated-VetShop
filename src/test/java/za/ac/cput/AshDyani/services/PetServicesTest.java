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
import za.ac.cput.AshDyani.repository.PetRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ashdyani on 2015/05/19.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class PetServicesTest extends AbstractTestNGSpringContextTests{

    @Autowired
    PetService petService;

    @Autowired
    private PetRepository petRepository;

    private Integer pet_id;

    @Test
    public void testCreate() throws Exception
    {

        Map<String,String> values = new HashMap<String,String>();
        values.put("street","Jikeleza");
        values.put("town", "Hermanus");

        Address custAddress = AddressFactory.createAddress(values, "7200");


        List<Pet> pets = new ArrayList<>();

        Pet pet = PetFactory
                .createPet("Spotty", "Dog");

        pets.add(pet);

        Customer customer = CustomerFactory
                .createCustomer("Asiphe", "Dyani", custAddress, pets);

        petRepository.save(pet);
        pet_id =pet.getPet_id();
        Assert.assertNotNull(pet.getPet_id());
    }

    public void cleanUp() throws Exception
    {
        petRepository.deleteAll();
    }
}

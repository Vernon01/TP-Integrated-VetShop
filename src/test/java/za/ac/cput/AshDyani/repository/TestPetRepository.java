package za.ac.cput.AshDyani.repository;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
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
public class TestPetRepository extends AbstractTestNGSpringContextTests {

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


        List<Pet> pets = new ArrayList<Pet>();

        Pet pet = PetFactory
                .createPet("Spotty", "Dog");

        pets.add(pet);

        Customer customer = CustomerFactory
                .createCustomer("Asiphe", "Dyani", custAddress, pets);

        petRepository.save(pet);
        pet_id =pet.getPet_id();
        Assert.assertNotNull(pet.getPet_id());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception
    {
        Pet pet = petRepository.findOne(pet_id);
        Assert.assertNotNull(pet);
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception
    {
        Pet pet = petRepository.findOne(pet_id);

        Pet newPet = new Pet
                .Builder(pet.getPet_name())
                .copy(pet)
                .petSpecies(pet.getPet_species())
                .build();

        petRepository.save(newPet);
        Pet updatePet = petRepository.findOne(pet_id);
        Assert.assertEquals(updatePet.getPet_species(), "Dog");
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception
    {
        Pet pet = petRepository.findOne(pet_id);
        petRepository.delete(pet);
        Pet deletedPet = petRepository.findOne(pet_id);
        Assert.assertNull(deletedPet);
    }


}

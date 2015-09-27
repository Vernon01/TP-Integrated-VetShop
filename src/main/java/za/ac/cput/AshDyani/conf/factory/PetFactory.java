package za.ac.cput.AshDyani.conf.factory;

import za.ac.cput.AshDyani.domain.Customer;
import za.ac.cput.AshDyani.domain.Pet;

/**
 * Created by ashdyani on 2015/04/24.
 */
public class PetFactory {

    public static Pet createPet(String pet_name, String pet_species)
    {
        Pet pet = new Pet
                .Builder(pet_name)
                .petSpecies(pet_species)
                .build();

        return pet;

    }
}

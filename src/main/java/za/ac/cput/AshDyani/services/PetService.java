package za.ac.cput.AshDyani.services;

import za.ac.cput.AshDyani.domain.Customer;
import za.ac.cput.AshDyani.domain.Medication;
import za.ac.cput.AshDyani.domain.Pet;

import java.util.List;

/**
 * Created by ashdyani on 2015/05/18.
 */
public interface PetService {

    List<Pet> getAllPets();

    Pet getPet(Integer pet_id);
}

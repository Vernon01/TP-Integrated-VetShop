package za.ac.cput.AshDyani.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.AshDyani.domain.Medication;
import za.ac.cput.AshDyani.domain.Pet;
import za.ac.cput.AshDyani.repository.PetRepository;
import za.ac.cput.AshDyani.services.PetService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashdyani on 2015/05/18.
 */

@Service
public class PetServiceImpl implements PetService{

    @Autowired
    PetRepository petRepository;

    @Override
    public List<Pet> getAllPets()
    {
        List<Pet> pets = new ArrayList<>();
        Iterable<Pet> values = petRepository.findAll();
        for(Pet value: values)
        {
            pets.add(value);
        }

        return pets;
    }

    @Override
    public Pet getPet(Integer pet_id) {
        return petRepository.findOne(pet_id);
    }
}

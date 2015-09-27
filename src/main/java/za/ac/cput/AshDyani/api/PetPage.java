package za.ac.cput.AshDyani.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.AshDyani.domain.Pet;
import za.ac.cput.AshDyani.model.PetResource;
import za.ac.cput.AshDyani.services.PetService;

import java.util.List;

/**
 * Created by ashdyani on 2015/05/20.
 */
@RestController
@RequestMapping("/pet/**")
public class PetPage {

    @Autowired
    PetService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String Index()
    {
        return "pet details";
    }

    @RequestMapping(value = "/{pet_id}", method = RequestMethod.GET)
    public PetResource getStudent(@PathVariable Integer pet_id)
    {
        PetResource hateoas;
        Pet pet = service.getPet(pet_id);

        PetResource res = new PetResource
                .Builder(pet.getPet_name())
                .petSpecies(pet.getPet_species())
                .build();

        Link petDetails = new
                Link("http://localhost:8080/api/student/" + res.getPet_id().toString())
                .withRel("students");

        res.add(petDetails);
        hateoas = res;

        return hateoas;
    }
}

package za.ac.cput.AshDyani.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by ashdyani on 2015/08/15.
 */
public class PetResource extends ResourceSupport {

    private Integer pet_id;
    private String pet_species;
    private String pet_name;

    private PetResource()
    {}

    public PetResource(Builder builder)
    {
        pet_id = builder.pet_id;
        pet_species = builder.pet_species;
        pet_name = builder.pet_name;

    }

    public Integer getPet_id() {
        return pet_id;
    }

    public String getPet_species() {
        return pet_species;
    }

    public String getPet_name() {
        return pet_name;
    }


    public static class Builder
    {
        private Integer pet_id;
        private String pet_species;
        private String pet_name;

        public Builder petId(int pet_id)
        {
            this.pet_id = pet_id;
            return this;
        }

        public Builder petSpecies(String value)
        {
            this.pet_species = value;
            return this;
        }

        public Builder(String pet_name)
        {
            this.pet_name = pet_name;
        }

        public Builder copy(PetResource pet)
        {
            pet_id = pet.pet_id;
            pet_species = pet.pet_species;
            pet_name = pet.pet_name;
            return this;
        }

        public PetResource build()
        {
            return new PetResource(this);
        }
    }
}

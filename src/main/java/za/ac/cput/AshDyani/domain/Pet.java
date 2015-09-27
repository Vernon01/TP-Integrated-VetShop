package za.ac.cput.AshDyani.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ashdyani on 2015/04/19.
 */
@Entity
public class Pet implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pet_id;
    private String pet_species;
    private String pet_name;

    private Pet()
    {}

    public Pet(Builder builder)
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

        public Builder copy(Pet pet)
        {
            pet_id = pet.pet_id;
            pet_species = pet.pet_species;
            pet_name = pet.pet_name;
            return this;
        }

        public Pet build()
        {
            return new Pet(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pet pet = (Pet) o;

        if (!pet_id.equals(pet.pet_id)) return false;
        if (!pet_species.equals(pet.pet_species)) return false;
        return pet_name.equals(pet.pet_name);

    }

    @Override
    public int hashCode() {
        int result = pet_id.hashCode();
        result = 31 * result + pet_species.hashCode();
        result = 31 * result + pet_name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "pet_id=" + pet_id +
                ", pet_species='" + pet_species + '\'' +
                ", pet_name='" + pet_name + '\'' +
                '}';
    }
}

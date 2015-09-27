package za.ac.cput.AshDyani.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.AshDyani.domain.Doctor;
import za.ac.cput.AshDyani.domain.Pet;

import java.util.Date;

/**
 * Created by ashdyani on 2015/08/15.
 */
public class PrescriptionResource extends ResourceSupport {

    private Integer prescrip_id;
    private Date prescrip_date;
    private Doctor doctor;
    private Pet pet;

    private PrescriptionResource()
    {}

    public PrescriptionResource (Builder builder)
    {
        prescrip_id = builder.prescrip_id;
        prescrip_date = builder.prescrip_date;
        doctor = builder.doctor;
        pet = builder.pet;
    }

    public Integer getPrescrip_id() {
        return prescrip_id;
    }

    public Date getPrescrip_date() {
        return prescrip_date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Pet getPet() {
        return pet;
    }

    public static class Builder {
        private Integer prescrip_id;
        private Date prescrip_date;
        private Doctor doctor;
        private Pet pet;

        public Builder(Doctor doctor, Pet pet) {
            this.doctor = doctor;
            this.pet = pet;
        }

        public Builder prescripId(Integer prescrip_id) {
            this.prescrip_id = prescrip_id;
            return this;
        }

        public Builder prescripDate(Date value) {
            this.prescrip_date = value;
            return this;
        }

        public Builder copy(PrescriptionResource prescription) {
            prescrip_id = prescription.prescrip_id;
            prescrip_date = prescription.prescrip_date;
            doctor = prescription.doctor;
            pet = prescription.pet;

            return this;
        }

        public PrescriptionResource build() {
            return new PrescriptionResource(this);
        }
    }
}

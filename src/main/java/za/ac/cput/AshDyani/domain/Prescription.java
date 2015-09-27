package za.ac.cput.AshDyani.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by ashdyani on 2015/04/19.
 */
@Entity
public class Prescription implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer prescrip_id;
    private Date prescrip_date;
    @OneToOne
    @JoinColumn(name = "prescrip_id")
    private Doctor doctor;
    @OneToOne
    @JoinColumn(name = "prescrip_id")
    private Pet pet;

    private Prescription()
    {}

    public Prescription (Builder builder)
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

        public Builder(Doctor doctor, Pet pet)
        {
            this.doctor = doctor;
            this.pet = pet;
        }

        public Builder prescripId(Integer prescrip_id)
        {
            this.prescrip_id = prescrip_id;
            return this;
        }

        public Builder prescripDate(Date value)
        {
            this.prescrip_date = value;
            return this;
        }

        public Builder copy(Prescription prescription)
        {
            prescrip_id = prescription.prescrip_id;
            prescrip_date = prescription.prescrip_date;
            doctor = prescription.doctor;
            pet = prescription.pet;

            return this;
        }

        public Prescription build()
        {
            return new Prescription(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Builder builder = (Builder) o;

            if (!prescrip_id.equals(builder.prescrip_id)) return false;
            if (!prescrip_date.equals(builder.prescrip_date)) return false;
            if (!doctor.equals(builder.doctor)) return false;
            return pet.equals(builder.pet);

        }

        @Override
        public int hashCode() {
            int result = prescrip_id.hashCode();
            result = 31 * result + prescrip_date.hashCode();
            result = 31 * result + doctor.hashCode();
            result = 31 * result + pet.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "prescrip_id=" + prescrip_id +
                    ", prescrip_date=" + prescrip_date +
                    ", doctor=" + doctor +
                    ", pet=" + pet +
                    '}';
        }
    }
}

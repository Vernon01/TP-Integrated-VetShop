package za.ac.cput.AshDyani.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ashdyani on 2015/04/21.
 */
@Entity
public class Prescription_Line implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pl_id;
    @ManyToOne
   // @JoinColumn(name = "pl_id")
    private Prescription prescription;
    @ManyToOne
  /*@JoinColumn(name = "pl_id") should be mapped with insert="false"
    update = "false"*/
    private Medication medication;

    private Prescription_Line()
    {}

    public Prescription_Line (Builder builder)
    {
        pl_id = builder.pl_id;
        prescription = builder.prescription;
        medication = builder.medication;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public Medication getMedication() {
        return medication;
    }

    public Integer getPl_id() {
        return pl_id;
    }

    public static class Builder
    {
        private Prescription prescription;
        private Medication medication;
        private Integer pl_id;

        public Builder(Prescription prescription, Medication medication)
        {
            this.prescription = prescription;
            this.medication = medication;
        }

        public Builder pl(Integer pl_id)
        {
            this.pl_id = pl_id;
            return this;
        }

        public Builder copy(Prescription_Line builder)
        {
            prescription = builder.prescription;
            medication = builder.medication;
            return this;
        }

        public Prescription_Line build()
        {
            return new Prescription_Line(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Prescription_Line that = (Prescription_Line) o;

        if (!pl_id.equals(that.pl_id)) return false;
        if (!prescription.equals(that.prescription)) return false;
        return medication.equals(that.medication);

    }

    @Override
    public int hashCode() {
        int result = pl_id.hashCode();
        result = 31 * result + prescription.hashCode();
        result = 31 * result + medication.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Prescription_Line{" +
                "pl_id=" + pl_id +
                ", prescription=" + prescription +
                ", medication=" + medication +
                '}';
    }
}

package za.ac.cput.AshDyani.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ashdyani on 2015/04/19.
 */
@Entity
public class Medication implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer med_id;
    private String med_type;
    private String med_name;

    private Medication ()
    {}

    public Medication(Builder builder)
    {
        med_id = builder.med_id;
        med_type = builder.med_type;
        med_name = builder.med_name;
    }

    public String getMed_type() {
        return med_type;
    }

    public Integer getMed_id() {
        return med_id;
    }

    public String getMed_name() {
        return med_name;
    }

    public static class Builder
    {
        private Integer med_id;
        private String med_type;
        private String med_name;

        public Builder(String med_type, String med_name)
        {
            this.med_name = med_name;
            this.med_type = med_type;
        }

        public Builder medId(int med_id)
        {
            this.med_id = med_id;
            return this;
        }

        public Builder copy(Medication medication)
        {
            med_id = medication.med_id;
            med_type =  medication.med_type;
            med_name = medication.med_name;

            return this;
        }

        public Medication build()
        {
            return new Medication(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Medication that = (Medication) o;

        if (!med_id.equals(that.med_id)) return false;
        if (!med_type.equals(that.med_type)) return false;
        return med_name.equals(that.med_name);

    }

    @Override
    public int hashCode() {
        int result = med_id.hashCode();
        result = 31 * result + med_type.hashCode();
        result = 31 * result + med_name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "med_id=" + med_id +
                ", med_type='" + med_type + '\'' +
                ", med_name='" + med_name + '\'' +
                '}';
    }
}

package za.ac.cput.AshDyani.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by ashdyani on 2015/08/15.
 */
public class MedicationResource extends ResourceSupport {

    private Integer med_id;
    private String med_type;
    private String med_name;

    private MedicationResource ()
    {}

    public MedicationResource(Builder builder)
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

        public Builder copy(MedicationResource medication)
        {
            med_id = medication.med_id;
            med_type =  medication.med_type;
            med_name = medication.med_name;

            return this;
        }

        public MedicationResource build()
        {
            return new MedicationResource(this);
        }
    }
}

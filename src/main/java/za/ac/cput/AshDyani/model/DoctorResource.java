package za.ac.cput.AshDyani.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.AshDyani.domain.Address;

import javax.persistence.Embedded;

/**
 * Created by ashdyani on 2015/08/15.
 */
public class DoctorResource extends ResourceSupport {

    private Integer doc_id;
    private String doc_name;
    @Embedded
    private Address address;

    private DoctorResource()
    {}

    public DoctorResource(Builder builder)
    {
        doc_id = builder.doc_id;
        doc_name = builder.doc_name;
        address = builder.address;
    }

    public Integer getDoc_id() {
        return doc_id;
    }

    public String getDoc_name() {
        return doc_name;
    }

    public Address getAddress() {
        return address;
    }

    public static class Builder
    {
        private Integer doc_id;
        private String doc_name;
        private Address address;

        public Builder(String doc_name)
        {
            this.doc_name = doc_name;
        }

        public Builder docId(Integer doc_id)
        {
            this.doc_id = doc_id;
            return this;
        }

        public Builder address(Address value)
        {
            address = value;
            return this;
        }

        public Builder copy(DoctorResource doc)
        {
            doc_id = doc.doc_id;
            doc_name = doc.doc_name;
            address = doc.address;
            return this;
        }

        public DoctorResource build()
        {
            return new DoctorResource(this);
        }
    }
}

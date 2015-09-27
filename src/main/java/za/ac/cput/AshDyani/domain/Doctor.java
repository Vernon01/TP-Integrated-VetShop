package za.ac.cput.AshDyani.domain;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ashdyani on 2015/04/19.
 */
@Entity
public class Doctor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer doc_id;
    private String doc_name;
    @Embedded
    private Address address;

    private Doctor()
    {}

    public Doctor(Builder builder)
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

        public Builder copy(Doctor doc)
        {
            doc_id = doc.doc_id;
            doc_name = doc.doc_name;
            address = doc.address;
            return this;
        }

        public Doctor build()
        {
            return new Doctor(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Doctor doctor = (Doctor) o;

        if (!doc_id.equals(doctor.doc_id)) return false;
        if (!doc_name.equals(doctor.doc_name)) return false;
        return address.equals(doctor.address);

    }

    @Override
    public int hashCode() {
        int result = doc_id.hashCode();
        result = 31 * result + doc_name.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doc_id=" + doc_id +
                ", doc_name='" + doc_name + '\'' +
                ", address=" + address +
                '}';
    }
}

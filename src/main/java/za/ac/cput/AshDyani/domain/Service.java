package za.ac.cput.AshDyani.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ashdyani on 2015/04/19.
 */
@Entity
public class Service implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer service_id;
    @JoinColumn(name = "service_id")
    private Doctor doctor;
    @JoinColumn(name = "service_id")
    private Booking booking;

    private Service()
    {}

    public Service(Builder builder)
    {
        service_id = builder.service_id;
        doctor = builder.doctor;
        booking = builder.booking;
    }

    public Integer getService_id() {
        return service_id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Booking getBooking() {
        return booking;
    }

    public static class Builder
    {
        private Integer service_id;
        private Doctor doctor;
        private Booking booking;

        public Builder (Doctor doctor, Booking booking)
        {
            this.doctor = doctor;
            this.booking = booking;
        }

        public Builder serviceId(Integer service_id)
        {
            this.service_id = service_id;
            return this;
        }

        public Builder copy(Service service)
        {
            service_id = service.service_id;
            doctor = service.doctor;
            booking = service.booking;
            return this;
        }

        public Service build()
        {
            return new Service(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Service service = (Service) o;

        if (!service_id.equals(service.service_id)) return false;
        if (!doctor.equals(service.doctor)) return false;
        return booking.equals(service.booking);

    }

    @Override
    public int hashCode() {
        int result = service_id.hashCode();
        result = 31 * result + doctor.hashCode();
        result = 31 * result + booking.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Service{" +
                "service_id=" + service_id +
                ", doctor=" + doctor +
                ", booking=" + booking +
                '}';
    }
}

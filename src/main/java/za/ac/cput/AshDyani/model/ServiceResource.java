package za.ac.cput.AshDyani.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.AshDyani.domain.Booking;
import za.ac.cput.AshDyani.domain.Doctor;


/**
 * Created by ashdyani on 2015/08/15.
 */
public class ServiceResource extends ResourceSupport {

    private Integer service_id;
    private Doctor doctor;
    private Booking booking;

    private ServiceResource()
    {}

    public ServiceResource(Builder builder)
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

        public Builder copy(ServiceResource service)
        {
            service_id = service.service_id;
            doctor = service.doctor;
            booking = service.booking;
            return this;
        }

        public ServiceResource build()
        {
            return new ServiceResource(this);
        }
    }
}

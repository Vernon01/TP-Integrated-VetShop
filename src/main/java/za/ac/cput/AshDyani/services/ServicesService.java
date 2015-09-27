package za.ac.cput.AshDyani.services;

import za.ac.cput.AshDyani.domain.Booking;
import za.ac.cput.AshDyani.domain.Doctor;
import za.ac.cput.AshDyani.domain.Pet;
import za.ac.cput.AshDyani.domain.Service;

import java.util.List;

/**
 * Created by ashdyani on 2015/05/18.
 */
public interface ServicesService {

    List<Service> getAllServices();

    Service getService(Integer service_id);

    Doctor getDoctor(Integer doc_id);

    Booking getBooking(Integer book_id);
}

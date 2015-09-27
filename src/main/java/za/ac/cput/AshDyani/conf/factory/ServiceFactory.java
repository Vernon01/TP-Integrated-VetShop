package za.ac.cput.AshDyani.conf.factory;

import za.ac.cput.AshDyani.domain.Booking;
import za.ac.cput.AshDyani.domain.Doctor;
import za.ac.cput.AshDyani.domain.Service;

/**
 * Created by ashdyani on 2015/04/24.
 */
public class ServiceFactory {

    public static Service createService (Doctor doctor, Booking booking)
    {
        Service service = new Service
                .Builder(doctor, booking)
                .build();

        return service;

    }
}

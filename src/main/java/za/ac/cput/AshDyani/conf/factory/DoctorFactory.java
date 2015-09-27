package za.ac.cput.AshDyani.conf.factory;

import za.ac.cput.AshDyani.domain.Address;
import za.ac.cput.AshDyani.domain.Doctor;

/**
 * Created by ashdyani on 2015/04/24.
 */
public class DoctorFactory {

    public static Doctor createDoctor(String doc_name, Address address)
    {
        Doctor doctor = new Doctor
                .Builder(doc_name)
                .address(address)
                .build();

        return doctor;
    }
}

package za.ac.cput.AshDyani.services;

import za.ac.cput.AshDyani.domain.Customer;
import za.ac.cput.AshDyani.domain.Doctor;

import java.util.List;

/**
 * Created by ashdyani on 2015/05/18.
 */
public interface DoctorService {

    List<Doctor> getAllDoctors();

    Doctor getDoctor(Integer doc_id);

}

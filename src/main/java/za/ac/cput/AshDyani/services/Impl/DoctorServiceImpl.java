package za.ac.cput.AshDyani.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.AshDyani.domain.Doctor;
import za.ac.cput.AshDyani.repository.DoctorRepository;
import za.ac.cput.AshDyani.services.DoctorService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashdyani on 2015/05/18.
 */
@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public List<Doctor> getAllDoctors()
    {
        List<Doctor> doctors = new ArrayList<>();
        Iterable<Doctor> values = doctorRepository.findAll();
        for (Doctor value : values)
        {
            doctors.add(value);
        }

        return doctors;

    }

    @Override
    public Doctor getDoctor(Integer doc_id) {
        return doctorRepository.findOne(doc_id);
    }

}

package za.ac.cput.AshDyani.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.AshDyani.domain.Doctor;
import za.ac.cput.AshDyani.domain.Pet;
import za.ac.cput.AshDyani.domain.Prescription;
import za.ac.cput.AshDyani.repository.PrescriptionRepository;
import za.ac.cput.AshDyani.services.PrescriptionService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashdyani on 2015/05/18.
 */
@Service
public class PrescriptionServiceImpl  implements PrescriptionService{

    @Autowired
    PrescriptionRepository prescriptionRepository;

    @Override
    public List<Prescription> getAllPrescriptions()
    {
        List<Prescription> prescriptions = new ArrayList<>();
        Iterable<Prescription> values = prescriptionRepository.findAll();
        for(Prescription value : values)
        {
            prescriptions.add(value);
        }

        return prescriptions;

    }

    @Override
    public Prescription getPrescription(Integer prescrip_id) {
        return prescriptionRepository.findOne(prescrip_id);
    }

    @Override
    public Doctor getDoctor(Integer doc_id) {
        return prescriptionRepository.findOne(doc_id).getDoctor();
    }

    @Override
    public Pet getPet(Integer pet_id) {
        return prescriptionRepository.findOne(pet_id).getPet();
    }

}

package za.ac.cput.AshDyani.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.AshDyani.domain.Invoice;
import za.ac.cput.AshDyani.domain.Medication;
import za.ac.cput.AshDyani.repository.MedicationRepository;
import za.ac.cput.AshDyani.services.MedicationService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashdyani on 2015/05/18.
 */
@Service
public class MedicationServiceImpl implements MedicationService{

    @Autowired
    MedicationRepository medicationRepository;

    @Override
    public List<Medication> getAllMedications()
    {
        List<Medication> medications = new ArrayList<>();
        Iterable<Medication> values = medicationRepository.findAll();

        for (Medication value : values)
        {
            medications.add(value);
        }

        return medications;
    }

    @Override
    public Medication getMedication(Integer med_id) {
        return medicationRepository.findOne(med_id);
    }


}

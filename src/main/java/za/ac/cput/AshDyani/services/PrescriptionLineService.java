package za.ac.cput.AshDyani.services;

import za.ac.cput.AshDyani.domain.Medication;
import za.ac.cput.AshDyani.domain.Prescription;

import java.util.List;

/**
 * Created by ashdyani on 2015/05/18.
 */
public interface PrescriptionLineService {

    List<Medication> getAllMedications();
    List<Prescription> getAllPrescriptions();
}

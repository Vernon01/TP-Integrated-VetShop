package za.ac.cput.AshDyani.services;

import za.ac.cput.AshDyani.domain.Invoice;
import za.ac.cput.AshDyani.domain.Medication;

import java.util.List;

/**
 * Created by ashdyani on 2015/05/18.
 */
public interface MedicationService {

    List<Medication> getAllMedications();

    Medication getMedication(Integer med_id);
}

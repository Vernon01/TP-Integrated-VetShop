package za.ac.cput.AshDyani.services;

import za.ac.cput.AshDyani.domain.*;

import java.util.List;

/**
 * Created by ashdyani on 2015/05/18.
 */
public interface PrescriptionService {

    List<Prescription> getAllPrescriptions();

    Prescription getPrescription(Integer prescrip_id);

    Doctor getDoctor(Integer doc_id);

    Pet getPet(Integer pet_id);
    //List<Pet> getPets();
    //List<Doctor> getDoctors();
}

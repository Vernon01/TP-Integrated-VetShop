package za.ac.cput.AshDyani.conf.factory;

import za.ac.cput.AshDyani.domain.Doctor;
import za.ac.cput.AshDyani.domain.Pet;
import za.ac.cput.AshDyani.domain.Prescription;

import java.util.Date;

/**
 * Created by ashdyani on 2015/04/24.
 */
public class PrescriptionFactory {

    public static Prescription createPrescription(Doctor doctor, Pet pet, Date prescrip_date)
    {
        Prescription prescription = new Prescription
                .Builder(doctor, pet)
                .prescripDate(prescrip_date)
                .build();

        return prescription;
    }
}

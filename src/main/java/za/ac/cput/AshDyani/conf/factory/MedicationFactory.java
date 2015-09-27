package za.ac.cput.AshDyani.conf.factory;

import za.ac.cput.AshDyani.domain.Medication;

/**
 * Created by ashdyani on 2015/04/24.
 */
public class MedicationFactory {

    public static Medication createMedication(String med_name, String med_type)
    {
        Medication medication = new Medication
                .Builder(med_name, med_type)
                .build();

        return medication;
    }
}

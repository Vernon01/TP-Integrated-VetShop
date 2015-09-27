package za.ac.cput.AshDyani.conf.factory;

import za.ac.cput.AshDyani.domain.Medication;
import za.ac.cput.AshDyani.domain.Prescription;
import za.ac.cput.AshDyani.domain.Prescription_Line;

/**
 * Created by ashdyani on 2015/04/24.
 */
public class Prescription_LineFactory {

    public static Prescription_Line createPrescription (Prescription prescription, Medication medication)
    {
        Prescription_Line prescription_line = new Prescription_Line
                .Builder(prescription, medication)
                .build();

        return prescription_line;

    }
}

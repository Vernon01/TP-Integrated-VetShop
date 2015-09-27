package za.ac.cput.AshDyani.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.AshDyani.App;
import za.ac.cput.AshDyani.conf.factory.PrescriptionFactory;
import za.ac.cput.AshDyani.domain.Doctor;
import za.ac.cput.AshDyani.domain.Pet;
import za.ac.cput.AshDyani.domain.Prescription;
import za.ac.cput.AshDyani.repository.PrescriptionRepository;

import java.util.Date;

/**
 * Created by ashdyani on 2015/05/19.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class PrescriptionServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    PrescriptionService prescriptionService;

    private Integer prescrip_id;
    private Doctor doctor;
    private Pet pet;

    private Date prescrip_date = new Date(2015, 03, 01);

    @Autowired
    PrescriptionRepository prescriptionRepository;

    @Test
    public void create() throws Exception
    {
        Prescription prescription = PrescriptionFactory
                .createPrescription(doctor, pet, prescrip_date);
        prescriptionRepository.save(prescription);
        prescrip_id = prescription.getPrescrip_id();
        Assert.assertNotNull(prescription.getPrescrip_id());

    }

    public void cleanUp() throws Exception
    {
        prescriptionRepository.deleteAll();
    }
}

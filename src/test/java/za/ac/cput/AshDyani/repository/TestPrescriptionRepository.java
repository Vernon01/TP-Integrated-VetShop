package za.ac.cput.AshDyani.repository;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.AshDyani.App;
import za.ac.cput.AshDyani.conf.factory.*;
import za.ac.cput.AshDyani.domain.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ashdyani on 2015/05/07.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestPrescriptionRepository extends AbstractTestNGSpringContextTests{

    private Integer prescrip_id;
    private Doctor doctor;
    private Pet pet;

    private Date prescrip_date = new Date(2015, 03, 01);

    @Autowired
    PrescriptionRepository prescriptionRepository;

    @Test
    public void testCreate() throws Exception
    {
        Prescription prescription = PrescriptionFactory
                .createPrescription(doctor, pet, prescrip_date);
        prescriptionRepository.save(prescription);
        prescrip_id = prescription.getPrescrip_id();
        Assert.assertNotNull(prescription.getPrescrip_id());

    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception
    {
        Prescription prescription = prescriptionRepository.findOne(prescrip_id);
        Assert.assertNotNull(prescription);
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception
    {
        Prescription prescription = prescriptionRepository.findOne(prescrip_id);

        Prescription newPrescription = new Prescription
                .Builder(prescription.getDoctor(), prescription.getPet())
                .copy(prescription)
                .prescripDate(prescrip_date)
                .build();

        prescriptionRepository.save(newPrescription);
        Prescription updatedPrescription = prescriptionRepository.findOne(prescrip_id);
        Assert.assertEquals(updatedPrescription.getPrescrip_date(), prescription.getPrescrip_date());

    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete () throws Exception
    {
        Prescription prescription = prescriptionRepository.findOne(prescrip_id);
        prescriptionRepository.delete(prescription);
        Prescription deletedPrescription = prescriptionRepository.findOne(prescrip_id);
        Assert.assertNull(deletedPrescription);

    }
}

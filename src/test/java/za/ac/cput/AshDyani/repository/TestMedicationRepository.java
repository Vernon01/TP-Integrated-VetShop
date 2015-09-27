package za.ac.cput.AshDyani.repository;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.AshDyani.App;
import za.ac.cput.AshDyani.conf.factory.MedicationFactory;
import za.ac.cput.AshDyani.domain.Medication;

/**
 * Created by ashdyani on 2015/05/07.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestMedicationRepository extends AbstractTestNGSpringContextTests{

    private Integer med_id;

    @Autowired
    MedicationRepository medicationRepository;

    @Test
    public void testCreate() throws Exception
    {
        Medication medication = MedicationFactory
                .createMedication("Tablet", "Grandpa");
        medicationRepository.save(medication);
        med_id = medication.getMed_id();
        Assert.assertNotNull(medication.getMed_id());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception
    {
        Medication medication = medicationRepository.findOne(med_id);
        Assert.assertNotNull(medication);

    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception
    {
        Medication medication = medicationRepository.findOne(med_id);

        Medication newMedication = new Medication
                .Builder(medication.getMed_name(), medication.getMed_type())
                .copy(medication)
                .build();

        medicationRepository.save(newMedication);
        Medication updatedMedication = medicationRepository.findOne(med_id);
        Assert.assertEquals(updatedMedication.getMed_name(), medication.getMed_name());

    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception
    {
        Medication medication = medicationRepository.findOne(med_id);
        medicationRepository.delete(medication);
        Medication deletedMedication = medicationRepository.findOne(med_id);
        Assert.assertNull(deletedMedication);
    }

}

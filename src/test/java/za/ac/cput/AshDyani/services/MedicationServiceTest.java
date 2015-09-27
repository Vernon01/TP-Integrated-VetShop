package za.ac.cput.AshDyani.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.AshDyani.App;
import org.testng.annotations.Test;
import org.testng.Assert;
import za.ac.cput.AshDyani.conf.factory.MedicationFactory;
import za.ac.cput.AshDyani.domain.Medication;
import za.ac.cput.AshDyani.repository.MedicationRepository;

/**
 * Created by ashdyani on 2015/05/19.
 */

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class MedicationServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    MedicationService medicationService;

    private Integer med_id;

    @Autowired
    MedicationRepository medicationRepository;

    @Test
    public void create() throws Exception
    {
        Medication medication = MedicationFactory
                .createMedication("Tablet", "Grandpa");
        medicationRepository.save(medication);
        med_id = medication.getMed_id();
        Assert.assertNotNull(medication.getMed_id());
    }

    public void cleanUp() throws Exception
    {
        medicationRepository.deleteAll();
    }

}

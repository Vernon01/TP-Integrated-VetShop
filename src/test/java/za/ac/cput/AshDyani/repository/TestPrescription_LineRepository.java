package za.ac.cput.AshDyani.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.AshDyani.App;
import za.ac.cput.AshDyani.conf.factory.Prescription_LineFactory;
import za.ac.cput.AshDyani.domain.Medication;
import za.ac.cput.AshDyani.domain.Prescription;
import za.ac.cput.AshDyani.domain.Prescription_Line;

/**
 * Created by ashdyani on 2015/05/07.
 */

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestPrescription_LineRepository extends AbstractTestNGSpringContextTests{

    private Integer pl_id;
    private Medication medication;
    private Prescription prescription;

    @Autowired
    Prescription_LineRepository plrepository;

    @Test
    public void testCreate() throws Exception
    {
        Prescription_Line pl = Prescription_LineFactory
                .createPrescription(prescription, medication);

        plrepository.save(pl);
        pl_id = pl.getPl_id();
        Assert.assertNotNull(pl.getPl_id());

    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception
    {
        Prescription_Line prescription_line = plrepository.findOne(pl_id);
        Assert.assertNotNull(prescription_line);
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception
    {
        Prescription_Line prescription_line = plrepository.findOne(pl_id);

        Prescription_Line newPrescrip_Line = new Prescription_Line
                .Builder(prescription_line.getPrescription(), prescription_line.getMedication())
                .copy(prescription_line)
                .build();

        plrepository.save(newPrescrip_Line);
        Prescription_Line updatePrescrip_Line = plrepository.findOne(pl_id);
        Assert.assertEquals(updatePrescrip_Line.getPrescription(), prescription_line.getPrescription());

    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception
    {
        Prescription_Line prescription_line = plrepository.findOne(pl_id);
        plrepository.delete(prescription_line);
        Prescription_Line deletedPrescrip_Line = plrepository.findOne(pl_id);
        Assert.assertNull(deletedPrescrip_Line);
    }

}


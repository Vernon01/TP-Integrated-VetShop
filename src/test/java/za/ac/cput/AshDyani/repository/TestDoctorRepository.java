package za.ac.cput.AshDyani.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.AshDyani.App;
import za.ac.cput.AshDyani.conf.factory.AddressFactory;
import za.ac.cput.AshDyani.conf.factory.DoctorFactory;
import za.ac.cput.AshDyani.domain.Address;
import za.ac.cput.AshDyani.domain.Doctor;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by ashdyani on 2015/05/07.
 */

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestDoctorRepository extends AbstractTestNGSpringContextTests{

    private Integer doc_id;
    @Autowired
    DoctorRepository doctorRepository;

    @Test
    public void testCreate() throws Exception
    {

        Map<String,String> values = new HashMap<String,String>();
        values.put("street","Hemels");
        values.put("town", "Onrus");

        Address docAddress = AddressFactory.createAddress(values, "7200");

        Doctor doctor = DoctorFactory.createDoctor("Dr Sheldon", docAddress);

        doctorRepository.save(doctor);
        doc_id = doctor.getDoc_id();
        Assert.assertNotNull(doctor.getDoc_id());

    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception
    {
        Doctor doctor = doctorRepository.findOne(doc_id);

        Assert.assertNotNull(doctor);

    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception
    {
        Doctor doctor = doctorRepository.findOne(doc_id);

        Doctor newDoctor = new Doctor
                .Builder(doctor.getDoc_name())
                .copy(doctor)
                .address(doctor.getAddress())
                .build();

        doctorRepository.save(newDoctor);

        Doctor updatedDoctor = doctorRepository.findOne(doc_id);
        Assert.assertEquals(updatedDoctor.getAddress(), doctor.getAddress());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception
    {
        Doctor doctor = doctorRepository.findOne(doc_id);
        doctorRepository.delete(doctor);
        Doctor deletedDoctor = doctorRepository.findOne(doc_id);
        Assert.assertNull(deletedDoctor);

    }

}

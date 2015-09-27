package za.ac.cput.AshDyani.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.AshDyani.App;
import za.ac.cput.AshDyani.conf.factory.AddressFactory;
import za.ac.cput.AshDyani.conf.factory.DoctorFactory;
import za.ac.cput.AshDyani.domain.Address;
import za.ac.cput.AshDyani.domain.Doctor;
import za.ac.cput.AshDyani.repository.DoctorRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ashdyani on 2015/05/19.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class DoctorServiceTest extends AbstractTestNGSpringContextTests{

    @Autowired
    DoctorService doctorService;

    private Integer doc_id;
    @Autowired
    DoctorRepository doctorRepository;

    @Test
    public void create() throws Exception
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

    public void cleanUp() throws Exception
    {
        doctorRepository.deleteAll();
    }
}

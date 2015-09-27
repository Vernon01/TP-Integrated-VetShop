package za.ac.cput.AshDyani.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.AshDyani.App;
import za.ac.cput.AshDyani.conf.factory.ServiceFactory;
import za.ac.cput.AshDyani.domain.Booking;
import za.ac.cput.AshDyani.domain.Doctor;
import za.ac.cput.AshDyani.domain.Service;
import za.ac.cput.AshDyani.repository.ServiceRepository;

/**
 * Created by ashdyani on 2015/05/19.
 */

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class ServicesServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    ServicesService servicesService;

    private Integer service_id;
    private Doctor doctor;
    private Booking booking;

    @Autowired
    ServiceRepository serviceRepository;

    @Test
    public void create() throws Exception
    {
        Service service = ServiceFactory
                .createService(doctor, booking);
        serviceRepository.save(service);
        service_id = service.getService_id();
        Assert.assertNotNull(service.getService_id());
    }

    public void cleanUp() throws Exception
    {
        serviceRepository.deleteAll();
    }
}

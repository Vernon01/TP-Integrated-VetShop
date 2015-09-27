package za.ac.cput.AshDyani.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.AshDyani.App;
import za.ac.cput.AshDyani.conf.factory.ServiceFactory;
import za.ac.cput.AshDyani.domain.Booking;
import za.ac.cput.AshDyani.domain.Doctor;
import za.ac.cput.AshDyani.domain.Service;


/**
 * Created by ashdyani on 2015/05/07.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestServiceRepository extends AbstractTestNGSpringContextTests {

    private Integer service_id;
    private Doctor doctor;
    private Booking booking;

    @Autowired
    ServiceRepository serviceRepository;

    @Test
    public void testCreate() throws Exception
    {
        Service service = ServiceFactory
                .createService(doctor, booking);
        serviceRepository.save(service);
        service_id = service.getService_id();
        Assert.assertNotNull(service.getService_id());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception
    {
        Service service = serviceRepository.findOne(service_id);
        Assert.assertNotNull(service);
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception
    {
        Service service = serviceRepository.findOne(service_id);

        Service newService = new Service
                .Builder(service.getDoctor(), service.getBooking())
                .copy(service)
                .build();

        serviceRepository.save(newService);

        Service updatedService = serviceRepository.findOne(service_id);
        Assert.assertEquals(updatedService.getDoctor(), service.getDoctor());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception
    {
        Service service = serviceRepository.findOne(service_id);
        serviceRepository.delete(service);
        Service deletedService = serviceRepository.findOne(service_id);
        Assert.assertNull(deletedService);
    }


}

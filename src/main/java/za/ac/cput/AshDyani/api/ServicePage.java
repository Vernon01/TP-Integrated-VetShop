package za.ac.cput.AshDyani.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.AshDyani.domain.Service;
import za.ac.cput.AshDyani.model.ServiceResource;
import za.ac.cput.AshDyani.services.ServicesService;

/**
 * Created by ashdyani on 2015/08/15.
 */
@RestController
@RequestMapping("/service/**")
public class ServicePage {

    @Autowired
    ServicesService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String Index()
    {
        return "service details";
    }

    @RequestMapping(value = "/{service_id}", method = RequestMethod.GET)
    public ServiceResource getStudent(@PathVariable Integer service_id) {
        ServiceResource hateoas;
        Service service1 = service.getService(service_id);

        ServiceResource res = new ServiceResource
                .Builder(service1.getDoctor(), service1.getBooking())
                .build();

        Link serviceDetails = new
                Link("http://localhost:8080/api/service/" + res.getService_id().toString())
                .withRel("services");

        res.add(serviceDetails);
        hateoas = res;

        return hateoas;
    }
}

package za.ac.cput.AshDyani.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.AshDyani.domain.Booking;
import za.ac.cput.AshDyani.domain.Doctor;
import za.ac.cput.AshDyani.model.BookingResource;
import za.ac.cput.AshDyani.model.DoctorResource;
import za.ac.cput.AshDyani.services.BookingService;
import za.ac.cput.AshDyani.services.DoctorService;

/**
 * Created by ashdyani on 2015/08/15.
 */
@RestController
@RequestMapping("api/doctor/**")
public class DoctorPage {

    @Autowired
    private DoctorService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String Index()
    {
        return "doctor details";
    }

    @RequestMapping(value = "/{doc_id}", method = RequestMethod.GET)
    public DoctorResource getDoctor(@PathVariable Integer doc_id)
    {
        DoctorResource hateoas;
        Doctor doctor = service.getDoctor(doc_id);

        DoctorResource res = new DoctorResource
                .Builder(doctor.getDoc_name())
                .address(doctor.getAddress())
                .build();

        Link doctorDetails = new
                Link("http://localhost:8080/api/doctor/" + res.getDoc_id().toString())
                .withRel("doctors");

        res.add(doctorDetails);
        hateoas = res;

        return hateoas;
    }
}

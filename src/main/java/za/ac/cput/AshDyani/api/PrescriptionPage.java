package za.ac.cput.AshDyani.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.AshDyani.domain.Prescription;
import za.ac.cput.AshDyani.model.PrescriptionResource;
import za.ac.cput.AshDyani.services.PrescriptionService;

/**
 * Created by ashdyani on 2015/08/15.
 */
@RestController
@RequestMapping("/prescription/**")
public class PrescriptionPage {

    @Autowired
    PrescriptionService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String Index()
    {
        return "prescription details";
    }

    @RequestMapping(value = "/{prescrip_id}", method = RequestMethod.GET)
    public PrescriptionResource getStudent(@PathVariable Integer prescrip_id) {
        PrescriptionResource hateoas;
        Prescription prescription = service.getPrescription(prescrip_id);

        PrescriptionResource res = new PrescriptionResource
                .Builder(prescription.getDoctor(), prescription.getPet())
                .prescripDate(prescription.getPrescrip_date())
                .build();

        Link prescriptionDetails = new
                Link("http://localhost:8080/api/prescription/" + res.getPrescrip_id().toString())
                .withRel("prescriptions");

        res.add(prescriptionDetails);
        hateoas = res;

        return hateoas;
    }
}
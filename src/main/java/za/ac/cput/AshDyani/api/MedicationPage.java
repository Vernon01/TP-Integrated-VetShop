package za.ac.cput.AshDyani.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.AshDyani.domain.Invoice;
import za.ac.cput.AshDyani.domain.Medication;
import za.ac.cput.AshDyani.model.InvoiceResource;
import za.ac.cput.AshDyani.model.MedicationResource;
import za.ac.cput.AshDyani.services.InvoiceService;
import za.ac.cput.AshDyani.services.MedicationService;

/**
 * Created by ashdyani on 2015/08/15.
 */
@RestController
@RequestMapping("api/medication/**")
public class MedicationPage {

    @Autowired
    private MedicationService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String Index()
    {
        return "medication details";
    }

    @RequestMapping(value = "/{inv_id}", method = RequestMethod.GET)
    public MedicationResource getMedication(@PathVariable Integer med_id)
    {
        MedicationResource hateoas;
        Medication medication = service.getMedication(med_id);

        MedicationResource res = new MedicationResource
                .Builder(medication.getMed_name(), medication.getMed_type())
                .build();

        Link medicationDetails = new
                Link("http://localhost:8080/api/medication/" + res.getMed_id().toString())
                .withRel("medications");

        res.add(medicationDetails);
        hateoas = res;

        return hateoas;

    }
}

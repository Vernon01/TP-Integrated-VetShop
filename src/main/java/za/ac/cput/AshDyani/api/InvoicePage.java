package za.ac.cput.AshDyani.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.AshDyani.domain.Invoice;
import za.ac.cput.AshDyani.model.InvoiceResource;
import za.ac.cput.AshDyani.services.InvoiceService;

/**
 * Created by ashdyani on 2015/08/15.
 */
@RestController
@RequestMapping("api/invoice/**")
public class InvoicePage {

    @Autowired
    private InvoiceService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String Index()
    {
        return "invoice details";
    }

    @RequestMapping(value = "/{inv_id}", method = RequestMethod.GET)
    public InvoiceResource getInvoice(@PathVariable Integer inv_id)
    {
        InvoiceResource hateoas;
        Invoice invoice = service.getInvoice(inv_id);

        InvoiceResource res = new InvoiceResource
                .Builder(invoice.getService())
                .invoiceDate(invoice.getInv_date())
                .build();

        Link studentDetails = new
                Link("http://localhost:8080/api/invoice/" + res.getInv_id().toString())
                .withRel("invoices");

        res.add(studentDetails);
        hateoas = res;

        return hateoas;
    }
}

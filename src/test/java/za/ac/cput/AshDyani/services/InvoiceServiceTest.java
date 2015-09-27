package za.ac.cput.AshDyani.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.AshDyani.App;
import za.ac.cput.AshDyani.conf.factory.InvoiceFactory;
import za.ac.cput.AshDyani.domain.Booking;
import za.ac.cput.AshDyani.domain.Invoice;
import za.ac.cput.AshDyani.domain.Service;
import za.ac.cput.AshDyani.repository.InvoiceRepository;

import java.util.Date;

/**
 * Created by ashdyani on 2015/05/19.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class InvoiceServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    InvoiceService invoiceService;

    private Integer inv_id;
    private Service service;
    private Integer service_id;
    private Date inv_date = new Date(2015, 03, 01);

    @Autowired
    InvoiceRepository invoiceRepository;

    @Test
    public void testCreate() throws Exception
    {
        Invoice invoice = InvoiceFactory
                .createInvoice(service, inv_date);

        invoiceRepository.save(invoice);
        inv_id = invoice.getInv_id();
        Assert.assertNotNull(invoice.getInv_id());
    }

    public void cleanUp() throws Exception
    {
        invoiceRepository.deleteAll();
    }
}

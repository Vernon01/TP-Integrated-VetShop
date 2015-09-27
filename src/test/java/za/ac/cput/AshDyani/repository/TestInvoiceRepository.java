package za.ac.cput.AshDyani.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.AshDyani.App;
import za.ac.cput.AshDyani.conf.factory.InvoiceFactory;
import za.ac.cput.AshDyani.domain.Doctor;
import za.ac.cput.AshDyani.domain.Invoice;
import za.ac.cput.AshDyani.domain.Service;

import java.awt.print.Book;
import java.util.Date;

/**
 * Created by ashdyani on 2015/05/07.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestInvoiceRepository extends AbstractTestNGSpringContextTests{

    private Integer inv_id;
    private Service service;
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

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception
    {
        Invoice invoice = invoiceRepository.findOne(inv_id);
        Assert.assertNotNull(invoice);
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception
    {
        Invoice invoice = invoiceRepository.findOne(inv_id);

        Invoice newInvoice = new Invoice
                .Builder(invoice.getService())
                .copy(invoice)
                .invoiceDate(inv_date)
                .build();

        invoiceRepository.save(newInvoice);

        Invoice updatedInvoice = invoiceRepository.findOne(inv_id);
        Assert.assertEquals(updatedInvoice.getInv_date(), inv_date);
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception
    {
        Invoice invoice = invoiceRepository.findOne(inv_id);
        invoiceRepository.delete(invoice);
        Invoice deletedInvoice = invoiceRepository.findOne(inv_id);
        Assert.assertNull(deletedInvoice);

    }
}

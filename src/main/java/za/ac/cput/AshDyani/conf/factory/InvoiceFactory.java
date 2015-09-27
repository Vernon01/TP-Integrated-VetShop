package za.ac.cput.AshDyani.conf.factory;

import za.ac.cput.AshDyani.domain.Invoice;
import za.ac.cput.AshDyani.domain.Service;

import java.util.Date;

/**
 * Created by ashdyani on 2015/04/24.
 */
public class InvoiceFactory {

    public static Invoice createInvoice(Service service, Date inv_date)
    {
        Invoice invoice = new Invoice
                .Builder(service)
                .invoiceDate(inv_date)
                .build();

        return invoice;

    }

}

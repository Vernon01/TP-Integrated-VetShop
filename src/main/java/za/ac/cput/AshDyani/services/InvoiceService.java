package za.ac.cput.AshDyani.services;

import za.ac.cput.AshDyani.domain.Employee;
import za.ac.cput.AshDyani.domain.Invoice;
import za.ac.cput.AshDyani.domain.Service;

import java.util.List;

/**
 * Created by ashdyani on 2015/05/18.
 */
public interface InvoiceService {

    List<Invoice> getAllInvoices();

    Invoice getInvoice(Integer inv_id);

    Service getService(Integer service);
    //List<Service> getServices();
}

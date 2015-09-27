package za.ac.cput.AshDyani.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.AshDyani.domain.Invoice;
import za.ac.cput.AshDyani.repository.InvoiceRepository;
import za.ac.cput.AshDyani.services.InvoiceService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashdyani on 2015/05/18.
 */
@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> getAllInvoices()
    {
        List<Invoice> invoices = new ArrayList<>();
        Iterable<Invoice> values = invoiceRepository.findAll();

        for (Invoice value : values)
        {
            invoices.add(value);
        }

        return invoices;
    }

    @Override
    public Invoice getInvoice(Integer inv_id) {
        return invoiceRepository.findOne(inv_id);
    }

    @Override
    public za.ac.cput.AshDyani.domain.Service getService(Integer service) {
        return invoiceRepository.findOne(service).getService();
    }

}

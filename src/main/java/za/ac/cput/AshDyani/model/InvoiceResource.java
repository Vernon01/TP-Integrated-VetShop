package za.ac.cput.AshDyani.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.AshDyani.domain.Service;

import java.util.Date;

/**
 * Created by ashdyani on 2015/08/15.
 */
public class InvoiceResource extends ResourceSupport {

    private Integer inv_id;
    private Date inv_date;
    private Service service;

    private InvoiceResource()
    {
    }

    public InvoiceResource (Builder builder)
    {
        inv_id = builder.inv_id;
        inv_date = builder.inv_date;
        service = builder.service;
    }

    public Integer getInv_id() {
        return inv_id;
    }

    public Date getInv_date() {
        return inv_date;
    }

    public Service getService() {
        return service;
    }

    public static class Builder
    {
        private Integer inv_id;
        private Date inv_date;
        private Service service;

        public Builder (Service service)
        {
            this.service = service;
        }

        public Builder invId(Integer value)
        {
            this.inv_id = value;
            return this;
        }

        public Builder invoiceDate(Date value)
        {
            this.inv_date = value;
            return this;
        }

        public Builder copy(InvoiceResource invoice)
        {
            inv_id = invoice.inv_id;
            inv_date = invoice.inv_date;
            service = invoice.service;
            return this;
        }

        public InvoiceResource build()
        {
            return new InvoiceResource(this);
        }
    }
}

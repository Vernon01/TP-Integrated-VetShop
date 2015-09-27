package za.ac.cput.AshDyani.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ashdyani on 2015/04/19.
 */
@Entity
public class Invoice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer inv_id;
    private Date inv_date;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "inv_id")
    private Service service;

    private Invoice()
    {
    }

    public Invoice (Builder builder)
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

        public Builder copy(Invoice invoice)
        {
            inv_id = invoice.inv_id;
            inv_date = invoice.inv_date;
            service = invoice.service;
            return this;
        }

        public Invoice build()
        {
            return new Invoice(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invoice invoice = (Invoice) o;

        if (!inv_id.equals(invoice.inv_id)) return false;
        if (!inv_date.equals(invoice.inv_date)) return false;
        return service.equals(invoice.service);

    }

    @Override
    public int hashCode() {
        int result = inv_id.hashCode();
        result = 31 * result + inv_date.hashCode();
        result = 31 * result + service.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "inv_id=" + inv_id +
                ", inv_date=" + inv_date +
                ", service=" + service +
                '}';
    }
}

package za.ac.cput.AshDyani.domain;

import com.oracle.webservices.internal.api.databinding.DatabindingModeFeature;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ashdyani on 2015/04/19.
 */
@Entity
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer book_id;
    private Date book_date;
    private Customer customer;
    private Employee employee;

    private Booking()
    {}

    public Booking(Builder builder)
    {
        book_id = builder.book_id;
        book_date = builder.book_date;
        customer = builder.customer;
        employee = builder.employee;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public Date getBook_date() {
        return book_date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public static class Builder
    {
        private Integer book_id;
        private Date book_date;
        private Customer customer;
        private Employee employee;

        public Builder(Date book_date)
        {
            this.book_date = book_date;
        }

        public Builder bookId(int book_id)
        {
            this.book_id = book_id;
            return this;
        }

        public Builder customer (Customer value)
        {
            customer = value;
            return this;
        }

        public Builder employee(Employee value)
        {
            employee = value;
            return this;

        }

        public Builder copy(Booking book)
        {
            book_id = book.book_id;
            book_date = book.book_date;
            customer = book.customer;
            employee = book.employee;
            return this;
        }

        public Booking build()
        {
            return new Booking(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booking booking = (Booking) o;

        if (!book_id.equals(booking.book_id)) return false;
        if (!book_date.equals(booking.book_date)) return false;
        if (!customer.equals(booking.customer)) return false;
        return employee.equals(booking.employee);

    }

    @Override
    public int hashCode() {
        int result = book_id.hashCode();
        result = 31 * result + book_date.hashCode();
        result = 31 * result + customer.hashCode();
        result = 31 * result + employee.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "book_id=" + book_id +
                ", book_date=" + book_date +
                ", customer=" + customer +
                ", employee=" + employee +
                '}';
    }
}

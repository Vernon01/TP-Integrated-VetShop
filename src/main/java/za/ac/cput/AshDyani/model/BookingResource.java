package za.ac.cput.AshDyani.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.AshDyani.domain.Customer;
import za.ac.cput.AshDyani.domain.Employee;

import java.util.Date;

/**
 * Created by ashdyani on 2015/08/15.
 */
public class BookingResource extends ResourceSupport {


    private Integer book_id;
    private Date book_date;
    private Customer customer;
    private Employee employee;

    private BookingResource()
    {}

    public BookingResource(Builder builder)
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

        public Builder copy(BookingResource book)
        {
            book_id = book.book_id;
            book_date = book.book_date;
            customer = book.customer;
            employee = book.employee;
            return this;
        }

        public BookingResource build()
        {
            return new BookingResource(this);
        }

    }
}

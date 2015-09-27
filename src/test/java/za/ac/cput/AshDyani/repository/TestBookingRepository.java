package za.ac.cput.AshDyani.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.AshDyani.App;
import za.ac.cput.AshDyani.conf.factory.BookingFactory;
import za.ac.cput.AshDyani.domain.Booking;
import za.ac.cput.AshDyani.domain.Customer;
import za.ac.cput.AshDyani.domain.Employee;

import java.util.Date;

/**
 * Created by ashdyani on 2015/05/09.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestBookingRepository extends AbstractTestNGSpringContextTests {

    private Integer book_id;
    private Date book_date = new Date(2015, 03, 01);
    private Customer customer;
    private Employee employee;

    @Autowired
    BookingRepository bookingRepository;

    @Test
    public void testCreate() throws Exception
    {
        Booking booking = BookingFactory
                .createBooking(book_date, customer, employee);

        bookingRepository.save(booking);
        book_id = booking.getBook_id();
        Assert.assertNotNull(booking.getBook_id());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception
    {
        Booking booking = bookingRepository.findOne(book_id);
        Assert.assertNotNull(booking);
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception
    {
        Booking booking = bookingRepository.findOne(book_id);

        Booking newBooking = new Booking
                .Builder(booking.getBook_date())
                .copy(booking)
                .customer(customer)
                .employee(employee)
                .build();

        bookingRepository.save(newBooking);

        Booking updatedBooking = bookingRepository.findOne(book_id);
        Assert.assertEquals(updatedBooking.getBook_date(), book_date);
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception
    {
        Booking booking = bookingRepository.findOne(book_id);
        bookingRepository.delete(booking);
        Booking deletedBooking = bookingRepository.findOne(book_id);
        Assert.assertNull(deletedBooking);
    }
}

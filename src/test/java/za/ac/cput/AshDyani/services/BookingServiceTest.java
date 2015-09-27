package za.ac.cput.AshDyani.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.AshDyani.App;
import za.ac.cput.AshDyani.conf.factory.BookingFactory;
import za.ac.cput.AshDyani.domain.Booking;
import za.ac.cput.AshDyani.domain.Customer;
import za.ac.cput.AshDyani.domain.Employee;
import za.ac.cput.AshDyani.repository.BookingRepository;

import java.util.Date;

/**
 * Created by ashdyani on 2015/05/19.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class BookingServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    BookingService bookingService;

    private Integer book_id;
    private Date book_date = new Date(2015, 03, 01);
    private Customer customer;
    private Employee employee;

    @Autowired
    BookingRepository bookingRepository;

    @Test
    public void create() throws Exception
    {
        Booking booking = BookingFactory
                .createBooking(book_date, customer, employee);

        bookingRepository.save(booking);
        book_id = booking.getBook_id();
        Assert.assertNotNull(booking.getBook_id());
    }

    public void cleanUp() throws Exception
    {
        bookingRepository.deleteAll();
    }


}

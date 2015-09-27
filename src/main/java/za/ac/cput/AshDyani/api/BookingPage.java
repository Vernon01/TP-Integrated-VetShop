package za.ac.cput.AshDyani.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.AshDyani.domain.Booking;
import za.ac.cput.AshDyani.model.BookingResource;
import za.ac.cput.AshDyani.services.BookingService;

import java.util.List;

/**
 * Created by ashdyani on 2015/08/15.
 */
@RestController
@RequestMapping(value="/booking/**")
public class BookingPage {


    @Autowired
    private BookingService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String Index()
    {
        return "booking details";
    }

    @RequestMapping(value = "/{book_id}", method = RequestMethod.GET)
    public BookingResource getBooking(@PathVariable Integer book_id)
    {
        BookingResource hateoas;
        Booking booking = service.getBooking(book_id);

        BookingResource res = new BookingResource
                .Builder(booking.getBook_date())
                .customer(booking.getCustomer())
                .employee(booking.getEmployee())
                .build();

        Link bookingDetails = new
                Link("http://localhost:8080/api/booking/" + res.getBook_id().toString())
                .withRel("bookings");

        res.add(bookingDetails);
        hateoas = res;

        return hateoas;
    }

}
package za.ac.cput.AshDyani.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.AshDyani.domain.Booking;
import za.ac.cput.AshDyani.repository.BookingRepository;
import za.ac.cput.AshDyani.services.BookingService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashdyani on 2015/05/18.
 */
@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public List<Booking> getAllBookings()
    {
        List<Booking> bookings = new ArrayList<>();
        Iterable<Booking> values = bookingRepository.findAll();
        for(Booking value: values)
        {
            bookings.add(value);
        }

        return bookings;
    }

    @Override
    public Booking getBooking(Integer book_id)
    {
        return bookingRepository.findOne(book_id);
    }

}

package za.ac.cput.AshDyani.conf.factory;


import za.ac.cput.AshDyani.domain.Booking;
import za.ac.cput.AshDyani.domain.Customer;
import za.ac.cput.AshDyani.domain.Employee;

import java.util.Date;
import java.util.Map;

/**
 * Created by ashdyani on 2015/04/24.
 */
public class BookingFactory {

    public static Booking createBooking(Date book_date, Customer customer, Employee employee)
    {
        Booking booking = new Booking
                .Builder(book_date)
                .customer(customer)
                .employee(employee)
                .build();
        
        return booking;
    }

}


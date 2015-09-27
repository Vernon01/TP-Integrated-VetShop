package za.ac.cput.AshDyani.services;

import za.ac.cput.AshDyani.domain.Booking;
import za.ac.cput.AshDyani.domain.Customer;
import za.ac.cput.AshDyani.domain.Employee;

import java.util.List;

/**
 * Created by ashdyani on 2015/05/18.
 */
public interface BookingService {

    List<Booking> getAllBookings();

    Booking getBooking(Integer book_id);
  //  List<Customer> getAllCustomer();
  //  List<Employee> getAllEmployee();


}

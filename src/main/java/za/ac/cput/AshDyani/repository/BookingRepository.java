package za.ac.cput.AshDyani.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.AshDyani.domain.Booking;

/**
 * Created by ashdyani on 2015/04/30.
 */
public interface BookingRepository extends CrudRepository<Booking, Integer>{
}

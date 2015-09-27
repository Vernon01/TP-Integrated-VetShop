package za.ac.cput.AshDyani.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.AshDyani.domain.Prescription;
import za.ac.cput.AshDyani.domain.Prescription_Line;

/**
 * Created by ashdyani on 2015/04/30.
 */
public interface Prescription_LineRepository extends CrudRepository<Prescription_Line, Integer> {
}

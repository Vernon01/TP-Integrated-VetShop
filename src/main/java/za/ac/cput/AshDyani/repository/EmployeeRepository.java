package za.ac.cput.AshDyani.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.AshDyani.domain.Employee;

/**
 * Created by ashdyani on 2015/04/30.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}

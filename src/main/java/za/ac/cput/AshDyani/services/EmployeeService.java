package za.ac.cput.AshDyani.services;

import za.ac.cput.AshDyani.domain.Doctor;
import za.ac.cput.AshDyani.domain.Employee;

import java.util.List;

/**
 * Created by ashdyani on 2015/05/18.
 */
public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployee(Integer emp_id);
}

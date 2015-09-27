package za.ac.cput.AshDyani.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.AshDyani.domain.Doctor;
import za.ac.cput.AshDyani.domain.Employee;
import za.ac.cput.AshDyani.repository.EmployeeRepository;
import za.ac.cput.AshDyani.services.EmployeeService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashdyani on 2015/05/18.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees()
    {
        List<Employee> employees = new ArrayList<>();
        Iterable<Employee> values = employeeRepository.findAll();
        for (Employee value : values)
        {
            employees.add(value);
        }

        return employees;
    }

    @Override
    public Employee getEmployee(Integer emp_id) {
        return employeeRepository.findOne(emp_id);
    }

}

package za.ac.cput.AshDyani.conf.factory;

import za.ac.cput.AshDyani.domain.Address;
import za.ac.cput.AshDyani.domain.Employee;

/**
 * Created by ashdyani on 2015/04/24.
 */
public class EmployeeFactory {

    public static Employee createEmployee(String emp_type, String emp_name, Address address)
    {
        Employee employee = new Employee
                .Builder(emp_type, emp_name)
                .address(address)
                .build();

        return employee;
    }
}

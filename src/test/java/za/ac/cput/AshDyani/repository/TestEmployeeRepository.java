package za.ac.cput.AshDyani.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.AshDyani.App;
import org.testng.annotations.Test;
import org.testng.Assert;
import za.ac.cput.AshDyani.conf.factory.AddressFactory;
import za.ac.cput.AshDyani.conf.factory.DoctorFactory;
import za.ac.cput.AshDyani.conf.factory.EmployeeFactory;
import za.ac.cput.AshDyani.domain.Address;
import za.ac.cput.AshDyani.domain.Doctor;
import za.ac.cput.AshDyani.domain.Employee;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ashdyani on 2015/05/13.
 */

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestEmployeeRepository extends AbstractTestNGSpringContextTests {

    private Integer emp_id;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testCreate() throws Exception
    {
        Map<String,String> values = new HashMap<String,String>();
        values.put("street","Sandbaai");
        values.put("town", "Hermanus");

        Address empAddress = AddressFactory.createAddress(values, "7200");

        Employee employee = EmployeeFactory.createEmployee("Nurse", "Bettina", empAddress);

        employeeRepository.save(employee);
        emp_id = employee.getEmp_id();
        Assert.assertNotNull(employee.getEmp_id());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception
    {
        Employee employee = employeeRepository.findOne(emp_id);
        Assert.assertNotNull(employee);
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception
    {
        Employee employee = employeeRepository.findOne(emp_id);

        Employee newEmployee = new Employee
                .Builder(employee.getEmp_name(), employee.getEmp_type())
                .copy(employee)
                .address(employee.getAddress())
                .build();

        employeeRepository.save(newEmployee);

        Employee updatedEmployee = employeeRepository.findOne(emp_id);
        Assert.assertEquals(updatedEmployee.getAddress(), employee.getAddress());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception
    {
        Employee employee = employeeRepository.findOne(emp_id);
        employeeRepository.delete(employee);
        Employee deletedEmployee = employeeRepository.findOne(emp_id);
        Assert.assertNull(deletedEmployee);

    }
}

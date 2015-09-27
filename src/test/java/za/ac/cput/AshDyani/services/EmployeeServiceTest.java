package za.ac.cput.AshDyani.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.AshDyani.App;
import za.ac.cput.AshDyani.conf.factory.AddressFactory;
import za.ac.cput.AshDyani.conf.factory.EmployeeFactory;
import za.ac.cput.AshDyani.domain.Address;
import za.ac.cput.AshDyani.domain.Employee;
import za.ac.cput.AshDyani.repository.EmployeeRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ashdyani on 2015/05/19.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class EmployeeServiceTest extends AbstractTestNGSpringContextTests{

    @Autowired
    EmployeeService employeeService;

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

    public void cleanUp() throws Exception
    {
        employeeRepository.deleteAll();
    }
}

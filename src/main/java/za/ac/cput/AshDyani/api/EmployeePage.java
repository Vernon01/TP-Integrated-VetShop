package za.ac.cput.AshDyani.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.AshDyani.domain.Employee;
import za.ac.cput.AshDyani.model.EmployeeResource;
import za.ac.cput.AshDyani.services.EmployeeService;

/**
 * Created by ashdyani on 2015/08/15.
 */
@RestController
@RequestMapping("api/employee/**")
public class EmployeePage {

    @Autowired
    private EmployeeService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String Index()
    {
        return "employee details";
    }

    @RequestMapping(value = "/{emp_id}", method = RequestMethod.GET)
    public EmployeeResource getDoctor(@PathVariable Integer emp_id)
    {
        EmployeeResource hateoas;
        Employee employee = service.getEmployee(emp_id);

        EmployeeResource res = new EmployeeResource
                .Builder(employee.getEmp_type(), employee.getEmp_name())
                .address(employee.getAddress())
                .build();

        Link EmployeeDetails = new
                Link("http://localhost:8080/api/employee/" + res.getEmp_id().toString())
                .withRel("employees");

        res.add(EmployeeDetails);
        hateoas = res;

        return hateoas;

    }
}

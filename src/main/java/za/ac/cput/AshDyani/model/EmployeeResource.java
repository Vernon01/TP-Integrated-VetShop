package za.ac.cput.AshDyani.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.AshDyani.domain.Address;

import javax.persistence.Embedded;

/**
 * Created by ashdyani on 2015/08/15.
 */
public class EmployeeResource extends ResourceSupport {

    private Integer emp_id;
    private String emp_type;
    private String emp_name;
    @Embedded
    private Address address;

    private EmployeeResource()
    {}

    public EmployeeResource(Builder builder)
    {
        emp_id = builder.emp_id;
        emp_type = builder.emp_type;
        emp_name = builder.emp_name;
        address = builder.address;
    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public String getEmp_type() {
        return emp_type;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public Address getAddress() {
        return address;
    }

    public static class Builder
    {
        private Integer emp_id;
        private String emp_type;
        private String emp_name;
        private Address address;

        public Builder (String emp_type, String emp_name)
        {
            this.emp_type = emp_type;
            this.emp_name = emp_name;
        }

        public Builder empId(int emp_id)
        {
            this.emp_id = emp_id;
            return this;
        }

        public Builder address(Address value)
        {
            address = value;
            return this;
        }

        public Builder copy(EmployeeResource employee)
        {
            emp_id = employee.emp_id;
            emp_type = employee.emp_type;
            emp_name = employee.emp_name;
            address = employee.address;
            return this;
        }

        public EmployeeResource build()
        {
            return new EmployeeResource(this);
        }

    }
}

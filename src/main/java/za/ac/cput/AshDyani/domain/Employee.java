package za.ac.cput.AshDyani.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ashdyani on 2015/04/19.
 */
@Entity
public class Employee implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer emp_id;
    private String emp_type;
    private String emp_name;
    @Embedded
    private Address address;

    private Employee()
    {}

    public Employee(Builder builder)
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

        public Builder copy(Employee employee)
        {
            emp_id = employee.emp_id;
            emp_type = employee.emp_type;
            emp_name = employee.emp_name;
            address = employee.address;
            return this;
        }

        public Employee build()
        {
            return new Employee(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!emp_id.equals(employee.emp_id)) return false;
        if (!emp_type.equals(employee.emp_type)) return false;
        if (!emp_name.equals(employee.emp_name)) return false;
        return address.equals(employee.address);

    }

    @Override
    public int hashCode() {
        int result = emp_id.hashCode();
        result = 31 * result + emp_type.hashCode();
        result = 31 * result + emp_name.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", emp_type='" + emp_type + '\'' +
                ", emp_name='" + emp_name + '\'' +
                ", address=" + address +
                '}';
    }
}

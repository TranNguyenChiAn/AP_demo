package demo.employees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    @Test
    @DisplayName("Test case empFullName = Tayloe Smith")
    void getEmpFullName() {
        Employee employee = new Employee(1, "Tayloe Smith", "test", "test", 1000, "test", "test", "test");
        assertEquals("Tayloe Smith", employee.getEmpFullName());
    }

    @Test
    @DisplayName("Test case empSalary = 2000 or empSalary <= 0")
    void setEmpSalary() {
        Employee employee = new Employee(1, "Tayloe Smith", "test", "test", 1000, "test", "test", "test");
        assertEquals(1000, employee.getEmpSalary());

        employee.setEmpSalary(2000);
        assertEquals(2000, employee.getEmpSalary());

        Exception exception = Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                employee.setEmpSalary(-1);
            }
        });
        Assertions.assertEquals("Salary must be more than 0", exception.getMessage());
    }
}
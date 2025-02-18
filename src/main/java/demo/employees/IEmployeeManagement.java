package demo.employees;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeManagement {
    public List<Employee> getEmployees() throws SQLException;
    public Employee searchEmployeeByID(int empID) throws SQLException;
    public Employee updateEmployee(int empID, Employee newEmp, Employee oldEmp) throws SQLException;
    public void deleteEmployee(int empID) throws SQLException;
    public void printSortEmployeesBySalary() throws SQLException;
    public List<Employee> getTop10Salary() throws SQLException;

}

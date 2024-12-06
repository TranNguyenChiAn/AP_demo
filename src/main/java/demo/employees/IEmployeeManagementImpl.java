package demo.employees;

import demo.db_config.Database;
import demo.db_config.DatabaseFactory;
import demo.db_config.DatabaseType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IEmployeeManagementImpl implements IEmployeeManagement {
    private List<Employee> employeeList;
    private Database db;
    private Connection conn;

    public IEmployeeManagementImpl(DatabaseType type) throws SQLException {
        this.db = DatabaseFactory.getInstance(type);
        this.employeeList = new ArrayList<>();
        this.conn = db.connect();
    }

    @Override
    public List<Employee> getEmployees() throws SQLException{
        String sql = "SELECT * FROM employees";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        employeeList.clear();
        while(rs.next()){
            Employee e = new Employee();
            e.setEmpID(rs.getInt("empID"));
            e.setEmpFullName(rs.getString("empFullName"));
            e.setEmpDOB(rs.getString("empDOB"));
            e.setEmpEmail(rs.getString("empEmail"));
            e.setEmpSalary(rs.getFloat("empSalary"));
            e.setEmpGender(rs.getString("empGender"));
            e.setEmpStartDate(rs.getString("empStartDate"));
            e.setEmpEndDate(rs.getString("empEndDate"));
            employeeList.add(e);
        }
        return employeeList;
    }

    @Override
    public Employee searchEmployeeByID(int empID) throws SQLException {
        String sql = "SELECT * FROM employees WHERE empID = " + empID;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Employee e = new Employee();
        if(rs.next()){
            e.setEmpID(rs.getInt("empID"));
            e.setEmpFullName(rs.getString("empFullName"));
            e.setEmpDOB(rs.getString("empDOB"));
            e.setEmpEmail(rs.getString("empEmail"));
            e.setEmpSalary(rs.getFloat("empSalary"));
            e.setEmpGender(rs.getString("empGender"));
            e.setEmpStartDate(rs.getString("empStartDate"));
            e.setEmpEndDate(rs.getString("empEndDate"));
            System.out.println(e);
        }else {
            System.out.println("Can not find Employee with ID: " + empID);
        }
        return e;
    }

    @Override
    public Employee updateEmployee(int empID, Employee newEmp, Employee oldEmp) throws SQLException {
        Employee oldEmployee = searchEmployeeByID(empID);
        String sqlUpdateEmployee = "UPDATE employees SET empFullName = ?, empDOB = ?, empEmail = ?, empSalary = ?," +
                "empGender = ?, empStartDate = ?, empEndDate = ? WHERE empId = ?";
        try {
            PreparedStatement updateStatement = conn.prepareStatement(sqlUpdateEmployee);
            updateStatement.setString(1, newEmp.getEmpFullName() != null ? newEmp.getEmpFullName(): oldEmployee.getEmpFullName());
            updateStatement.setString(2, newEmp.getEmpDOB() != null ? newEmp.getEmpDOB() : oldEmployee.getEmpDOB());
            updateStatement.setString(3, newEmp.getEmpEmail() != null ? newEmp.getEmpEmail() : oldEmployee.getEmpEmail());
            updateStatement.setDouble(4, newEmp.getEmpSalary() != 0 ? newEmp.getEmpSalary() : oldEmployee.getEmpSalary());
            updateStatement.setString(5, newEmp.getEmpGender() != null ? newEmp.getEmpGender() : oldEmployee.getEmpGender());
            updateStatement.setString(6, newEmp.getEmpStartDate() != null ? newEmp.getEmpStartDate() : oldEmployee.getEmpStartDate());
            updateStatement.setString(7, newEmp.getEmpEndDate() != null ? newEmp.getEmpEndDate() : oldEmployee.getEmpEndDate());
            updateStatement.setInt(8, empID);

            int rowsUpdated = updateStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Employee updated successfully");
            } else {
                System.out.println("No employee found with ID " + empID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Employee newEmployee = searchEmployeeByID(empID);
        return newEmployee;
    }

    @Override
    public void deleteEmployee(int empID) throws SQLException {
        String deleteStmt = "DELETE FROM employees WHERE empID = " + empID;
        PreparedStatement stmt = conn.prepareStatement(deleteStmt);
        String rs = String.valueOf(stmt.executeUpdate(deleteStmt));
        if(rs.equals("1")){
            System.out.println("Delete employee with empID: " + empID + " successfully");
        }else {
            System.out.println("Employee with empID: " + empID + " not found");
        }
    }

    @Override
    public void printSortEmployeesBySalary() throws SQLException {
        String sql = "SELECT * FROM employees order by empSalary DESC";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        employeeList.clear();
        while(rs.next()){
            Employee e = new Employee();
            e.setEmpID(rs.getInt("empID"));
            e.setEmpFullName(rs.getString("empFullName"));
            e.setEmpDOB(rs.getString("empDOB"));
            e.setEmpEmail(rs.getString("empEmail"));
            e.setEmpSalary(rs.getFloat("empSalary"));
            e.setEmpGender(rs.getString("empGender"));
            e.setEmpStartDate(rs.getString("empStartDate"));
            e.setEmpEndDate(rs.getString("empEndDate"));
            employeeList.add(e);
        }
        System.out.println(employeeList);
    }

    @Override
    public List<Employee> getTop10Salary() throws SQLException {
        String sql = "SELECT * FROM employees order by empSalary DESC LIMIT 10";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        employeeList.clear();
        while(rs.next()){
            Employee e = new Employee();
            e.setEmpID(rs.getInt("empID"));
            e.setEmpFullName(rs.getString("empFullName"));
            e.setEmpDOB(rs.getString("empDOB"));
            e.setEmpEmail(rs.getString("empEmail"));
            e.setEmpSalary(rs.getFloat("empSalary"));
            e.setEmpGender(rs.getString("empGender"));
            e.setEmpStartDate(rs.getString("empStartDate"));
            e.setEmpEndDate(rs.getString("empEndDate"));
            employeeList.add(e);
        }
        return employeeList;
    }
}

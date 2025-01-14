package demo;

import demo.db_config.DatabaseType;
import demo.employees.Employee;
import demo.employees.IEmployeeManagement;
import demo.employees.IEmployeeManagementImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws SQLException {
        IEmployeeManagement management = new IEmployeeManagementImpl(DatabaseType.MySQL);
        Scanner input = new Scanner(System.in);
        int n;
        do{
            System.out.println("1. Show all employee");
            System.out.println("2. Update employee");
            System.out.println("3. Delete employee");
            System.out.println("4. Search employee by ID");
            System.out.println("5. Get top 10 by salary");
            System.out.println("6. Sort decrease by salary");
            System.out.println("0. Exit");
            System.out.print("Choose a menu: ");

            n = input.nextInt();
            switch(n) {
                case 1:
                    List<Employee> employeeList = management.getEmployees();
                    System.out.println(employeeList);
                    break;
                case 2:
                    System.out.print("Enter employee's ID: ");
                    int empID = input.nextInt();
                    Employee oldEmp= management.searchEmployeeByID(empID);

                    System.out.print("Enter employee full name (or 'null' to leave blank): ");
                    String empFullName = input.nextLine().trim();
                    if (empFullName.equalsIgnoreCase("null")) {
                        empFullName = null;
                    }

                    System.out.print("Enter employee DOB (or 'null' to leave blank): ");
                    String empDOB = input.nextLine().trim();
                    if (empDOB.isEmpty()) {
                        empDOB = null;
                    }

                    System.out.print("Enter employee email (or 'null' to leave blank): ");
                    String empEmail = input.nextLine().trim();

                    System.out.print("Enter employee salary (or 0 to leave blank): ");
                    double empSalary = input.nextDouble();
                    if (empSalary == 0) {
                        empSalary = 0;
                    }
                    input.nextLine();

                    System.out.print("Enter employee gender (or 'null' to leave blank): ");
                    String empGender = input.nextLine().trim();
                    if (empGender.isEmpty()) {
                        empGender = null;
                    }

                    System.out.print("Enter employee start date (or 'null' to leave blank): ");
                    String empStartDate = input.nextLine().trim();
                    if (empStartDate.isEmpty()) {
                        empStartDate = null;
                    }

                    System.out.print("Enter employee end date (or 'null' to leave blank): ");
                    String empEndDate = input.nextLine().trim();
                    if (empEndDate.isEmpty()) {
                        empEndDate = null;
                    }
                    Employee newEmp = new Employee(empFullName, empDOB, empEmail, empSalary, empGender, empStartDate, empEndDate);
                    management.updateEmployee(empID, newEmp, oldEmp);
                    break;
                case 3:
                    System.out.print("Enter employee's ID: ");
                    empID = input.nextInt();
                    management.deleteEmployee(empID);
                    break;
                case 4:
                    System.out.print("Enter employee's ID: ");
                    empID = input.nextInt();
                    management.searchEmployeeByID(empID);
                    break;
                case 5:
                    management.getTop10Salary();
                case 6:
                    management.printSortEmployeesBySalary();
                    break;
                case 0:
                    break;
                default:
                    System.out.print("Menu not yet developed, choose again: ");
                    n = input.nextInt();
                    break;
            }
        }while(n != 0);
    }
}

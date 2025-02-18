package demo.employees;

import demo.db_config.DatabaseType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

class IEmployeeManagementImplTest {
    @Test
    @DisplayName("Test case delete employee")
    void deleteEmployee() throws SQLException {
        IEmployeeManagementImpl employeeManagement = new IEmployeeManagementImpl(DatabaseType.MySQL);
        try {
            employeeManagement.deleteEmployee(20);
            assertEquals(0, employeeManagement.searchEmployeeByID(20).getEmpID(),
                    "The employee with ID = 20 should be deleted");
        } catch (SQLException e) {
            fail("SQLException was thrown: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Test case search by ID = 7")
    void searchById() throws SQLException {
        IEmployeeManagementImpl employeeManagement = new IEmployeeManagementImpl(DatabaseType.MySQL);
        try {
            Employee employee = employeeManagement.searchEmployeeByID(7);
            assertNotNull(employee, "The returned employee should not be null");
            assertEquals(7, employee.getEmpID(), "The returned employee should have ID = 7");
        } catch (SQLException e) {
            fail("SQLException was thrown: " + e.getMessage());
        }
    }
}
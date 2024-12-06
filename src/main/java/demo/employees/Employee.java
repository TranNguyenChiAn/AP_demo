package demo.employees;

public class Employee {
    private int empID;
    private String empFullName;
    private String empDOB;
    private String empEmail;
    private double empSalary;
    private String empGender;
    private String empStartDate;
    private String empEndDate;

    public Employee() {
    }

    public Employee(int empID, String empFullName, String empDOB, String empEmail, double empSalary, String empGender, String empStartDate, String empEndDate) {
        this.empID = empID;
        this.empFullName = empFullName;
        this.empDOB = empDOB;
        this.empEmail = empEmail;
        this.empSalary = empSalary;
        this.empGender = empGender;
        this.empStartDate = empStartDate;
        this.empEndDate = empEndDate;
    }

    public Employee(String empFullName, String empDOB, String empEmail, double empSalary, String empGender, String empStartDate, String empEndDate) {
        this.empFullName = empFullName;
        this.empDOB = empDOB;
        this.empEmail = empEmail;
        this.empSalary = empSalary;
        this.empGender = empGender;
        this.empStartDate = empStartDate;
        this.empEndDate = empEndDate;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpFullName() {
        return empFullName;
    }

    public void setEmpFullName(String empFullName) {
        this.empFullName = empFullName;
    }

    public String getEmpDOB() {
        return empDOB;
    }

    public void setEmpDOB(String empDOB) {
        this.empDOB = empDOB;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        if (empSalary <= 0) throw new RuntimeException("Salary must be more than 0");
        this.empSalary = empSalary;
    }

    public String getEmpGender() {
        return empGender;
    }

    public void setEmpGender(String empGender) {
        this.empGender = empGender;
    }

    public String getEmpStartDate() {
        return empStartDate;
    }

    public void setEmpStartDate(String empStartDate) {
        this.empStartDate = empStartDate;
    }

    public String getEmpEndDate() {
        return empEndDate;
    }

    public void setEmpEndDate(String empEndDate) {
        this.empEndDate = empEndDate;
    }

    @Override
    public String toString() {
        return "Employee " + empID +
                ", empFullName=" + empFullName +
                ", empDOB=" + empDOB +
                ", empEmail=" + empEmail +
                ", empSalary=" + empSalary +
                ", empGender=" + empGender +
                ", empStartDate=" + empStartDate +
                ", empEndDate=" + empEndDate + '\n';
    }


}

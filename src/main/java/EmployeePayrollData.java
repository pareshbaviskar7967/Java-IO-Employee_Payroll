public class EmployeePayrollData {
    private int emp_id;
    private double emp_salary;
    private String emp_name;

    public EmployeePayrollData(int emp_id, double emp_salary, String emp_name) {
        this.emp_id = emp_id;
        this.emp_salary = emp_salary;
        this.emp_name = emp_name;
    }

    @Override
    public String toString() {
        return "Employee ID: " + emp_id + ", name: " + emp_name + ", salary: " + emp_salary;
    }
}
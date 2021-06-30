import java.util.*;

public class EmployeePayrollService {
    private List<EmployeePayrollData> data;

    public EmployeePayrollService() {
    }

    public EmployeePayrollService(List<EmployeePayrollData> data) {
        this.data = data;
    }

    private void writeData() {
        System.out.println("\nWrinting employee payroll data to console: \n" + data);
    }

    private void readData(Scanner scanner) {
        System.out.println("Enter employee ID: ");
        int emp_id = scanner.nextInt();

        System.out.println("Enter employee name: ");
        String emp_name = scanner.next();

        System.out.println("Enter employee salary: ");
        double emp_salary = scanner.nextDouble();

        this.data.add(new EmployeePayrollData(emp_id, emp_salary, emp_name));
    }

    public static void main(String[] args) {
        List<EmployeePayrollData> data = new ArrayList<EmployeePayrollData>();
        EmployeePayrollService service = new EmployeePayrollService(data);
        service.readData(new Scanner(System.in));
        service.writeData();
    }
}
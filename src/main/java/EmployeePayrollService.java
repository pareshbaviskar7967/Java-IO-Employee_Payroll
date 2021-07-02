import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class EmployeePayrollService {
    private List<EmployeePayrollData> data;

    public EmployeePayrollService() {
    }

    public EmployeePayrollService(List<EmployeePayrollData> data) {
        this.data = data;
    }

    private void writeData(ServiceTypeEnum service) throws IOException {
        if (service.equals(ServiceTypeEnum.FILE)) {
            System.out.println("\nWrinting employee payroll data to a file.");
            writeDataToFile();
            System.out.println("Data successfully got written to a file.");
        } else if (service.equals(ServiceTypeEnum.CONSOLE)) {
            System.out.println("\nWrinting employee payroll data to console: \n" + data);
        }
    }

    private void writeDataToFile() throws IOException {
        StringBuffer buffer = new StringBuffer();
        data.forEach(employee -> {
            String employeeData = employee.toString().concat("\n");
            buffer.append(employeeData);
        });
        Files.write(Paths.get("C:\\Users\\iamat\\eclipse-workspace\\Employee-Payroll\\lib\\files\\EmployeeData.txt"), buffer.toString().getBytes());
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

    public void printData() {
        try {
            Files.lines(new File("C:\\Users\\iamat\\eclipse-workspace\\Employee-Payroll\\lib\\files\\EmployeeData.txt").toPath())
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        List<EmployeePayrollData> data = new ArrayList<EmployeePayrollData>();
        EmployeePayrollService service = new EmployeePayrollService(data);
        service.readData(new Scanner(System.in));
        service.writeData(ServiceTypeEnum.CONSOLE);
        service.writeData(ServiceTypeEnum.FILE);
        System.out.println();
        service.printData();
    }
}
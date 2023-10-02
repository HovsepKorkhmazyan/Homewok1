package Employee;

import Employee.EmployeeStorage;

import java.util.Scanner;

public class EmployeeDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        EmployeeStorage es = new EmployeeStorage();
        while (isRunning) {
            System.out.println("Type 0 for Exit");
            System.out.println("Type 1 for adding an Employee");
            System.out.println("Type 2 for printing out the names of every Employee of the company");
            System.out.println("Type 3 for searching an Employee by EmployeeID");
            System.out.println("Type 4 for searching an Employee by company name");
            int sc = Integer.parseInt(scanner.nextLine());
            switch (sc) {
                case 0:
                    isRunning = false;
                    break;
                case 1:
                    Employee employee = new Employee();
                    String employeeName = scanner.nextLine();
                    employee.setName(employeeName);
                    es.addEmployee(String.valueOf(employee));
                    break;
                case 2:
                    es.print();
                    break;
                case 3:
                    String eID = scanner.nextLine();
                    String resultById = es.searchByEmployeeID(eID);
                    System.out.println(resultById);
                    break;
                case 4:
                    String searchCoName = scanner.nextLine();
                    String resultByCoName = es.searchByCompanyName(searchCoName);
                    System.out.println(resultByCoName);
                    break;
            }
        }
    }
}

package Employee;

import Employee.EmployeeStorage;

import java.util.Scanner;

public class EmployeeDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        EmployeeStorage es = new EmployeeStorage();
        while (isRunning) {
            displayOptions();
            int sc = Integer.parseInt(scanner.nextLine());
            switch (sc) {
                case 0:
                    isRunning = false;
                    break;
                case 1:
                    System.out.println("Please Enter the Name");
                    String name = scanner.nextLine();
                    Employee employee = new Employee(name);
                    es.addEmployee(employee);

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

    private static void displayOptions() {
        System.out.println("Input 0 to EXIT");
        System.out.println("Input 1 to ADD an Employee");
        System.out.println("Input 2 to PRINT OUT the names of every Employee of the company");
        System.out.println("Input 3 to SEARCH BY EMPLOYEEID");
        System.out.println("Input 4 to SEARCH an Employee by company name");
    }
}


package Employee;

import java.util.Scanner;

public class EmployeeDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Type 0 for Exit");
            System.out.println("Type 1 for adding an Employee");
            System.out.println("Type 2 for printing out the names of every Employee of the company");
            System.out.println("Type 3 for searching an Employee by EmployeeID");
            System.out.println("Type 4 for searching an Employee by company name");
            int sc = Integer.parseInt(scanner.nextLine());
            EmployeeStorage es = new EmployeeStorage();
            switch (sc) {
                case 0:
                    isRunning = false;
                    break;
                case 1:
                    String employee = scanner.nextLine();
                    es.addEmployee(employee);
                    break;
                case 2:
                    es.print();
                    break;
                case 3:
                    String eID = scanner.nextLine();
                    es.searchByEmployeeID(eID);
                    break;
                case 4:
                    String searchCoName = scanner.nextLine();
                    es.searchByCompanyName(searchCoName);


            }
        }

    }
}



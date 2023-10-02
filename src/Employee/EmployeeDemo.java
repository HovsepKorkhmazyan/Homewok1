package Employee;

import java.util.Scanner;

public class EmployeeDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isEmployee = true;
        while (isEmployee) {
            System.out.println("Type 0 for Exit");
            System.out.println("Type 1 for adding an Employee");
            System.out.println("Type 2 for printing out the names of every Employee of the company");
            System.out.println("Type 3 for searching an Employee by EmployeeID");
            System.out.println("Type 4 for searching an Employee by company name");
            int sc = Integer.parseInt(scanner.nextLine());
            if (sc == 0){
                isEmployee = false;
            }

        }
    }

}

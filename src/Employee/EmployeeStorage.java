package Employee;

public class EmployeeStorage {
    String[] employee = new String[10];
    int size = 0;

    private void extend() {
        String[] temparray = new String[employee.length + 10];
        System.arraycopy(employee, 0, temparray, 0, employee.length);
        employee = temparray;
    }

    public void addEmployee(String employeeName) {
        if (size >= employee.length) {
            extend();
        }
        employee[size++] = employeeName;
    }

    private void print() {
        for (String x : employee) {
            System.out.println(x);

        }
    }

    private String searchByEmployeeID(String employeeID) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].equals(employeeID)) {
                return employee[i];
            }


        }
        return "Employee ID was not found";
    }

    private String searchByCompanyName(String companyName) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].equals(companyName)) {
                return employee[i];
            }


        }
        return "Employee  was not found";
    }
}



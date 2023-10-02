package Employee;

public class EmployeeStorage {
    public String[] employeeStorage = new String[10];
    private int size = 0;

    private void extend() {
        String[] temparray = new String[employeeStorage.length + 10];
        System.arraycopy(employeeStorage, 0, temparray, 0, employeeStorage.length);
        employeeStorage = temparray;
    }

    public void addEmployee(String employeeName) {
        if (size >= employeeStorage.length) {
            extend();
        }
        employeeStorage[size++] = employeeName;
    }

    public void print() {
        for (String x : employeeStorage) {
            System.out.println(x);

        }
    }

    public String searchByEmployeeID(String employeeID) {
        for (int i = 0; i < employeeStorage.length; i++) {
            if (employeeStorage[i].equals(employeeID)) {
                return employeeStorage[i];
            }


        }
        return "Employee ID was not found";
    }

    public String searchByCompanyName(String companyName) {
        for (int i = 0; i < employeeStorage.length; i++) {
            if (employeeStorage[i].equals(companyName)) {
                return employeeStorage[i];
            }


        }
        return "Employee  was not found";
    }
}



package Employee;

public class EmployeeStorage {
    public Employee[] employeeStorage = new Employee[10];
    private int size = 0;

    private void extend() {
        Employee[] temporary = new Employee[employeeStorage.length + 10];
        System.arraycopy(employeeStorage, 0, temporary, 0, employeeStorage.length);
        employeeStorage = temporary;
    }

    public void addEmployee(Employee employee) {
        if (size >= employeeStorage.length) {
            extend();
        }
        employeeStorage[size++] = employee;
    }

    public void print() {
        for (Employee employee : employeeStorage) {
            if (employee != null)
                System.out.println(employee.getName());

        }
    }

    public String searchByEmployeeID(String employeeID) {
        for (int i = 0; i < size; i++) {
            if (employeeStorage[i].getEmployeeID().equals(employeeID)) {
                return employeeStorage[i].getName();
            }


        }
        return "Employee ID was not found";
    }

    public String searchByCompanyName(String companyName) {
        for (int i = 0; i < size; i++) {
            if (employeeStorage[i].getCompany().equals(companyName)) {
                return employeeStorage[i].getCompany();
            }


        }
        return "Employee  was not found";
    }

    public void deleteById(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employeeStorage[i].getEmployeeID().equals(employeeId)) {
                employeeStorage[i] = null;
                size--;
                System.out.println("Employee with ID " + employeeId + " has been deleted.");
            } else {
                System.out.println("Employee with ID " + employeeId + " was not found.");
            }
        }
    }
    public void changeEmployeeById(String employeeId){
        for (int i = 0; i < size; i++) {
            if(employeeStorage[i].getEmployeeID().equals(employeeId)){
                employeeStorage[i].setEmployeeID(employeeId);
            }

        }
    }
}



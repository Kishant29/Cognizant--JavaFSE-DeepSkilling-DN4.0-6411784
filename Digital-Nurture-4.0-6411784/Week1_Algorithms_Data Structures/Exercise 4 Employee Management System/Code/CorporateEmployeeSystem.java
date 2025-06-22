public class CorporateEmployeeSystem {
    class CompanyEmployee {
        int employeeId;
        String name;
        String position;
        double salary;

        public CompanyEmployee(int employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }
    }

    private CompanyEmployee[] employees;
    private int size;
    private int capacity;

    public CorporateEmployeeSystem(int initialCapacity) {
        this.capacity = initialCapacity;
        this.employees = new CompanyEmployee[capacity];
        this.size = 0;
    }

    public void addEmployee(CompanyEmployee employee) {
        if (size == capacity) {
            resizeArray();
        }
        employees[size++] = employee;
    }

    private void resizeArray() {
        capacity *= 2;
        CompanyEmployee[] newArray = new CompanyEmployee[capacity];
        System.arraycopy(employees, 0, newArray, 0, size);
        employees = newArray;
    }

    public CompanyEmployee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i].name + " - " + employees[i].position);
        }
    }

    public void deleteEmployee(int employeeId) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                employees[i] = employees[i + 1];
            }
            size--;
        }
    }

    public static void main(String[] args) {
        CorporateEmployeeSystem ces = new CorporateEmployeeSystem(5);

      
        ces.addEmployee(ces.new CompanyEmployee(101, "John Smith", "Developer", 75000));
        ces.addEmployee(ces.new CompanyEmployee(102, "Sarah Johnson", "Manager", 90000));
        ces.addEmployee(ces.new CompanyEmployee(103, "Mike Brown", "Designer", 65000));

    
        System.out.println("All Employees:");
        ces.traverseEmployees();

     
        CorporateEmployeeSystem.CompanyEmployee emp = ces.searchEmployee(102);
        if (emp != null) {
            System.out.println("\nFound employee: " + emp.name);
        }

       
        ces.deleteEmployee(101);
        System.out.println("\nAfter deletion:");
        ces.traverseEmployees();
    }
}
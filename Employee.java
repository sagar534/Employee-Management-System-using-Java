import java.util.*;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Salary: ₹" + salary;
    }
}

public class EmployeeManagementSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Remove Employee");
            System.out.println("5. Sort by Name");
            System.out.println("6. Sort by Salary");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> displayAll();
                case 3 -> searchEmployee();
                case 4 -> removeEmployee();
                case 5 -> sortByName();
                case 6 -> sortBySalary();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    private static void addEmployee() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        employees.add(new Employee(id, name, salary));
        System.out.println("Employee added!");
    }

    private static void displayAll() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            employees.forEach(System.out::println);
        }
    }

    private static void searchEmployee() {
        System.out.print("Enter ID to search: ");
        int id = scanner.nextInt();
        for (Employee e : employees) {
            if (e.getId() == id) {
                System.out.println(e);
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    private static void removeEmployee() {
        System.out.print("Enter ID to remove: ");
        int id = scanner.nextInt();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                System.out.println("Employee removed.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    private static void sortByName() {
        employees.sort(Comparator.comparing(Employee::getName));
        System.out.println("Sorted by name.");
        displayAll();
    }

    private static void sortBySalary() {
        employees.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        System.out.println("Sorted by salary.");
        displayAll();
    }
}

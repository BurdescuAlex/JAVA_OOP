package unibuc.fulger.Model.Employees;

public abstract class Employees {

    private int employeeID;
    private String name;
    private int salary;
    private static int idCounter;

    public Employees(String name, int salary) {
        idCounter++;
        employeeID = idCounter;
        this.name = name;
        this.salary = salary;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", idCounter=" + idCounter +
                '}';
    }
}

package unibuc.fulger.Repository.EmployeesRepository;
import unibuc.fulger.Model.Employees.Employees;
import unibuc.fulger.Services.EmployeesService.EmployeeServiceIO;

import java.sql.SQLException;
import java.util.Vector;

public class EmployeesRepository {

    private Vector<Employees> employeeList = new Vector<Employees>();
    private Vector<Employees> firedList = new Vector<Employees>();
    private EmployeeServiceIO employeeServiceIO = EmployeeServiceIO.getInstance();

    public EmployeesRepository(){

    }
    public EmployeesRepository(Vector<Employees> employeeList) {
        this.employeeList = employeeList;
    }

    public void add(Employees E) {
        this.employeeList.add(E);
    }

    public void add(Vector<Employees> E) {
        this.employeeList.addAll(E);
    }

    public void addFired(Vector<Employees> E) {
        this.firedList.addAll(E);
    }
    public void fireEmployeeById(int id, String reason)
    {
        for (Employees employee : employeeList){
            if ( employee.getEmployeeID() == id)
            {
                System.out.println("Fired: " + employee.toString() + " " + reason) ;
                firedList.add(employee);
            }
        }
        employeeList.removeIf(p -> p.getEmployeeID() == id);
    }

    public Employees findEmployeeById(int id) {
        for (Employees employee : employeeList){
            if ( employee.getEmployeeID() == id)
            {
                return employee;
            }
        }
        return null;
    }
    public void deleteRecord(int id ) throws SQLException {
        employeeServiceIO.deleteRecord(id);
    }
    public void updateSalary(int id, int salary) throws SQLException {
        employeeServiceIO.changeSalary(id, salary);
    }
    public void insertEmployee(Employees e)
    {
        employeeServiceIO.insertEmployee(e);
    }

    public Vector<Employees> getEmployeeList()
    {
        return employeeList;
    }

    public Vector<Employees> getFiredList() {
        return firedList;
    }
}

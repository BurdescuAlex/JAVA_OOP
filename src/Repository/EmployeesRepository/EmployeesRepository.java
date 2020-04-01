package Repository.EmployeesRepository;
import Model.Employees.Employees;

import java.util.Vector;

public class EmployeesRepository {

    private Vector<Employees> employeeList = new Vector<Employees>();
    private Vector<Employees> firedList = new Vector<Employees>();

    public EmployeesRepository(){

    }
    public EmployeesRepository(Vector<Employees> employeeList) {
        this.employeeList = employeeList;
    }

    public void add(Employees E) {
        this.employeeList.add(E);
    }

    public void fireEmployeeById(int id, String reason)
    {
        for (Employees employee : employeeList){
            if ( employee.getEmployeeID() == id)
            {
                System.out.println("Fired: " + employee.toString() + " " + reason) ;
                firedList.add(employee);
                employeeList.remove(employee);
            }
        }
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

    public Vector<Employees> getEmployeeList()
    {
        return employeeList;
    }

    public Vector<Employees> getFiredList() {
        return firedList;
    }
}

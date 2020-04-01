package Services.EmployeesService;
import Model.Employees.Employees;
import Repository.EmployeesRepository.EmployeesRepository;
import java.util.Vector;

public class EmployeeService {

    private static EmployeeService instance = new EmployeeService();
    private EmployeesRepository employeesRepository = new EmployeesRepository();

    private EmployeeService() {

    }

    public static EmployeeService getInstance() {
        return instance;
    }

    public void addEmployee(Employees E) {
        employeesRepository.add(E);
    }

    public Employees findEmployee(int id) {
        return employeesRepository.findEmployeeById(id);
    }

    public Vector<Employees> getEmployees() {
        return employeesRepository.getEmployeeList();
    }

    public void fireEmployee(int id, String reason )
    {
        employeesRepository.fireEmployeeById(id, reason);
    }

    public String seeEmployees() {
        String Output="";
        Vector<Employees> employeeList = employeesRepository.getEmployeeList();
        for(Employees employee : employeeList){
            Output = Output + employee.toString() + "\n";
        }
        return Output;
    }

    public String seeFiredEmployees() {
        String Output="";
        Vector<Employees> employeeList = employeesRepository.getFiredList();
        for(Employees employee : employeeList){
            Output = Output + employee.toString() + "\n";
        }
        return Output;
    }
}

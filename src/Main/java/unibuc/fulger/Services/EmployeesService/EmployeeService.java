package unibuc.fulger.Services.EmployeesService;
import unibuc.fulger.Model.Employees.Employees;
import unibuc.fulger.Repository.EmployeesRepository.EmployeesRepository;
import unibuc.fulger.Services.AuditService;

import java.sql.SQLException;
import java.util.Vector;

public class EmployeeService {

    private static EmployeeService instance = new EmployeeService();
    private EmployeesRepository employeesRepository = new EmployeesRepository();
    private AuditService auditService = AuditService.getInstance();

    private EmployeeService() {

    }

    public static EmployeeService getInstance() {
        return instance;
    }

    public void addEmployee(Employees E) {
        auditService.writeLog("addEmployee");
        employeesRepository.add(E);
    }
    public void addEmployees(Vector<Employees> E) {
        auditService.writeLog("addEmployees");
        employeesRepository.add(E);
    }
    public void addFiredEmployees(Vector<Employees> E) {
        auditService.writeLog("addFiredEmployees");
        employeesRepository.addFired(E);
    }

    public Employees findEmployee(int id) {
        auditService.writeLog("findEmployee");
        return employeesRepository.findEmployeeById(id);
    }

    public Vector<Employees> getEmployees() {
        auditService.writeLog("getEmployees");
        return employeesRepository.getEmployeeList();
    }
    public Vector<Employees> getFiredEmployees() {
        auditService.writeLog("getFiredEmployees");
        return employeesRepository.getFiredList();
    }

    public void fireEmployee(int id, String reason )
    {
        auditService.writeLog("fireEmployee");
        employeesRepository.fireEmployeeById(id, reason);
    }

    public String seeEmployees() {
        auditService.writeLog("seeEmployees");
        String Output="";
        Vector<Employees> employeeList = employeesRepository.getEmployeeList();
        for(Employees employee : employeeList){
            Output = Output + employee.toString() + "\n";
        }
        return Output;
    }

    public String seeFiredEmployees() {
        auditService.writeLog("seeFiredEmployees");
        String Output="";
        Vector<Employees> employeeList = employeesRepository.getFiredList();
        for(Employees employee : employeeList){
            Output = Output + employee.toString() + "\n";
        }
        return Output;
    }
    public void deleteEmployeeById(int id) throws SQLException {
        auditService.writeLog("deleteEmployeeById");
        employeesRepository.deleteRecord(id);
    }
    public void updateSalaryById(int id, int salary) throws SQLException {
        auditService.writeLog("updateSalaryById");
        employeesRepository.updateSalary(id, salary);
    }
    public void insertEmployeeToDB(Employees e)
    {
        auditService.writeLog("insertEmployeeToDB");
        employeesRepository.insertEmployee(e);
    }
}

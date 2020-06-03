package unibuc.fulger.Services.EmployeesService;

import unibuc.fulger.Model.Employees.CashRegisterSpecialist;
import unibuc.fulger.Model.Employees.Cashier;
import unibuc.fulger.Model.Employees.Employees;
import unibuc.fulger.Services.AuditService;
import unibuc.fulger.Services.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class EmployeeServiceIO {

    private static EmployeeServiceIO instance = new EmployeeServiceIO();
    private Vector<Employees> actualEmployees = new Vector<Employees>();
    private Vector<Employees> firedEmployees = new Vector<Employees>();
    private AuditService auditService = AuditService.getInstance();
    private Connection connection = DBconnection.getDBConnection();

    private EmployeeServiceIO () {}

    public static EmployeeServiceIO getInstance() {
        return instance;
    }

    public Vector<Employees> ReadData()
    {
        auditService.writeLog("ENTER EmployeeServiceIO ReadData");
        try {
            String sqlSelect = "SELECT * FROM  employees";
            PreparedStatement statement =  connection.prepareStatement(sqlSelect);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){

                if(resultSet.getString(2).equals("Cashier") &&  resultSet.getString(8)==null)
                {
                    /// Cahsier: Name, Salary, Experience
                    actualEmployees.add(new Cashier(resultSet.getString(3), resultSet.getInt(4), resultSet.getInt(5)));
                }

                if(resultSet.getString(2).equals("CashRegister") && resultSet.getString(8)==null)
                {
                    /// Cahsier: Name, Salary, Loginid, Passwrod
                    actualEmployees.add(new CashRegisterSpecialist(resultSet.getString(3), resultSet.getInt(4), resultSet.getString(6), resultSet.getString(7)));
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        auditService.writeLog("EXIT EmployeeServiceIO ReadData");
        return actualEmployees;
    }
    public Vector<Employees> ReadFired()
    {
        auditService.writeLog("ENTER EmployeeServiceIO ReadFired");
        try {
            String sqlSelect = "SELECT * FROM  employees";
            PreparedStatement statement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                if (resultSet.getString(2).equals("Cashier") && resultSet.getString(8)!=null) {
                    /// Cahsier: Name, Salary, Experience
                    firedEmployees.add(new Cashier(resultSet.getString(3), resultSet.getInt(4), resultSet.getInt(5)));
                }

                if (resultSet.getString(2).equals("CashRegister") && resultSet.getString(8)!=null) {
                    /// Cahsier: Name, Salary, Loginid, Passwrod
                    firedEmployees.add(new CashRegisterSpecialist(resultSet.getString(3), resultSet.getInt(4), resultSet.getString(6), resultSet.getString(7)));
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        auditService.writeLog("EXIT EmployeeServiceIO ReadFired");
        return firedEmployees;

    }
    public void WriteData(Vector<Employees> actualEmployees, Vector<Employees> firedEmployees)
    {
        auditService.writeLog("ENTER EmployeeServiceIO WriteData");
        try {
            for (Employees employee : actualEmployees) {
                if (employee instanceof  Cashier) {
                    String sqlAdd = "INSERT INTO employees (`type`, `Name`, `Salary`, `Experience`) VALUES (?,?,?,?)";
                    PreparedStatement statement =  connection.prepareStatement(sqlAdd);

                    statement.setString(1,"Cashier");
                    statement.setString(2, employee.getName());
                    statement.setInt(3, employee.getSalary());
                    statement.setInt(4, ((Cashier) employee).getExperience());

                    statement.executeUpdate();
                }
                if (employee instanceof CashRegisterSpecialist)
                {
                    String sqlAdd = "INSERT INTO employees (`type`, `Name`, `Salary`, `LoginId`, `Password`) VALUES (?,?,?,?,?)";
                    PreparedStatement statement =  connection.prepareStatement(sqlAdd);

                    statement.setString(1,"CashRegister");
                    statement.setString(2, employee.getName());
                    statement.setInt(3, employee.getSalary());
                    statement.setString(4, ((CashRegisterSpecialist) employee).getLoginID());
                    statement.setString(5, ((CashRegisterSpecialist) employee).getLoginPass());

                    statement.executeUpdate();
                }
            }
            for (Employees employee : firedEmployees) {
                if (employee instanceof  Cashier) {
                    String sqlAdd = "INSERT INTO employees (`type`, `Name`, `Salary`, `Experience`, `Fired`) VALUES (?,?,?,?,?)";
                    PreparedStatement statement =  connection.prepareStatement(sqlAdd);

                    statement.setString(1,"Cashier");
                    statement.setString(2, employee.getName());
                    statement.setInt(3, employee.getSalary());
                    statement.setInt(4, ((Cashier) employee).getExperience());
                    statement.setString(5, "Fired");

                    statement.executeUpdate();

                }
                if (employee instanceof CashRegisterSpecialist)
                {
                    String sqlAdd = "INSERT INTO employees (`type`, `Name`, `Salary`, `LoginId`, `Password`, `Fired`) VALUES (?,?,?,?,?,?)";
                    PreparedStatement statement =  connection.prepareStatement(sqlAdd);

                    statement.setString(1,"CashRegister");
                    statement.setString(2, employee.getName());
                    statement.setInt(3, employee.getSalary());
                    statement.setString(4, ((CashRegisterSpecialist) employee).getLoginID());
                    statement.setString(5, ((CashRegisterSpecialist) employee).getLoginPass());
                    statement.setString(6, "Fired");

                    statement.executeUpdate();
                }
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        auditService.writeLog("EXIT EmployeeServiceIO WriteData");
    }
    public void insertEmployee(Employees employee)
    {
        auditService.writeLog("ENTER EmployeeServiceIO insertEmployee");
        try {
                if (employee instanceof  Cashier) {
                    String sqlAdd = "INSERT INTO employees (`type`, `Name`, `Salary`, `Experience`) VALUES (?,?,?,?)";
                    PreparedStatement statement =  connection.prepareStatement(sqlAdd);

                    statement.setString(1,"Cashier");
                    statement.setString(2, employee.getName());
                    statement.setInt(3, employee.getSalary());
                    statement.setInt(4, ((Cashier) employee).getExperience());

                    statement.executeUpdate();
                }
                if (employee instanceof CashRegisterSpecialist)
                {
                    String sqlAdd = "INSERT INTO employees (`type`, `Name`, `Salary`, `LoginId`, `Password`) VALUES (?,?,?,?,?)";
                    PreparedStatement statement =  connection.prepareStatement(sqlAdd);

                    statement.setString(1,"CashRegister");
                    statement.setString(2, employee.getName());
                    statement.setInt(3, employee.getSalary());
                    statement.setString(4, ((CashRegisterSpecialist) employee).getLoginID());
                    statement.setString(5, ((CashRegisterSpecialist) employee).getLoginPass());

                    statement.executeUpdate();
                }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        auditService.writeLog("EXIT EmployeeServiceIO insertEmployee");
    }
    public void deleteRecord(int id) throws SQLException {
        auditService.writeLog("EXIT EmployeeServiceIO deleteRecord");
        String sqlDelete = "DELETE FROM employees WHERE id = ?";
        PreparedStatement statement =  connection.prepareStatement(sqlDelete);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    public void changeSalary(int id, int newSalary) throws SQLException {
        String sqlUpdate = "UPDATE employees SET Salary = ? WHERE id = ?";
        PreparedStatement statement =  connection.prepareStatement(sqlUpdate);
        statement.setInt(1, newSalary);
        statement.setInt(2, id);
        statement.executeUpdate();
    }
}
package Services.EmployeesService;


import Model.Employees.CashRegisterSpecialist;
import Model.Employees.Cashier;
import Model.Employees.Employees;
import Services.AuditService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Vector;

public class EmployeeServiceIO {

    private static EmployeeServiceIO instance = new EmployeeServiceIO();
    private static String cashierPath = "src/Data/Cashier.csv";
    private static String firedEmployeesPath = "src/Data/FiredEmployees.csv";
    private static String cashRegisterSpecialistPath = "src/Data/CashRegisterSpecialist.csv";
    private Vector<Employees> actualEmployees = new Vector<Employees>();
    private Vector<Employees> firedEmployees = new Vector<Employees>();
    private AuditService auditService = AuditService.getInstance();

    private EmployeeServiceIO () {}

    public static EmployeeServiceIO getInstance() {
        return instance;
    }

    public Vector<Employees> ReadData()
    {
        auditService.writeLog("ENTER EmployeeServiceIO ReadData");
        Path cashierFile = Paths.get(cashierPath);
        Path cashRegisterFile = Paths.get(cashRegisterSpecialistPath);

        try {
            var inputCashier = Files.readAllLines(cashierFile);
            var inputCashRegister = Files.readAllLines(cashRegisterFile);

            /// tokens[0] Employee Id

            for (String line : inputCashier) {
                String[] tokens = line.split(",");

                ///Cashier: Name, Base Salary , Experience
                actualEmployees.add(new Cashier(tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])));
            }

            for (String line : inputCashRegister) {
                String[] tokens = line.split(",");
                ///Cash Register Specialist: Name, Salary, LoginId, Password
                actualEmployees.add(new CashRegisterSpecialist(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]));
            }
            auditService.writeLog("ENTER EmployeeServiceIO ReadData");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return actualEmployees;
    }
    public Vector<Employees> ReadFired()
    {
        auditService.writeLog("ENTER EmployeeServiceIO ReadFired");
        Path firedFile = Paths.get(firedEmployeesPath);
        try {
            var inputFired = Files.readAllLines(firedFile);

            /// tokens[0] Employee Id

            for (String line : inputFired) {
                String[] tokens = line.split(",");

                if(tokens.length<=4) {
                    ///Cashier: Name, Base Salary , Experience
                    firedEmployees.add(new Cashier(tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])));
                }
                else {
                    ///Cash Register Specialist: Name, Salary, LoginId, Password
                    firedEmployees.add(new CashRegisterSpecialist(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]));
                }
            }
            auditService.writeLog("EXIT EmployeeServiceIO ReadFired");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return firedEmployees;

    }
    public void WriteData(Vector<Employees> actualEmployees, Vector<Employees> firedEmployees)
    {
        auditService.writeLog("ENTER EmployeeServiceIO WriteData");
        Path cashierFile = Paths.get(cashierPath);
        Path firedFile = Paths.get(firedEmployeesPath);
        Path cashRegisterFile = Paths.get(cashRegisterSpecialistPath);

        try {
            var outputCashier = Files.newBufferedWriter(cashierFile);
            var outputCashRegister = Files.newBufferedWriter(cashRegisterFile);
            var outputFired = Files.newBufferedWriter(firedFile);

            for (Employees e : actualEmployees) {

                if (e instanceof Cashier) {
                    outputCashier.write(e.getEmployeeID() + "," + e.getName() + "," + e.getSalary() + "," + ((Cashier) e).getExperience() + "\n");
                }
                if (e instanceof CashRegisterSpecialist) {
                    outputCashRegister.write( e.getEmployeeID() + "," + e.getName() + "," + e.getSalary() + "," + ((CashRegisterSpecialist) e).getLoginID() + "," + ((CashRegisterSpecialist) e).getLoginPass() + "\n");
                }
            }

            for (Employees e : firedEmployees) {

                if (e instanceof Cashier) {
                    outputFired.write(e.getEmployeeID() + "," + e.getName() + "," + e.getSalary() + "," + ((Cashier) e).getExperience() + "\n");
                }
                if (e instanceof CashRegisterSpecialist) {
                    outputFired.write(e.getEmployeeID() + "," + e.getName() + "," + e.getSalary() + "," + ((CashRegisterSpecialist) e).getLoginID() + "," + ((CashRegisterSpecialist) e).getLoginPass() + "\n");
                }
            }
            outputCashier.flush();
            outputCashRegister.flush();
            outputFired.flush();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        auditService.writeLog("EXIT EmployeeServiceIO WriteData");
    }
}
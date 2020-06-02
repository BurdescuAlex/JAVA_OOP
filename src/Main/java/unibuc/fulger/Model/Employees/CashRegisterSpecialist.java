package unibuc.fulger.Model.Employees;

public class CashRegisterSpecialist extends Employees{          //Someone has to manage de problems !
    private String loginID;
    private String loginPass;

    public CashRegisterSpecialist(String name, int salary, String loginID, String loginPass) {
        super(name, salary);
        this.loginID = loginID;
        this.loginPass = loginPass;
    }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getLoginPass() {
        return loginPass;
    }

    public void setLoginPass(String loginPass) {
        this.loginPass = loginPass;
    }

    @Override
    public String toString() {
        return super.toString() + " is " + "CashRegisterSpecialist{" +
                "loginID='" + loginID + '\'' +
                ", loginPass='" + loginPass + '\'' +
                '}';
    }
}

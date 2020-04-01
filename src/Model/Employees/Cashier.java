package Model.Employees;

public class Cashier extends Employees{
    private int experience;  // Years

    public Cashier(String name, int baseSalary, int experience) {
        super(name, baseSalary);
        this.experience = experience;
        setExperienceSalary();
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setExperienceSalary()          //Set salary taking in account experience
    {
        super.setSalary(super.getSalary() * (1 + experience/100));
    }

    @Override
    public String toString() {
        return super.toString() + " is " + "Cashier{" +
                "experience=" + experience +
                '}';
    }
}

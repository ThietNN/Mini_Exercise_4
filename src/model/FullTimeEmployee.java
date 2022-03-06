package model;

public class FullTimeEmployee extends Employee {
    private double basicSalary;
    private double bonus;
    private double penalty;

    public FullTimeEmployee() {
    }

    public FullTimeEmployee(int id, String name, int age, String phone, String mail, double basicSalary, double bonus, double penalty) {
        super(id, name, age, phone, mail);
        this.basicSalary = basicSalary;
        this.bonus = bonus;
        this.penalty = penalty;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }

    @Override
    public double getSalary(){
        double result = basicSalary + bonus - penalty;
        return result;
    }
    @Override
    public String toString() {
        return "FullTimeEmployee{" +
                "id: '" + getId() + '\'' +
                ", fullName: '" + getName() + '\'' +
                ", age: " + getAge() +
                ", phone: '" + getPhone() + '\'' +
                ", email: '" + getMail() + '\'' +
                ", bonus = " + bonus +
                ", penalty = " + penalty +
                ", basic salary = " + basicSalary +
                '}';
    }
}

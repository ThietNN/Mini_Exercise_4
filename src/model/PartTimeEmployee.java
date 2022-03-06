package model;

public class PartTimeEmployee extends Employee{
    private int perHour = 10000;
    private double hour;

    public PartTimeEmployee() {
    }

    public PartTimeEmployee(int id, String name, int age, String phone, String mail, double hour) {
        super(id, name, age, phone, mail);
        this.hour = hour;
    }

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }

    @Override
    public double getSalary(){
        double result = hour * perHour;
        return result;
    }

    @Override
    public String toString() {
        return "PartTimeEmployee{" +
                "id: '" + getId() + '\'' +
                ", fullName: '" + getName() + '\'' +
                ", age: " + getAge() +
                ", phone: '" + getPhone() + '\'' +
                ", email: '" + getMail() + '\'' +
                ", hour = " + hour +
                '}';
    }
}

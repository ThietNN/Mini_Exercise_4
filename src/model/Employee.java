package model;

import java.io.Serializable;

public abstract class Employee implements Serializable, Comparable<Employee> {
    private int id;
    private String name;
    private int age;
    private String phone;
    private String mail;

    public Employee() {
    }

    public Employee(int id, String name, int age, String phone, String mail) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public abstract double getSalary();
    @Override
    public String toString(){
        return "Employee{" +
                "id: '" + id + '\'' +
                ", name: '" + name + '\'' +
                ", age: " + age +
                ", phone: '" + phone + '\'' +
                ", email: '" + mail + '\'' +
                '}';
    }
    @Override
    public int compareTo (Employee employee){
        return Integer.compare(this.id, employee.getId());
    }

}

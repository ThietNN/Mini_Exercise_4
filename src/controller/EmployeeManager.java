package controller;

import model.Employee;
import model.FullTimeEmployee;
import model.PartTimeEmployee;
import storage.EmployeeFromFile;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManager {
    public static EmployeeFromFile employeeData = new EmployeeFromFile();
    public static ArrayList<Employee> employee = employeeData.readFile();


    public static void showMenu() {
        System.out.println("Menu: ");
        System.out.println("1. Hiển thị thông tin của toàn bộ nhân viên");
        System.out.println("2. Thêm nhân viên");
        System.out.println("3. Hiển thị những nhân viên Fulltime có mức lương dưới trung bình");
        System.out.println("4. Hiển thị số lương phải trả cho toàn bộ nhân viên mỗi tháng");
        System.out.println("5. Sắp xếp nhân viên Fulltime theo thứ tự lương tăng dần");
        System.out.println("6. Hiển thị lại menu");
        System.out.println("7. Thoát chương trình");
    }

    public static void getInfo() {
        employee = employeeData.readFile();
        for (Employee eachEmployee : employee)
            System.out.println(eachEmployee.toString());
    }

    public static void update(ArrayList<Employee> newList){
        EmployeeFromFile.writeFile(newList);
    }

    public static void addEmployee(Employee newEmployee) {
        employee = employeeData.readFile();
        employee.add(newEmployee);
        update(employee);
    }

    public static Employee getEmployeeByID(int id) {
        employee = employeeData.readFile();
        for (Employee getEmployee : employee)
            if (getEmployee.getId() == id)
                return getEmployee;
        return null;
    }
    public static void setBasicInfo(){
        checkValidate check = new checkValidate();

    }

    public static void setBasicInfo(Employee employee) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID của nhân viên: ");
        employee.setId(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhập tên của nhân viên: ");
        employee.setName(sc.nextLine());
        System.out.println("Nhập tuổi của nhân viên: ");
        employee.setAge(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhập địa chỉ thư điện tử của nhân viên: ");
        employee.setMail(sc.nextLine());
        System.out.println("Nhập số điện thoại của nhân viên: ");
        employee.setPhone(sc.nextLine());
    }

    public static void setFullTimeInfo(FullTimeEmployee employee) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập lương cứng của nhân viên: ");
        employee.setBasicSalary(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhập tiền thưởng của nhân viên: ");
        employee.setBonus(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhập tiền phạt của nhân viên: ");
        employee.setPenalty(Integer.parseInt(sc.nextLine()));
    }

    public static void setPartTimeInfo(PartTimeEmployee employee) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số giờ làm việc của nhân viên: ");
        employee.setHour(Integer.parseInt(sc.nextLine()));
    }

    public static Employee createNewEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Fulltime / Parttime?");
        System.out.println("Nhập F để thêm mới nhân viên Fulltime, hoặc nhập kí tự bất kì để thêm mới nhân viên Parttime");
        String type = sc.nextLine();
        if (type.equals("F")) {
            FullTimeEmployee newEmployee = new FullTimeEmployee();
            setBasicInfo(newEmployee);
            setFullTimeInfo(newEmployee);
            System.out.println("Đã thêm nhân viên Fulltime mới");
            return newEmployee;
        } else {
            PartTimeEmployee newEmployee = new PartTimeEmployee();
            setBasicInfo(newEmployee);
            setPartTimeInfo(newEmployee);
            System.out.println("Đã thêm nhân viên Parttime mới");
            return newEmployee;
        }
    }

    public static double getSumSalary() {
        double sum = 0;
        for (Employee eachEmployee : employee)
            sum += eachEmployee.getSalary();
        return sum;
    }

    public static double getAverageSalary() {
        double avg;
        avg = getSumSalary() / employee.size();
        return avg;
    }

    public static double getSalary1Type(int choice) {
        int sum = 0;
        if (choice == 1) {
            for (Employee eachEmployee : employee) {
                if (eachEmployee instanceof FullTimeEmployee)
                    sum += eachEmployee.getSalary();
            }
        } else if (choice == 2) {
            for (Employee eachEmployee : employee) {
                if (eachEmployee instanceof PartTimeEmployee)
                    sum += eachEmployee.getSalary();
            }
        }
        return sum;
    }

    public static void getBelowAverage(int choice) {
        employee = employeeData.readFile();
        double avg = getAverageSalary();
        if (choice == 1) {
            for (Employee eachEmployee : employee) {
                if (eachEmployee instanceof FullTimeEmployee)
                    if (eachEmployee.getSalary() < avg)
                        System.out.println(eachEmployee);

            }
        } else if (choice == 2) {
            for (Employee eachEmployee : employee) {
                if (eachEmployee instanceof PartTimeEmployee)
                    if (eachEmployee.getSalary() < avg)
                        System.out.println(eachEmployee);
            }
        }
    }
}

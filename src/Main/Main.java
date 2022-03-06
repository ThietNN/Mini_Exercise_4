package Main;

import model.Employee;
import model.FullTimeEmployee;
import model.PartTimeEmployee;
import storage.EmployeeFromFile;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import static controller.EmployeeManager.*;


public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employeeList = new ArrayList<>();
        Employee employee1 = new FullTimeEmployee(12, "NNT", 24, "123456789", "nnt@gmail.com", 2500000, 120000, 15000);
        employeeList.add(employee1);
        Employee employee2 = new FullTimeEmployee(25,"TNN",24,"987654321","tnn@gmail.com",1200000,250000,30000);
        employeeList.add(employee2);
        Employee employee3 = new PartTimeEmployee(16, "Thiet", 16, "25121998", "thiet@gmail.com", 125);
        employeeList.add(employee3);
        Employee employee4 = new PartTimeEmployee(7, "Nguyen", 7, "19981225", "nguyen@gmail.com", 167);
        employeeList.add(employee4);
        EmployeeFromFile.writeFile(employeeList);

        showMenu();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    getInfo();
                    break;
                case 2:
                    Employee newEmployee = createNewEmployee();
                    addEmployee(newEmployee);
                    break;
                case 3:
                    System.out.println("Những nhân viên Full Time có lương dưới trung bình: ");
                    getBelowAverage(1);
                    break;
                case 4:
                    System.out.println("Tổng số tiền để trả lương cho toàn bộ nhân viên: " + getSumSalary());
                    break;
                case 5:
                    Collections.sort(employeeList); //chua lay dc list moi
                    update(employeeList);
                    break;
                case 6:
                    showMenu();
                    break;
                }
        }while (choice != 7);
    }
}

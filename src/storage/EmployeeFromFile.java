package storage;

import model.Employee;

import java.io.*;
import java.util.ArrayList;

public class EmployeeFromFile {

    public ArrayList<Employee> readFile(){
        File file = new File("employee.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object result = ois.readObject();
            ArrayList<Employee> employee = (ArrayList<Employee>) result;
            ois.close();
            fis.close();
            return employee;
        } catch(IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }


    public static void writeFile(ArrayList<Employee> employee){
        try{
            FileOutputStream fos = new FileOutputStream("employee.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(employee);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

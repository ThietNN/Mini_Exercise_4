package controller;

import java.util.Scanner;

public class checkValidate {
    public int checkAge(){
        Scanner sc = new Scanner(System.in);
        int check = -1;
        try {
            System.out.println("Enter age to check: ");
            check = Integer.parseInt(sc.nextLine());
            if (check <= 0)
                System.err.println("Age can't be below 0! ");
            else if (check >= 100)
                System.err.println("You really lived that long? ");
        }catch (Exception e){
            System.err.println("Age must be an Number! ");
        }
        return check;
    }

    public double checkDouble(){
        Scanner sc = new Scanner(System.in);
        double check = -1;
        try{
            check = Double.parseDouble(sc.nextLine());
            if (check <0){
                System.err.println("A Negative number! Really?");
            }
        }catch (Exception e){
            System.err.println("This must be a Number! ");
        }
        return check;
    }

    public String checkString() {
        Scanner sc = new Scanner(System.in);
        String check = " ";
        check = sc.nextLine();
        if(check.equals("")) {
            System.err.println("Please don't leave the String empty! ");
        }
        return check;
    }
}

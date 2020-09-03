package EmailApp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLength = 8;
    private String department;
    private int mailBoxCapacity;
    private String alternateEmail;

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = this.setDepartment();
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Email created: "
                + this.firstName
                + " \n"
                + this.lastName
                + "\ndep:"
                + department
                + "\npassword:"
                + password);
    }

    private String setDepartment() {
        System.out.println("Department Options:" +
                " \n1 for Sales \n2 for Development \n3 Accounting \n0 for none");

        System.out.println("Enter the department: ");
        Scanner in = new Scanner(System.in);
        int departmentChose =  in.nextInt();
        if (departmentChose == 1) {
            return "sales";
        } else if (departmentChose == 2) {
            return "dev";
        } else if(departmentChose ==3) {
            return "accounting";
        } else {
            return "";
        }
    }

    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!@#$%";
        char[] password = new char[length];
        for(int i = 0; i<length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
}

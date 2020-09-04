package EmailApp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private final int defaultPasswordLength = 8;
    private String department;
    private final String companySuffix = "github.com";
    private int mailBoxCapacity = 500;
    private String alternateEmail;

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = this.setDepartment();
        this.password = randomPassword(defaultPasswordLength);

        email = firstName.toLowerCase()
                + "."
                + lastName.toLowerCase()
                + "@"
                + department
                + "."
                + companySuffix;
    }

    private String setDepartment() {
        System.out.println("New employee: " + this.firstName +  ". Department Options:" +
                " \n1 for Sales \n2 for Development \n3 Accounting \n0 for none");

        System.out.println("Enter the department: ");
        Scanner in = new Scanner(System.in);
        int departmentChose =  in.nextInt();
        if (departmentChose == 1) {
            return "sales";
        } else if (departmentChose == 2) {
            return "dev";
        } else if(departmentChose == 3) {
            return "accounting";
        } else {
            return "default";
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

    public void setMailboxCapacity(int capacity) {
        this.mailBoxCapacity = capacity;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailBoxCapacity() {
        return this.mailBoxCapacity;
    }

    public String getAlternateEmail() {
        return this.alternateEmail;
    }

    public String getPassword() {
        return this.password;
    }

    public String getInfo() {
        return "DISPLAY NAME: " + this.firstName + " " + this.lastName + "\n" +
                "COMPANY EMAIL: " + this.email + "\n" +
                "MAILBOX CAPACITY: " + this.mailBoxCapacity + "mb";
    }
}

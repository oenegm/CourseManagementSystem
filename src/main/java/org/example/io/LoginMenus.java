package org.example.io;

import org.example.user.*;

public class LoginMenus {
    public static User.Type loginType() {
        System.out.println("+-----------------------------------+");
        System.out.println("|      COURSE MANAGEMENT SYSTEM     |");
        System.out.println("+-----------------------------------+");
        System.out.println();
        System.out.println("-----------");
        System.out.println("Login type:");
        System.out.println("-----------");
        System.out.println("1. Administrator");
        System.out.println("2. Instructor");
        System.out.println("3. Student");

        // typeChoice has to be in the range of values of the enum,
        // here, for now [1, 3].
        int typeChoice = InputSystem.userLoginPrompt();

        if (typeChoice == 0) // user choosed exit!
            System.exit(1);

        return User.Type.fromInt(typeChoice);
    }

    public static Admin adminLogin() {
        System.out.println();
        System.out.println("-------------");
        System.out.println("Welcome back,");
        System.out.println("   Admin:    ");
        System.out.println("-------------");

        String username = InputSystem.usernamePrompt();
        String password = InputSystem.passwordPrompt();
        return new Admin(username, password);
    }

    public static Instructor instructorLogin() {
        System.out.println();
        System.out.println("-------------");
        System.out.println("Welcome back,");
        System.out.println(" Instructor: ");
        System.out.println("-------------");

        String username = InputSystem.usernamePrompt();
        String password = InputSystem.passwordPrompt();
        return new Instructor(username, password);
    }

    public static Student studentLogin() {
        System.out.println();
        System.out.println("-------------");
        System.out.println("Welcome back,");
        System.out.println("  Student:   ");
        System.out.println("-------------");

        String username = InputSystem.usernamePrompt();
        String password = InputSystem.passwordPrompt();
        return new Student(username, password);
    }

    public static void greetUser(String username) {
        System.out.println("+-----------------------------------+");
        System.out.println("|      COURSE MANAGEMENT SYSTEM     |");
        System.out.println("+-----------------------------------+");
        System.out.println();
        System.out.println("-".repeat(username.length() + 5));
        System.out.println("Hi, " + username + ":");   // 5 is ("Hi, " + ":").length()
        System.out.println("-".repeat(username.length() + 5));
    }

    public static User unknownLogin() {
        System.out.println();
        System.out.print("Unknown Type ");
        return null;
    }

    public static void loginFailed() {
        System.out.println();
        System.out.println(" Login Failed ");
        InputSystem.waitForKeyPress();
    }

    public static void loginSucceded() {
        System.out.println();
        System.out.println(" Login Succeeded ");
        InputSystem.waitForKeyPress();
    }

    public static void loggingOut() {
        System.out.println();
        System.out.println("Logging out...");
    }
}

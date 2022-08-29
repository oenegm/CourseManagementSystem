package org.example.platform;

import org.example.io.*;
import org.example.user.User;

public class Platform {
    private User user;
    private static Database db;

    public void run() {
        db = new Database();

        while(true) {
            db.connect();

            InputSystem.clearConsole();

            // Login phase
            user = User.login();
            if(user != null && db.userExists(user) ) {
                LoginMenus.loginSucceded();
                user.setLoggedIn(true);
                user.grantAccessTo(db);
            }
            else {
                LoginMenus.loginFailed();
                continue;
            }

            // user session
            while(user.isLoggedIn()) {
                InputSystem.clearConsole();

                // Each user displays & takes his own actions
                user.displayActionsMenu();
                user.takeAction();

                InputSystem.waitForKeyPress();
            }

            db.disconnect();
        }
    }
}

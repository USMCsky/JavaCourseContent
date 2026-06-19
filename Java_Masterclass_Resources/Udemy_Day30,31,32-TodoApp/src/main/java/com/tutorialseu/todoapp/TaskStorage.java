package com.tutorialseu.todoapp;

import java.io.File;

public class TaskStorage {

    private static final String APP_FOLDER_NAME = ".todoapp";  // Hidden folder on Unix-based systems

    public static File getAppDataFolder() {
        String userHome = System.getProperty("user.home");  // Get user's home directory
        File appDataFolder = new File(userHome, APP_FOLDER_NAME);  // Create path to app-specific folder

        if (!appDataFolder.exists()) {
            appDataFolder.mkdir();  // Create the folder if it doesn't exist
        }

        return appDataFolder;
    }
}


package org.example.ui;

import io.appium.java_client.android.AndroidDriver;

public class ScreenFactory {
    private AndroidDriver driver;
    private Menu menu;

    public ScreenFactory(AndroidDriver driver) {
        this.driver = driver;
        this.menu = new Menu(driver);
    }

    public HomeScreen homeScreen() {
        return new HomeScreen(driver, menu);
    }

    public LoginScreen loginScreen() {
        return new LoginScreen(driver, menu);
    }

    public SignUpScreen signUpScreen() {
        return new SignUpScreen(driver, menu);
    }

    public Menu menu() {
        return this.menu;
    }

    public SuccessPopup successPopup() {
        return new SuccessPopup(driver);
    }
}

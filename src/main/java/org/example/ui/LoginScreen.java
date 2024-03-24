package org.example.ui;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginScreen extends CommonActions {


    private String emailInput = "//android.widget.EditText[@content-desc=\"input-email\"]";
    private String passwordInput = "//android.widget.EditText[@content-desc=\"input-password\"]";
    private String loginButton = "//android.view.ViewGroup[@content-desc=\"button-LOGIN\"]/android.view.ViewGroup";
    private String signUpTab = "//android.widget.TextView[@text=\"Sign up\"]";

    protected LoginScreen(AndroidDriver driver, Menu menu) {
        this.driver = driver;
        this.menu = menu;
    }

    public LoginScreen typeEmail(String email) {
        WebElement emailField = waitAndFindElement(driver, emailInput);
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public LoginScreen typePassword(String password) {
        WebElement passwordField = waitAndFindElement(driver, passwordInput);
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        driver.findElement(By.xpath(loginButton)).click();
    }
    public void clickSignUpTab() {
        driver.findElement(By.xpath(signUpTab)).click();
    }

}

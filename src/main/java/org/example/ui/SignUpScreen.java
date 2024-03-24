package org.example.ui;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SignUpScreen extends CommonActions {

    private String emailInput = "//android.widget.EditText[@content-desc=\"input-email\"]";
    private String passwordInput = "//android.widget.EditText[@content-desc=\"input-password\"]";
    private String confirmPasswordInput = "//android.widget.EditText[@content-desc=\"input-repeat-password\"]";
    private String signUpButton = "//android.view.ViewGroup[@content-desc=\"button-SIGN UP\"]/android.view.ViewGroup";

    protected SignUpScreen(AndroidDriver driver, Menu menu) {
        this.driver = driver;
        this.menu = menu;
    }

    public SignUpScreen typeEmail(String email) {
        WebElement emailField = waitAndFindElement(driver, emailInput);
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public SignUpScreen typePassword(String password) {
        WebElement passwordField = waitAndFindElement(driver, passwordInput);
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public SignUpScreen confirmPassword(String password) {
        WebElement confirmPasswordField = waitAndFindElement(driver, confirmPasswordInput);
        confirmPasswordField.clear();
        confirmPasswordField.sendKeys(password);
        return this;
    }

    public void clickSignUpButton() {
        driver.findElement(By.xpath(signUpButton)).click();
    }


}

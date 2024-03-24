package org.example.ui;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class SuccessPopup extends CommonActions {

    private String successTitle = "//android.widget.TextView[@resource-id=\"android:id/alertTitle\"]";
    private String successDescription = "//android.widget.TextView[@resource-id=\"android:id/message\"]";
    private String okButton = "//android.widget.Button[@resource-id=\"android:id/button1\"]";
    private String errorText = "";

    SuccessPopup(AndroidDriver driver) {
        this.driver = driver;
    }

    public String getSuccessTitleText() {
        return waitAndFindElement(driver, successTitle).getText();
    }

    public String getErrorText() {
        return waitAndFindElement(driver, errorText).getText();
    }

    public String getSuccessDescriptionText() {
        return waitAndFindElement(driver, successDescription).getText();

    }

    public void clickOkButton() {
        driver.findElement(By.xpath(okButton)).click();

    }
}

package org.example.ui;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HomeScreen extends CommonActions {
    private By header = By.xpath("//android.widget.TextView[@text=\"WEBDRIVER\"]");
    private By descriptionText = By.xpath("//android.widget.TextView[@text=\"Demo app for the appium-boilerplate\"]");


    protected HomeScreen(AndroidDriver driver, Menu menu) {
        this.driver = driver;
        this.menu = menu;
    }

    public String getHeaderText() {
        return waitAndFindElement(driver, header).getText();
    }

    public String getDescriptionText() {
        return waitAndFindElement(driver, descriptionText).getText();
    }

}

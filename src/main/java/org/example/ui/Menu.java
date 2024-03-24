package org.example.ui;

import io.appium.java_client.android.AndroidDriver;

public class Menu extends CommonActions {

    private AndroidDriver driver;

     Menu(AndroidDriver driver) {
        this.driver = driver;
    }

    private String loginItem = "//android.widget.TextView[@text=\"Login\"]";

    public void clickLoginItem() {
        waitAndFindElement(driver, loginItem).click();
    }


}

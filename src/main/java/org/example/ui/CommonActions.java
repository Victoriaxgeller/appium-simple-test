package org.example.ui;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public abstract class CommonActions {
    protected AndroidDriver driver;
    protected Menu menu;

    protected WebElement waitAndFindElement(AndroidDriver driver, By by) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class).until(driver1 -> driver1.findElement(by));

    }

    protected WebElement waitAndFindElement(AndroidDriver driver, String xpath) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class).until(driver1 -> driver1.findElement(By.xpath(xpath)));

    }
}

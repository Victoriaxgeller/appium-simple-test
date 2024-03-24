import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class FluentWaitExample {
    WebDriver driver;

    public FluentWaitExample(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitAndFindElement(By by) {
         return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class).until(driver1 -> driver1.findElement(by));

    }
}
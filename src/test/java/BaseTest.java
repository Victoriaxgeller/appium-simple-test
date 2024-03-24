import com.github.javafaker.Faker;
import io.appium.java_client.android.AndroidDriver;
import org.example.AndroidDevice;
import org.example.ui.ScreenFactory;
import org.example.driver.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class BaseTest {
    protected AndroidDriver driver;
    protected FluentWait<WebDriver> wait;
    protected ScreenFactory factory;
    protected Faker faker = new Faker();


//    @BeforeMethod
    public AndroidDriver setup(AndroidDevice androidDevice) throws MalformedURLException {
        AndroidDriver driver = new DriverSetup().init(androidDevice);
        factory = new ScreenFactory(driver);
        return driver;
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }

}

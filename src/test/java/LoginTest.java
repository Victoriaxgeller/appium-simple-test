import io.appium.java_client.android.AndroidDriver;
import org.example.AndroidDevice;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;


public class LoginTest extends BaseTest {

    @Test(description = "Success login with correct data")
    public void userCanLoginWithCorrectDataDEVICE_TEST_API_34() throws MalformedURLException {
        driver = setup(AndroidDevice.DEVICE_TEST_API_34);
        factory.menu().clickLoginItem();
        factory.loginScreen()
                .typeEmail(faker.internet().emailAddress())
                .typePassword(faker.internet().password())
                .clickLoginButton();

        String success = factory.successPopup().getSuccessTitleText();
        String description = factory.successPopup().getSuccessDescriptionText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(success, "Success", "Title is incorrect");
        softAssert.assertEquals(description, "You are logged in!", "Description text is incorrect");
        softAssert.assertAll();
    }
}

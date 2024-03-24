import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;

import static org.example.AndroidDevice.PIXEL_8_PRO_API_30;


public class RegistrationTest extends BaseTest {

//    protected AndroidDriver driver;

    @Test(description = "Success registration with correct data")
    public void userCanSignUpWithCorrectDataPIXEL_8_PRO_API_30() throws MalformedURLException {
        driver = setup(PIXEL_8_PRO_API_30);
        String password = faker.internet().password();
        factory.menu().clickLoginItem();
        factory.loginScreen().clickSignUpTab();
        factory.signUpScreen().typeEmail(faker.internet().emailAddress())
                .typePassword(password)
                .confirmPassword(password)
                .clickSignUpButton();

        String success = factory.successPopup().getSuccessTitleText();
        String description = factory.successPopup().getSuccessDescriptionText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(success, "Signed Up!", "Title is incorrect");
        softAssert.assertEquals(description, "You successfully signed up!", "Description text is incorrect");
        softAssert.assertAll();
    }


}

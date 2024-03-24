import org.example.AndroidDevice;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;


public class LoginTest2 extends BaseTest {


    @Test(description = "Success login with correct data")
    public void userCanLoginWithCorrectDataPIXEL_FOLD_API_32() throws MalformedURLException {
        driver = setup(AndroidDevice.PIXEL_FOLD_API_32);
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

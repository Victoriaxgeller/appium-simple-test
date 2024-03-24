import org.example.AndroidDevice;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;


public class IncorrectLoginTest extends BaseTest {
    @Test(description = "Success login with correct data")
    public void usercanNotLoginWithIncorrectEmail() throws MalformedURLException {
        driver = setup(AndroidDevice.PIXEL_FOLD_API_32);
        factory.menu().clickLoginItem();
        factory.loginScreen()
                .typeEmail(faker.internet().domainName())
                .typePassword(faker.internet().password())
                .clickLoginButton();

        String errorText = factory.successPopup().getErrorText();
        String description = factory.successPopup().getSuccessDescriptionText();

        Assert.assertEquals(errorText, "Invalid email", "Title is incorrect");
    }
}

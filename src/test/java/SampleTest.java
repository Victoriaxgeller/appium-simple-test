
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Arrays;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.xml.dom.Reflect;

public class SampleTest extends BaseTest {

    @Test
    public void toolBarTest() throws MalformedURLException, InterruptedException {
        Assert.assertEquals(driver.findElement(By.xpath("//android.widget.TextView[@text=\"WEBDRIVER\"]")).getText(), "WEBDRIVER");
    }


    @Test
    public void putTogetherARobot() {
        driver.findElement(By.xpath("//android.view.View[@content-desc=\"Drag\"]")).click();

        boolean b = wait.until(driver -> driver.findElement(By.xpath(
                        "//android.view.ViewGroup[@content-desc=\"Drag-drop-screen\"]/android.widget.ImageView")))
                .isDisplayed();
        Assert.assertTrue(b);

        WebElement element12 = fluent.waitAndFindElement(
                By.xpath("//android.view.ViewGroup[@content-desc=\"drag-l2\"]/android.widget.ImageView"));

    }

    @Test
    public void testRecorder() throws InterruptedException {
        fluent.waitAndFindElement(By.xpath("//android.widget.TextView[@text=\"Demo app for the appium-boilerplate\"]")).click();
        fluent.waitAndFindElement(By.xpath("//android.widget.TextView[@text=\"\uDB80\uDDDB\"]")).click();
        WebElement puzzleElement = fluent.waitAndFindElement(By.xpath("//android.view.ViewGroup[@content-desc=\"drag-l2\"]/android.widget.ImageView"));
        puzzleElement.click();
        boolean before = puzzleElement.isDisplayed();
        swapForBigScreen();
        boolean after = puzzleElement.isDisplayed();
        System.out.println("AAAA "+ before + after);
        Assert.assertNotEquals(before, after);


    }

    private void step2() throws InterruptedException {

        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var start = new Point(190, 2493);
        var end = new Point(440, 983);
        var swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));

        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));

        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));

        Thread.sleep(2000);

    }

    private void swapForBigScreen(){
        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var start = new Point(249, 1804);
        var end = new Point (716, 793);
        var swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));

    }

}
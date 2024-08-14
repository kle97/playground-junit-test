package io.playground.junittest.test;

import io.playground.junittest.common.BaseTest;
import io.playground.junittest.common.Reporter;
import io.playground.junittest.context.TestContext;
import io.playground.junittest.page.EntityPage;
import io.playground.junittest.page.Pages;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Slf4j
@RequiredArgsConstructor
public class SampleTest1 extends BaseTest {
    
    private final WebDriver driver;
    private final TestContext context;
    
    @BeforeClass
    public void beforeClass() {
        Reporter.appendReport("SampleTest1 - " + context.getName());
        driver.get("https://www.smogon.com/dex/bw/pokemon/" + context.getName().replace(".", "").replace(" ", "-").toLowerCase());
        Reporter.addScreenshotFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64),
                                               context.getName());
    }
    
    @Test
    public void test1() {
        EntityPage entityPage = Pages.getEntityPage(driver);
        softly().as("Verify %s's name", context.getName())
                .assertThat(entityPage.getName())
                .isEqualToIgnoringCase(context.getName());
    }

    @Test
    public void test2() {
        EntityPage entityPage = Pages.getEntityPage(driver);
        softly().as("Verify %s's type(s)", context.getName())
                .assertThat(entityPage.getTypes())
                .containsExactlyInAnyOrderElementsOf(context.getTypes());
    }
}

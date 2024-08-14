package io.playground.junittest.tp;

import io.playground.junittest.common.BaseTP;
import io.playground.junittest.common.TestRunnerOption;
import io.playground.junittest.context.TestContext;
import io.playground.junittest.test.SampleTest1;
import io.playground.junittest.test.SampleTest2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SampleIT extends BaseTP {
    
    private WebDriver driver1;
    private WebDriver driver2;

    @BeforeAll
    public void beforeClass() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        
        Runtime.getRuntime().addShutdownHook(new Thread(() -> driver1.quit()));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> driver2.quit()));
        driver1 = new ChromeDriver(options);
        driver2 = new ChromeDriver(options);
    }

    @AfterAll
    public void afterClass() {
        driver1.quit();
        driver2.quit();
    }
    
    @DataProvider
    public Object[][] sampleContexts() {
        List<TestContext> contexts = new ArrayList<>();
        contexts.add(TestContext.builder().name("Azumarill").types(List.of("Water")).build());
        contexts.add(TestContext.builder().name("Azurill").types(List.of("Normal")).build());
        contexts.add(TestContext.builder().name("Cottonee").types(List.of("Grass")).build());
        contexts.add(TestContext.builder().name("Clefable").types(List.of("Normal")).build());
        contexts.add(TestContext.builder().name("Clefairy").types(List.of("Normal")).build());
        contexts.add(TestContext.builder().name("Cleffa").types(List.of("Normal")).build());
        contexts.add(TestContext.builder().name("Gardevoir").types(List.of("Psychic")).build());
        contexts.add(TestContext.builder().name("Granbull").types(List.of("Normal")).build());
        contexts.add(TestContext.builder().name("Igglybuff").types(List.of("Normal")).build());
        contexts.add(TestContext.builder().name("Jigglypuff").types(List.of("Normal")).build());
        contexts.add(TestContext.builder().name("Kirlia").types(List.of("Psychic")).build());
        contexts.add(TestContext.builder().name("Magnemite").types(List.of("Electric", "Steel")).build());
        contexts.add(TestContext.builder().name("Magneton").types(List.of("Electric", "Steel")).build());
        contexts.add(TestContext.builder().name("Marill").types(List.of("Water")).build());
        contexts.add(TestContext.builder().name("Mawile").types(List.of("Steel")).build());
        contexts.add(TestContext.builder().name("Mime Jr.").types(List.of("Psychic")).build());
        contexts.add(TestContext.builder().name("Mr. Mime").types(List.of("Psychic")).build());
        contexts.add(TestContext.builder().name("Ralts").types(List.of("Psychic")).build());
        contexts.add(TestContext.builder().name("Rotom").types(List.of("Electric", "Ghost")).build());
        contexts.add(TestContext.builder().name("Snubbull").types(List.of("Normal")).build());
        contexts.add(TestContext.builder().name("Togekiss").types(List.of("Normal", "Flying")).build());
        contexts.add(TestContext.builder().name("Togepi").types(List.of("Normal")).build());
        contexts.add(TestContext.builder().name("Togetic").types(List.of("Normal", "Flying")).build());
        contexts.add(TestContext.builder().name("Wigglytuff").types(List.of("Normal")).build());
        return listTo2DArray(contexts);
    }
    
    @Test(dataProvider = "sampleContexts")
    public void sampleTP(TestContext context) {
        runTests(TestRunnerOption.builder().parallelMode(XmlSuite.ParallelMode.INSTANCES).build(), 
                 new SampleTest1(driver1, context), 
                 new SampleTest2(driver2, context));
    }
}

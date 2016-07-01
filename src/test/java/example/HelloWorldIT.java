package example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class HelloWorldIT {

    WebDriver driver;
    DesiredCapabilities capability = DesiredCapabilities.firefox();
    String baseUrl;

    @Before
    public void setUp() throws MalformedURLException {
        baseUrl = "http://" + System.getProperties().getProperty("nginxIP");
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
        driver.get(baseUrl);
    }


    @Test
    public void shouldMatchTitle() {
        String title = driver.getTitle();
        assert (title.contentEquals("Boring static demo page"));
    }

    @Test
    public void shouldSayHelloWorld() {
        String body = driver.findElement(By.xpath("//html/body/p")).getText();
        assert (body.contentEquals("Hello world!"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
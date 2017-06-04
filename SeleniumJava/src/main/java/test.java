

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class test {
        private WebDriver driver = null;

        @Before
        public void openBrowser() {
                URL url = null;
                try {
                        url = new URL("http://localhost:4444/wd/hub");

                }catch (MalformedURLException e)
                {
                        assert Boolean.FALSE;
                }
                this.driver = new RemoteWebDriver(url, DesiredCapabilities.chrome());
                this.driver.get("http://google.com");



        }

        @After
        public void saveScreenshotAndCloseBrowser() throws IOException {

                this.driver.quit();
        }

        @Test
        public void pageTitleAfterSearchShouldBeginWithDrupal() throws IOException {

                assertEquals("The page title should equal Google at the start of the test.", "Google", this.driver.getTitle());
                WebElement searchField = this.driver.findElement(By.name("q"));
                searchField.sendKeys("Drupal!");
                searchField.submit();
                new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains("drupal"));
                assertTrue("The page title should start with the search string after the search.",
                        this.driver.getTitle().toLowerCase().startsWith("drupal!"));
        }


}
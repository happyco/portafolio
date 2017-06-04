package Environment;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class Environment {
    public WebDriver driver = null;
    private static Environment ourInstance = new Environment();

    public static Environment getInstance() {
        return ourInstance;
    }

    public Boolean EnvironmentInit() {
        URL url = null;
        try {
            url = new URL("http://localhost:4444/wd/hub");

        }catch (MalformedURLException e)
        {
            return Boolean.FALSE;
        }
        driver = new RemoteWebDriver(url, DesiredCapabilities.chrome());
        return Boolean.TRUE;
    }

}

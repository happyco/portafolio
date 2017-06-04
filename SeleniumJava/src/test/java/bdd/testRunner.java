package bdd;

import Environment.Environment;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import static org.junit.Assert.assertTrue;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/bdd/features/"
        ,glue={"bdd/step_definitions/"}
)
public class testRunner {
    @BeforeClass
    public static void setUp() {
        assertTrue("Problem to setup the Environment",(Environment.getInstance().EnvironmentInit()));
    }

    @AfterClass
    public static void tearDown(){
        //Environment.getInstance().driver.close();

    }
}
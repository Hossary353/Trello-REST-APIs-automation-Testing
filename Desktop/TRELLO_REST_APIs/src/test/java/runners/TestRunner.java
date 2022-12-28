package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

        @CucumberOptions(
        features = "src/main/resources/Features",
        glue = {"stepDefs"},
        plugin = { "pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json",
                "junit:target/cukes.xml",
                "rerun:target/rerun.txt"},
        tags = "@smoke")
public class TestRunner extends AbstractTestNGCucumberTests {

}

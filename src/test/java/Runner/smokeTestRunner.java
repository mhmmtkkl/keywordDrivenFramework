package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"html:target/cucumber-report" , "json:target/cucumber.json"},
        tags = "@SmokeTest",
        features = {"src/test/resources"},
        glue = {"stepDefinition"},
        dryRun = false

)

public class smokeTestRunner {

}

    /*
        I am able to create one framework which is keyword driven framework with bdd.

        Log4J I can implement log4j in my framework it will give me report for each step which I do in the framework


        Disadvantage:
            Some companies BA or PO is writing feature files.

    */
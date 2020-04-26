package utilities;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    /*
        Singleton driver

         I was calling this driver from multiple pages and it should be static

        ------

        this framework driver is non static

        Because we are calling the driver from one class which is keywordEngine. Basically we are not moving from one class to other like in POM

     */

    WebDriver driver;

    ReadProperty getProperties = new ReadProperty();

    public WebDriver getDriver(){

        if(getProperties.getData("browser").equalsIgnoreCase("Chrome")){

            ChromeDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        return driver;
    }





}
